package storages;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import models.Product;

/**
 * Интерфейс определяет основные методы для работы с хранилищем данных в
 * web-приложении.
 * 
 * @author Anatolii Melchenko
 */
public interface Storage {

	/*
	 * Методы, формирующие вывод данных на экран в виде таблиц
	 */
	ConcurrentMap<Integer, Product> getProducts();

	// Set<Pet> getAllPets();

	// ConcurrentHashMap<Integer, Animalable> getWildAnimals();

	/*
	 * Метод используется для корректного закрытия соединения с БД
	 */
	public void close();

	/*
	 * Методы для работы с товарами
	 */
	public int addProduct(Product product);

	public int generateProductId();

	public Product getProductById(int id);

	public void deleteProduct(int id);

	public void editProduct(int id, String newProductName);

	Product getProductByProductName(String productName);

	// Методы для работы с питомцами
	// void addPet(Pet pet);

	// Методы для работы с животными из приюта
	// void deleteWildPetFromShelter(int id);

}
