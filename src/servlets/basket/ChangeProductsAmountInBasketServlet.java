package servlets.basket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.Basket;
import models.Product;
import service.StorageIdentifier;
import storages.Storage;

import java.io.IOException;

public class ChangeProductsAmountInBasketServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWUSER_PATH = "/user/view";
	private static final String VIEWUNREGISTERED_PATH = "/unregistered";
	private static final Basket BASKET = Basket.getInstance();

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////		doPost(req, resp);
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BASKET.changeProductAmount(Integer.valueOf(req.getParameter("bufferProductId")),
				Integer.valueOf(req.getParameter("newAmount"))); 
		/*
		 * Проверяем, залогинен ли пользователь, для того чтобы сделать корректный
		 * редирект
		 */
		Account loggedAccount = (Account) req.getSession().getAttribute("LOGGED_ACCOUNT");
		if (loggedAccount != null) {
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWUSER_PATH));
		} else {
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWUNREGISTERED_PATH));
		}
	}

}
 