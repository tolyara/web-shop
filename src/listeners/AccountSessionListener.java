package listeners;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import models.Account;

/**
 * Application Lifecycle Listener implementation class AccountSessionListener
 *
 */
@WebListener
public class AccountSessionListener implements HttpSessionListener {

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		System.out.println("Session Created:: ID="+sessionEvent.getSession().getId());
//		String loggedAccount = ((Account) sessionEvent.getSession().getAttribute("LOGGED_ACCOUNT")).getLogin();
//		String accountRole = (String) sessionEvent.getSession().getAttribute("ACCOUNT_ROLE");
//		System.out.println("Session Created, account = " + loggedAccount + ", role = " + accountRole
//				+ " logged in, time = " + new Date().toString());
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("Session Destroyed:: ID="+sessionEvent.getSession().getId());
//		String loggedAccount = ((Account) sessionEvent.getSession().getAttribute("LOGGED_ACCOUNT")).getLogin();
//		String accountRole = (String) sessionEvent.getSession().getAttribute("ACCOUNT_ROLE");
//		System.out.println("Session Destroyed, account = " + loggedAccount + ", role = " + accountRole
//				+ " logged out, time = " + new Date().toString());
	}

}
