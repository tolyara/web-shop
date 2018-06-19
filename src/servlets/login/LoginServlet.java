package servlets.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import models.Account;
import models.Product;
import service.StorageIdentifier;
import storages.Storage;
import storages.WebShop;
import storages.WebShopJDBC;

/**
 * Сервлет обслуживает вход в систему.
 * 
 * @author AnatoliiMelchenko
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String LOGIN_JSP = "/views/Login/Login.jsp";
	private static final String LOGIN_PATH = "/login";
	private static final String VIEWUSER_PATH = "/user/view";
	private static final String VIEWADMIN_PATH = "/admin/view";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("errorMessage", req.getParameter("error_message"));
		RequestDispatcher dispatcher = req.getRequestDispatcher(LOGIN_JSP);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String enteredLogin = req.getParameter("login"); 
		String accountRole = SHOP_WEB.checkAccountRole(enteredLogin);
		boolean authenticationResult = SHOP_WEB.checkLoginPassword(enteredLogin, req.getParameter("password"));
		if (authenticationResult == true) {
			Account accountBean = new Account(enteredLogin);
			req.getSession().setAttribute("LOGGED_ACCOUNT", accountBean); 
			req.getSession().setAttribute("ACCOUNT_ROLE", accountRole.toLowerCase()); // String
			switch (accountRole.toLowerCase()) {
			case "user":
				resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWUSER_PATH)); break;
			case "admin":
				resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWADMIN_PATH)); break;
			default:
				resp.sendRedirect(String.format("%s%s", req.getContextPath(), LOGIN_PATH));
			}
		} else {
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), LOGIN_PATH));
		}
	}

}
