package models;

import java.util.Date;

/**
 * Класс описывает товар онлайн-магазина. Товар может храниться на складе, может
 * быть добавлен в корзину, в заказ.
 * 
 * @author AnatoliiMelchenko
 */

public class Product {

	/* ID товара */
	private int id;

	/* Название товара */
	private String productName;

	/* Категория (бытовая техника, мебель, посуда и пр.) */
	private int categoryId;

	/* Производитель */
	private String manufacturerName;

	/* Цена товара за шт. */
	private double price;

	/* Дата изготовления */
	private Date creationDate;

	/* Цвет */
	private String colour;

	/* Габариты (мелкий, средний, крупный) */
	private String size;

	/*
	 * Количество штук, может быть реализовано как кол-во доступных единиц на
	 * складе, так и кол-во штук в корзине/заказе
	 */
	private int amount;

	public Product() {
		// this.productName = null;
	}

	public Product(int id, String productName) {
		this.id = id;
		this.productName = productName;
	}

	public Product(int id, String productName, int categoryId, String manufacturerName, double price, Date creationDate,
			String colour, String size, int amount) {
		this.id = id;
		this.productName = productName;
		this.categoryId = categoryId;
		this.manufacturerName = manufacturerName;
		this.price = price;
		this.creationDate = creationDate;
		this.colour = colour;
		this.size = size;
		this.amount = amount;
	}

	public Product(int id, String productName, int categoryId) {
		super();
		this.id = id;
		this.productName = productName;
		this.categoryId = categoryId;
	}

	/**
	 * Copy constructor.
	 */
	public Product(Product product) {
		this(product.getId(), product.getProductName(), product.getCategoryId(), product.getManufacturerName(),
				product.getPrice(), product.getCreationDate(), product.getColour(), product.getSize(),
				product.getAmount());
	}

	public int getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
