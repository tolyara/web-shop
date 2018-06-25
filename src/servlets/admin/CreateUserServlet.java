package servlets.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import models.Account;
import models.Product;
import service.DateParserUtil;
import service.StorageIdentifier;
import storages.Storage;

/**
 * Сервлет обслуживает создание новой позиции товара.
 * 
 * @author AnatoliiMelchenko
 */
public class CreateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWADMIN_PATH = "/admin/view";  
	private static final String CREATEPRODUCT_JSP = "/views/Admin/CreateUser.jsp";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		try {
			SHOP_WEB.addAccount(req.getParameter("role"), new Account(req.getParameter("accountName"), req.getParameter("accountPass")));
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWADMIN_PATH));
		} catch (Exception e) {
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), CREATEPRODUCT_JSP));
			e.printStackTrace();
		}
	}

}
