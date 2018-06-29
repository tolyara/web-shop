package servlets.user;

import service.StorageIdentifier;
import storages.Storage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Account;
import models.Basket;
import models.Product;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Сервлет обслуживает вывод основных элементов интернет-магазина (каталог
 * товаров, корзина) при залогиненном аккаунте.
 * 
 * @author AnatoliiMelchenko
 */
public class ViewShopServlet extends HttpServlet {

	private static final long serialVersionUID = 1L; 
	private static final String VIEWSHOP_JSP = "/views/User/ViewShop.jsp";
//	private static final String VIEWSHOP_PATH = "/user/view";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();
	private static final Basket BASKET = Basket.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* Каталог товаров */
		req.setAttribute("products", SHOP_WEB.getProducts().values());
		/* Товары в корзине */
		req.setAttribute("bufferProducts", BASKET.getBufferProducts().values());
		Account loggedAccount = ((Account) req.getSession().getAttribute("LOGGED_ACCOUNT"));
		req.setAttribute("LOGGED_ACCOUNT", loggedAccount);
		String accountRole = (String) req.getSession().getAttribute("ACCOUNT_ROLE");
		req.setAttribute("ACCOUNT_ROLE", accountRole);
//		final String ERROR_PRODUCT_AMOUNT = (String) req.getSession().getAttribute("ERROR_PRODUCT_AMOUNT");
//		req.setAttribute("ERROR_PRODUCT_AMOUNT", accountRole);
		RequestDispatcher dispatcher = req.getRequestDispatcher(VIEWSHOP_JSP);
		dispatcher.forward(req, resp); 
		/* Очищаем строку в сессии, выводящую сообщения об ошибке */
		req.getSession().setAttribute("ERROR_PRODUCT_AMOUNT", "");
	}

	/*
	 * В случае использования данных из БД через JDBC этот метод нужен для
	 * корректного закрытия соединения с БД.
	 */
	@Override
	public void destroy() {
		super.destroy();
		SHOP_WEB.close();
	}

}
