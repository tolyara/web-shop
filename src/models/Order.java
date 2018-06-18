package models;

/**
 * Класс описывает заказ, который создается пользователем.
 * 
 * @author AnatoliiMelchenko
 */ 
public class Order {

	/*
	 * ID заказа
	 */
	private int id;
	
	/*
	 * ID пользователя, сделавшего заказ
	 */
	private int userId;	
	
	/*
	 * Статус заказа, возможные варианты - registered, denied
	 */
	private String status;

	public Order() {
		
	}
	
}
