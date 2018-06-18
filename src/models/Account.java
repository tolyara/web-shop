package models;

public class Account {

	private String login;
	// private String password;

	public String getLogin() {
		return login;
	}

	public Account(String login) {
		super();
		this.login = login;
	}

	// public String getPassword() {
	// return password;
	// }

	public void setLogin(String login) {
		this.login = login;
	}

	// public void setPassword(String password) {
	// this.password = password;
	// }

}
