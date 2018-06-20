package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.Product;
import service.StorageIdentifier;
import storages.Storage;

import java.io.IOException;

public class AddToBasketServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWUSER_PATH = "/user/view";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {    	
//    	Product product = SHOP_WEB.getProductById(Integer.valueOf(req.getParameter("productId")));    	
//    	System.out.println(product.getProductName());
    	Account loggedAccount = ((Account) req.getSession().getAttribute("LOGGED_ACCOUNT")); 
    	loggedAccount.addToBasket(SHOP_WEB.getProductById(Integer.valueOf(req.getParameter("productId"))));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWUSER_PATH));
    }

}
