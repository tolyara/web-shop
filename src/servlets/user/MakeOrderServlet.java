package servlets.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import models.Basket;
import models.Order;
import models.OrderStatus;
import models.Product;
import service.StorageIdentifier;
import storages.Storage;

/**
 * Сервлет обслуживает создание заказа пользователем.
 * 
 * @author AnatoliiMelchenko
 */
public class MakeOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWUSER_PATH = "/user/view";
	private static final String MAKEORDER_JSP = "/views/User/MakeOrder.jsp";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();
	private static final Basket BASKET = Basket.getInstance();
	private static final String ERROR_EMPTY_BASKET = "В корзине нет товаров! ";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (BASKET.getBufferProducts().size() == 0) {
			req.getSession().setAttribute("ERROR_EMPTY_BASKET", ERROR_EMPTY_BASKET);
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWUSER_PATH));
		} else {
			req.setAttribute("bufferProducts", BASKET.getBufferProducts().values());
			req.setAttribute("userLogin", req.getParameter("userLogin"));
			RequestDispatcher dispatcher = req.getRequestDispatcher(MAKEORDER_JSP);
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		SHOP_WEB.makeOrder(new Order(SHOP_WEB.generateOrderId(), req.getParameter("userLogin"),
				BASKET.getBufferProducts(), OrderStatus.REGISTERED));
		/* Очищаем корзину */
		BASKET.removeAllBufferProducts();
		resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWUSER_PATH));
	}

}
