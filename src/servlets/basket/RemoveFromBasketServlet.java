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

public class RemoveFromBasketServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWUSER_PATH = "/user/view";
//	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();
	private static final Basket BASKET = Basket.getInstance(); 

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {    	
//    	Product productForRemove = Integer.valueOf(req.getParameter("productId")));    	
    	BASKET.deleteProduct(Integer.valueOf(req.getParameter("productId")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWUSER_PATH));
    }

}
