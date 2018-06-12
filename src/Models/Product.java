package Models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Класс описывает товар, который может храниться в онлайн-магазине.
 * 
 * @author AnatoliiMelchenko
 */ 

public class Product {

	/*
	 * ID товара
	 */
	private int id;
	
	/*
	 * Название товара
	 */
	private String productName;

	public Product() {
		this.productName = null;
	}  

	public Product(int id, String productName) {
		this.id = id;
		this.productName = productName;
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

}
