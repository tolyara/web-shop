package listeners;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import models.Account;
import storages.Storage;

/**
 * Application Lifecycle Listener implementation class AccountSessionListener
 *
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {
	
	private static String loggedAccount;
	private static String accountRole;
	
		@Override
	public void attributeAdded(HttpSessionBindingEvent sessionBindingEvent) {
		loggedAccount = ((Account) sessionBindingEvent.getSession().getAttribute("LOGGED_ACCOUNT")).getLogin();
		accountRole = (String) sessionBindingEvent.getSession().getAttribute("ACCOUNT_ROLE");
		System.out.println("Session Created, account = " + loggedAccount + ", role = " + accountRole
				+ " logged in, time = " + new Date().toString());		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent sessionBindingEvent) {
		loggedAccount = ((Account) sessionBindingEvent.getSession().getAttribute("LOGGED_ACCOUNT")).getLogin();
		accountRole = (String) sessionBindingEvent.getSession().getAttribute("ACCOUNT_ROLE");
		System.out.println("Session Destroyed, account = " + loggedAccount + ", role = " + accountRole
				+ " logged out, time = " + new Date().toString());		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub		
	}

}
