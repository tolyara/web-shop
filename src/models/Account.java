package models;

import java.util.concurrent.ConcurrentHashMap;

public class Account {

	private String login;
	/*
	 * Корзина товаров
	 */
//	private ConcurrentHashMap<Integer, Product> basket;

	public Account(String login) {
		this.login = login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}

//	public ConcurrentHashMap<Integer, Product> getBasket() {
//		return basket;
//	}

//	public void setBasket(ConcurrentHashMap<Integer, Product> basket) {
//		this.basket = basket;
//	}

	public void addToBasket(Product product) {
//		basket.put(product.getId(), product);
	}

}
