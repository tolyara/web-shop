package models;

import java.util.concurrent.ConcurrentHashMap;

public class Account {

	/*
	 * Уникальный логин аккаунта
	 */
	private String login;
	/*
	 * Статус аккаунта, если true - активен, false - заблокирован
	 */
	private boolean isActive = true;
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

}
