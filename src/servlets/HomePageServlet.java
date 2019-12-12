package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет обслуживает главную страницу. В зависимости от роли пользователя
 * передает управление нужному модулю (шаблон проектирования Front Controller).
 * 
 * @author Anatolii Melchenko
 */

public class HomePageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String HOMEPAGE_PATH = "HomePage.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(HOMEPAGE_PATH);
		dispatcher.forward(req, resp);
	}

}
