package models;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс описывает заказ, который создается пользователем.
 * 
 * @author AnatoliiMelchenko
 */ 
public class Order {

	/* ID заказа */
	private int id;
	
	/* Логин пользователя, сделавшего заказ */
	private int userLogin;	
	
	/* Выбранные товары */
	private ConcurrentHashMap<Integer, Product> orderedProducts;
	
	/* Статус заказа, возможные варианты - registered, paid, denied */
	private String status;

	public Order() {
		
	}
	
}
