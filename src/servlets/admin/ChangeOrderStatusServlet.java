package servlets.admin;

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

public class ChangeOrderStatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWADMIN_ORDERS_PATH = "/admin/orders";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {    	
    	SHOP_WEB.changeOrderStatus(Integer.valueOf(req.getParameter("orderId")), req.getParameter("newOrderStatus")); 
    	resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWADMIN_ORDERS_PATH));
    }

}
