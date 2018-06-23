package models;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс описывает заказ, который создается пользователем. Сущности заказ -
 * товар имеют связь many-to-many. Поэтому, при хранении в БД, помимо таблицы
 * заказов (orders), есть также промежуточная таблица order_product, в которой
 * хранятся соотношения заказ - товар.
 * 
 * @author AnatoliiMelchenko
 */
public class Order {

	/* ID заказа */
	private int id;

	/* Логин пользователя, сделавшего заказ */
	private String userLogin;

	/* Выбранные товары */
	private ConcurrentHashMap<Integer, Product> orderedProducts;

	/* Статус заказа, возможные варианты - зарегистрирован, оплачен, отменен */
	private OrderStatus status;

	/* Итоговая стоимость заказа */
	private Double totalPrice;

	public Order() {

	}

	/* В конструкторе сразу рассчитываем итоговую стоимость заказа */
	public Order(int id, String userLogin, ConcurrentHashMap<Integer, Product> orderedProducts, OrderStatus status) {
		super();
		this.id = id;
		this.userLogin = userLogin;
		this.orderedProducts = orderedProducts;
		this.status = status;
		this.totalPrice = this.countTotalPrice();
	}

	public Order(int id, String userLogin) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public ConcurrentHashMap<Integer, Product> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(ConcurrentHashMap<Integer, Product> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/* Метод рассчитывает итоговую стоимость заказа */
	private Double countTotalPrice() {
		Double productsSum = 0.0;
		/* Чтобы узнать стоимость по каждой позиции, нужно цену товара умножить на количество заказанных единиц */
		for (Product product : (this.getOrderedProducts().values())) {
			productsSum = productsSum + product.getPrice() * product.getAmount();
		}
		return productsSum;
	}

}
