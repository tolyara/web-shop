package models;

import java.util.concurrent.ConcurrentHashMap;

public class Account {

	/* Уникальный логин аккаунта */
	private String login;

	/*
	 * Статус аккаунта, если true - активен, false - заблокирован, по умолчанию все
	 * созданные аккаунты - активные
	 */
	private boolean isActive = true;

	public Account(String login) {
		this.login = login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
