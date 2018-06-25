package storages;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import models.Account;
import models.Order;
import models.Product;

/**
 * Интерфейс определяет основные методы для работы с хранилищем данных в
 * web-приложении.
 * 
 * @author Anatolii Melchenko
 */
public interface Storage {

	/*
	 * Метод используется для корректного закрытия соединения с БД
	 */
	public void close();

	/*
	 * Методы для работы с товарами
	 */
	ConcurrentMap<Integer, Product> getProducts();
	
	public int addProduct(Product product);

	public int generateProductId();

	public Product getProductById(int id);

	public void deleteProduct(int id);

	public void editProduct(int id, String newProductName, int newCategoryId, String newManufacturerName, Double newPrice, Date newDate, String newColour, String newSize, int newAmount);

	Product getProductByProductName(String productName);

	/*
	 * Методы для входа в систему
	 */
	public String checkAccountRole(String login);
	
	public boolean checkLoginPassword(String login, String password);

	/*
	 * Методы для работы с заказами
	 */	
	public int makeOrder(Order order);

	public int generateOrderId();

	public ConcurrentHashMap<Integer, Order> getUserOrders(String login);
	
	public ConcurrentHashMap<Integer, Order> getAllOrders();
	
	public void changeOrderStatus(int orderId, String newOrderStatus);	
	
	/*
	 * Методы для работы с аккаунтами
	 */
	public ConcurrentHashMap<String, Account> getAccounts();

	public void changeAccountStatus(String login, Boolean currentStatus);

	public void addAccount(String role, Account account);

}
