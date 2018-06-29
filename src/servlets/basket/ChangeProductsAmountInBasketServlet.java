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
	private static final Basket BASKET = Basket.getInstance();
	private static final String ERROR_PRODUCT_AMOUNT = "Неверно введенные данные! ";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BASKET.changeProductAmount(Integer.valueOf(req.getParameter("bufferProductId")),
					Integer.valueOf(req.getParameter("newAmount")));
		} catch (NumberFormatException e) {
			req.getSession().setAttribute("ERROR_PRODUCT_AMOUNT", ERROR_PRODUCT_AMOUNT + e.getMessage());
			e.printStackTrace();
		} 
		resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWUSER_PATH));
	}

}
 