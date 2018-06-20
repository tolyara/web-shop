package models;

import java.util.concurrent.ConcurrentHashMap;

public class Basket {

	/*
	 * Корзина товаров
	 */
	private ConcurrentHashMap<Integer, Product> bufferProducts;

	public Basket() {
 
	}

	public ConcurrentHashMap<Integer, Product> getBufferProducts() {
		return bufferProducts;
	}

	public void setBufferProducts(ConcurrentHashMap<Integer, Product> bufferProducts) {
		this.bufferProducts = bufferProducts;
	}

	public void addToBasket(Product product) {
		bufferProducts.put(product.getId(), product);
	}

}
