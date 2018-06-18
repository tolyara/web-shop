package servlets.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StorageIdentifier;
import storages.Storage;

/**
 * Сервлет обслуживает редактирование атрибутов товара.
 * 
 * @author AnatoliiMelchenko
 */
public class EditProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWADMIN_PATH = "/admin/view";
	private static final String EDITPRODUCT_PATH = "/views/Admin/EditProduct.jsp";  
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("product", SHOP_WEB.getProductById(Integer.valueOf(req.getParameter("id"))));
		RequestDispatcher dispatcher = req.getRequestDispatcher(EDITPRODUCT_PATH);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		SHOP_WEB.editProduct(Integer.valueOf(req.getParameter("id")), req.getParameter("productname"));
		resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWADMIN_PATH));
	}

}
