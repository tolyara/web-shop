package Storages;

import Models.Product;
import Service.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс описывает работу клиники, где в качестве хранилища используется базы
 * данных. В качестве СУБД использую PosgreSQL 10 (PgAdmin 4).
 * 
 * @author tolyara
 * @since 12.11.2017
 */

public class WebShopJDBC implements Storage {

	private Connection connection;
	private static final String QUERY_SELECT_ALL_PRODUCTS = "select * from products order by product_id";
	private static final String QUERY_INSERT_PRODUCT = "insert into products (product_name) values (?);";
	private static final String QUERY_UPDATE_PRODUCT = "update products as products set product_name = ? where products.product_id = ?;";
	private static final String QUERY_DELETE_PRODUCT = "delete from products as products where products.product_id = ?;";

	public WebShopJDBC() {
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
						new Product(rs.getInt("product_id"), rs.getString("product_name")));
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
			// statement.setString(2, client.getName());
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
	 * TODO - данный метод переписать с помощью select...
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
			// statement.setString(3, newName);
			// statement.setInt(4, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int id) {
		try (final PreparedStatement statement = this.connection
				.prepareStatement(QUERY_DELETE_PRODUCT)) {
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

}
