package models;

import java.util.concurrent.ConcurrentHashMap;

public class Account {

	/* Уникальный логин аккаунта */
	private String login;
	private String password;

	/*
	 * Статус аккаунта, если true - активен, false - заблокирован, по умолчанию все
	 * созданные аккаунты - активные
	 */
	private boolean isActive = true;

	public Account(String login) {
		this.login = login;
	}

	public Account(String login, boolean isActive) {
		this.login = login;
		this.isActive = isActive;
	}
	
	

	public Account(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
