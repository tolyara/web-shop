package servlets.user;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import models.Product;
import service.StorageIdentifier;
import storages.Storage;

/**
 * Сервлет обслуживает создание выборки по указанным пользователем параметрам.
 * 
 * @author AnatoliiMelchenko
 */
public class FindProductsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWUSER_PATH = "/user/view";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		ConcurrentHashMap<Integer, Product> foundedProducts = SHOP_WEB.findProducts(
				req.getParameter("manufacturerName"), req.getParameter("minPrice"),
				req.getParameter("maxPrice"), req.getParameter("colour"));
//		System.out.println(req.getParameter("manufacturerName") + req.getParameter("minPrice") +
//				req.getParameter("maxPrice") + req.getParameter("colour"));
		/* Результат выборки сохраняем в сессии */
		req.getSession().setAttribute("foundedProducts", foundedProducts.values());
		resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWUSER_PATH));
	}

}
