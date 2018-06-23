package models;

/**
 * Класс описывает варианты статуса заказа - зарегистрирован REGISTERED, оплачен PAID, отменен CANCELLED.
 * 
 * @author AnatoliiMelchenko
 */ 
public enum OrderStatus {
	
	REGISTERED, PAID, CANCELLED; 
	
	public static OrderStatus recognizeOrderStatus(String status) {
		switch (status.toUpperCase()) {
		case "REGISTERED":
			return REGISTERED;
		case "PAID":
			return PAID;
		case "CANCELLED":
			return CANCELLED;
		default:
			throw new RuntimeException("Error! Order status is undefined.");
		}
	}
	
}
