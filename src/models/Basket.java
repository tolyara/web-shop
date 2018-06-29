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
	
	private static final String ERROR_PRODUCT_AMOUNT_NEGATIVE_VALUE = "Количество не может быть отрицательным.";

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
			iterator.next();
			iterator.remove();
		}
	}

	/*
	 * Изменить количество единиц товара в корзине. Метод выполнится, только если
	 * новое количество больше нуля.
	 */
	public void changeProductAmount(int id, int newAmount) {
		if (newAmount > 0) {
			bufferProducts.get(id).setAmount(newAmount);
		} else {
			throw new NumberFormatException(ERROR_PRODUCT_AMOUNT_NEGATIVE_VALUE);
		}
	}

}
