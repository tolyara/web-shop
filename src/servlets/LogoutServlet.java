package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Basket;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Сервлет обслуживает выход из аккаунта пользователя (покупателя) или
 * администратора.
 * 
 * @author Anatolii Melchenko
 */

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String LOGIN_PATH = "/login";
	private static final Basket BASKET = Basket.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		BASKET.removeAllBufferProducts();
		resp.sendRedirect(String.format("%s%s", req.getContextPath(), LOGIN_PATH));
	}

}
