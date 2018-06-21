package storages;

import models.Order;
import models.Product;
import service.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс описывает работу магазина, где в качестве хранилища используется база
 * данных. В качестве СУБД используется PosgreSQL 10 (PgAdmin 4).
 * 
 * @author tolyara
 * @since 12.11.2017
 */

public class WebShopJDBC implements Storage {

	private Connection connection;
	private static final String QUERY_SELECT_ALL_PRODUCTS = "select * from products order by product_id;";
	private static final String QUERY_INSERT_PRODUCT = "insert into products (product_name) values (?);";
	private static final String QUERY_UPDATE_PRODUCT = "update products as products set product_name = ? where products.product_id = ?;";
	private static final String QUERY_DELETE_PRODUCT = "delete from products as products where products.product_id = ?;";
	private static final String QUERY_SELECT_ALL_ROLES = "select * from account_roles;";
	private static final String QUERY_SELECT_ALL_ACCOUNTS = "select * from accounts;";
	private static final String QUERY_INSERT_ORDER = "insert into orders (account_name_fk, status) values (?, ?);";
	private static final String QUERY_INSERT_INTO_ORDER_PRODUCT = "insert into order_product (order_id, product_id, product_name, product_amount) values (?, ?, ?, ?);";

	/*
	 * Default constructor is used if we want to use JDBC connection through Tomcat
	 * connection pool.
	 */
	public WebShopJDBC() {
		this.connection = ConnectionPool.getInstance().getConnection();
	}

	/*
	 * This constructor is used if we want to use classic JDBC without a connection
	 * pool. To use it you need to pass any string as argument (particularly, change
	 * WebShopJDBC constructor type in class StorageIdentifier).
	 */
	public WebShopJDBC(String oneConnection) {
		final Settings settings = Settings.getInstance();
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"),
					settings.value("jdbc.password"));
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ConcurrentHashMap<Integer, Product> getProducts() {
		final ConcurrentHashMap<Integer, Product> products = new ConcurrentHashMap<>();
		/*
		 * Для автоматического закрытия соединения с БД используется конструкция
		 * try-with-resources, которую можно применять с любыми объектами, относящимися
		 * к интерфейсу AutoCloseable. В данном случае это объект Statement.
		 */
		try (final Statement statement = this.connection.createStatement();
				final ResultSet rs = statement.executeQuery(QUERY_SELECT_ALL_PRODUCTS)) {
			while (rs.next()) {
				products.put(rs.getInt("product_id"),
						new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("category_id_fk"),
								rs.getString("manufacturer_name_fk"), rs.getDouble("price"),
								rs.getDate("creation_date"), rs.getString("colour"), rs.getString("size"),
								rs.getInt("amount_in_storage")));
				// products.put(rs.getInt("product_id"),
				// new Product(rs.getInt("product_id"), rs.getString("product_name"),
				// rs.getInt("category_id_fk")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	// ------------------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------------

	@Override
	public int addProduct(Product product) {
		int addedProductId = -1;
		try (final PreparedStatement statement = this.connection.prepareStatement(QUERY_INSERT_PRODUCT,
				Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, product.getProductName());
			statement.executeUpdate();
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					addedProductId = generatedKeys.getInt(1);
				} else {
					throw new IllegalStateException("Could not add new product to DB!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addedProductId;
	}

	/*
	 * Создаем заглушку для метода generateProductId(), определенного в
	 * интерфейсе-предке.
	 */
	@Override
	public int generateProductId() {
		return 7;
	}

	/*
	 * TODO - данный метод переписать с помощью select... UPD - способ не найден
	 */
	@Override
	public Product getProductById(int id) {
		return this.getProducts().get(id);
	}

	@Override
	public void editProduct(int id, String newProductName) {
		try (final PreparedStatement statement = this.connection.prepareStatement(QUERY_UPDATE_PRODUCT)) {
			statement.setString(1, newProductName);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int id) {
		try (final PreparedStatement statement = this.connection.prepareStatement(QUERY_DELETE_PRODUCT)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * TODO - данный метод переписать с помощью select...
	 */
	@Override
	public Product getProductByProductName(String productName) {
		Product foundedProduct = new Product();
		try {
			for (Product product : this.getProducts().values()) {
				if (product.getProductName().equalsIgnoreCase(productName)) {
					foundedProduct = product;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundedProduct;
	}

	// ------------------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------------

	@Override
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String checkAccountRole(String login) {
		String foundedRole = new String();
		try (final Statement statement = this.connection.createStatement();
				final ResultSet rs = statement.executeQuery(QUERY_SELECT_ALL_ROLES)) {
			while (rs.next()) {
				/*
				 * Сравниваем логины из таблицы БД account_roles с переданным через параметр
				 * логином аккаунта
				 */
				if (rs.getString("account_name_fk").equals(login)) {
					foundedRole = rs.getString("role_name");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foundedRole;
	}

	@Override
	public boolean checkLoginPassword(String login, String password) {
		boolean authenticationResult = false;
		try (final Statement statement = this.connection.createStatement();
				final ResultSet rs = statement.executeQuery(QUERY_SELECT_ALL_ACCOUNTS)) {
			while (rs.next()) {
				/*
				 * Сравниваем логин из таблицы БД accounts с переданным через параметр логином
				 * аккаунта
				 */
				if (rs.getString("account_name").equals(login)) {
					/*
					 * Сравниваем пароль данного логина из таблицы БД accounts с переданным через
					 * параметр паролем
					 */
					if (rs.getString("account_pass").equals(password)) {
						authenticationResult = true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authenticationResult;
	}

	@Override
	public int makeOrder(Order order) {
		int addedOrderId = -1;
		/* Сначала добавим новый заказ в таблицу orders */
		try (final PreparedStatement statement = this.connection.prepareStatement(QUERY_INSERT_ORDER,
				Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, order.getUserLogin());
			statement.setString(2, order.getStatus().toString());
			statement.executeUpdate();
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					addedOrderId = generatedKeys.getInt(1);
				} else {
					throw new IllegalStateException("Could not add new product to DB!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println(addedOrderId);
		/* Затем добавляем информацию в таблицу order_product */
		try (final PreparedStatement statement = this.connection.prepareStatement(QUERY_INSERT_INTO_ORDER_PRODUCT)) {
			for (Product product : order.getOrderedProducts().values()) {
			statement.setInt(1, addedOrderId);
			statement.setInt(2, product.getId());
			statement.setString(3, product.getProductName());
			statement.setInt(4, product.getAmount());
			statement.executeUpdate();
			statement.clearParameters();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addedOrderId;
	}

	/*
	 * Создаем заглушку для метода generateOrderId(), определенного в
	 * интерфейсе-предке.
	 */
	@Override
	public int generateOrderId() {
		return 7;
	}

}
