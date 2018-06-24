package storages;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import models.Account;
import models.Order;
import models.Product;

/**
 * Класс описывает работу интернет-магазина товаров, реализованного в виде
 * web-приложения. В данной реализации в качестве хранилища данных будут
 * использованы стандартные средства Java - коллекции (в частности
 * ConcurrentHashMap). На протяжении всего жизненного цикла приложения создается
 * только один экземпляр данного класса (шаблон проектирования Singleton).
 * 
 * @author Anatolii Melchenko
 */

public class WebShop implements Storage {

	/*
	 * Каталог товаров
	 */
	private final ConcurrentHashMap<Integer, Product> products;
	
	/**
	 * Счетчик ID товара. Генерируется автоматически при каждом добавлении новой
	 * позиции товара.
	 */
	public static AtomicInteger countProductsID = new AtomicInteger();

	private static final WebShop INSTANCE = new WebShop();

	private WebShop() {
		products = new ConcurrentHashMap<>();
		fillShop();
	}

	@Override
	public int generateProductId() {
		return countProductsID.incrementAndGet();
	}

	@Override
	public ConcurrentHashMap<Integer, Product> getProducts() {
		return products;
	}

	/*
	 * Метод возвращает экземпляр магазина.
	 */
	public static WebShop getInstance() {
		return INSTANCE;
	}

	@Override
	public Product getProductById(int id) {
		return products.get(id);
	}

//	@Override
	public void editProduct(int id, String newProductName) {
		// clients.get(id).setSurname(newSurname);
		products.get(id).setProductName(newProductName);
	}

	@Override
	public void deleteProduct(int id) {
		products.remove(id);
	}

	// Найти объект типа Product по названию.
	// Поиск не чувствителен к регистру.
	@Override
	public Product getProductByProductName(String productName) {
		Product foundedProduct = new Product(); // Здесь названию товара присваиваем ссылку на null.
		for (Product product : this.products.values()) {
			if (product.getProductName().equalsIgnoreCase(productName)) {
				foundedProduct = product;
			}
		}
		return foundedProduct;
	}

	/*
	 * Добавить товар в магазин.
	 */
	@Override
	public int addProduct(Product product) {
		this.products.put(product.getId(), product);
		return product.getId();
	}

	/*
	 * Добавить товар с конкретным ключом.
	 */
	public void addProduct(int ID, Product client) {
		this.products.put(ID, client);
	}

	// ------------------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------------------

	/*
	 * Метод заполняет магазин исходными данными. ВАЖНО! Данные, которыми в этом
	 * методе заполняется магазин, используются в юнит-тестах. Без необходимости
	 * данные не менять!
	 */
	private void fillShop() {
		/*
		 * Заполняем каталог товаров определенными исходными значениями
		 */
		addProduct(new Product(generateProductId(), "Системный блок Everest"));
		addProduct(new Product(generateProductId(), "Монитор ASUS"));
		addProduct(new Product(generateProductId(), "Клавиатура Logitech"));
		addProduct(new Product(generateProductId(), "Мышь Havit"));
		addProduct(new Product(generateProductId(), "Ноутбук Lenovo"));
		addProduct(new Product(generateProductId(), "Роутер TP-Link"));
	}

	/*
	 * Создаем заглушку для метода close(), определенного в интерфейсе-предке.
	 */
	@Override
	public void close() {

	}

	@Override
	public String checkAccountRole(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkLoginPassword(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int makeOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int generateOrderId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ConcurrentHashMap<Integer, Order> getUserOrders(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editProduct(int id, String newProductName, int newCategoryId, String newManufacturerName,
			Double newPrice, Date newDate, String newColour, String newSize, int newAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConcurrentHashMap<Integer, Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeOrderStatus(int orderId, String newOrderStatus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConcurrentHashMap<String, Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeAccountStatus(String login, Boolean currentStatus) {
		// TODO Auto-generated method stub
		
	}

}
