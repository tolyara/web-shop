package models;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Класс реализует корзину товаров для пользователя. На протяжении всего жизненного цикла приложения создается
 * только один экземпляр данного класса (шаблон проектирования Singleton).
 */
public class Basket {

	/*
	 * Корзина товаров
	 */
	private ConcurrentHashMap<Integer, Product> bufferProducts;

	private Basket() {
		bufferProducts = new ConcurrentHashMap<>();
	}

	/**
	 * SingletonHolder is loaded on the first execution of Settings.getInstance() or
	 * the first access to SettingsHolder.INSTANCE, not before.
	 */
	private static class BasketHolder {
		private static final Basket INSTANCE = new Basket();
	}

	public static Basket getInstance() {
		return BasketHolder.INSTANCE;
	}

	public ConcurrentHashMap<Integer, Product> getBufferProducts() {
		return bufferProducts;
	}

	public void setBufferProducts(ConcurrentHashMap<Integer, Product> bufferProducts) {
		this.bufferProducts = bufferProducts;
	}

	/* Добавить товар в корзину. */
	public int addToBasket(Product product) {
		/* Создаем копию товара */
		Product productForAdd = new Product(product);
		productForAdd.setAmount(1);
		bufferProducts.put(productForAdd.getId(), productForAdd);
		return productForAdd.getId();
	}

	/* Удалить товар из корзины. */
	public void removeProduct(int id) {
		bufferProducts.remove(id); 
	}

	public void removeAllBufferProducts() {
		Iterator<Map.Entry<Integer, Product>> iterator = bufferProducts.entrySet().iterator();
		while (iterator.hasNext()) {
			// <Map.Entry<Integer, Product>> product = iterator.next();
			iterator.next();
			iterator.remove();
		}
	}

	public void changeProductAmount(int id, int newAmount) {
		bufferProducts.get(id).setAmount(newAmount);		
	}

}
