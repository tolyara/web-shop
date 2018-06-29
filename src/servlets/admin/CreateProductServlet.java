package servlets.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import models.Product;
import service.DateParserUtil;
import service.StorageIdentifier;
import storages.Storage;

/**
 * Сервлет обслуживает создание новой позиции товара.
 * 
 * @author AnatoliiMelchenko
 */
public class CreateProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWADMIN_PATH = "/admin/view";
	private static final String CREATEPRODUCT_JSP = "/views/Admin/CreateProduct.jsp";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();
	private static final String ERROR_PRODUCT_CREATE = "Неверно введенные данные! ";
	private static final String ERROR_PRODUCT_CREATE_NEGATIVE_VALUE = "Цена/количество не может быть отрицательным.";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		try {
		if ((Double.valueOf(req.getParameter("price")) <= 0)
				|| (Integer.valueOf(req.getParameter("amount_in_storage")) <= 0)) {
			req.getSession().setAttribute("ERROR_PRODUCT_CREATE", ERROR_PRODUCT_CREATE + ERROR_PRODUCT_CREATE_NEGATIVE_VALUE);
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), CREATEPRODUCT_JSP));
		} else {
			SHOP_WEB.addProduct(new Product(SHOP_WEB.generateProductId(), req.getParameter("productname"),
					Integer.valueOf(req.getParameter("category_id_fk")), req.getParameter("manufacturer_name_fk"),
					Double.valueOf(req.getParameter("price")),
					DateParserUtil.recognizeSqlDate(req.getParameter("creation_date")), req.getParameter("colour"),
					(req.getParameter("size")), Integer.valueOf(req.getParameter("amount_in_storage"))));
			req.getSession().setAttribute("ERROR_PRODUCT_CREATE", "");
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWADMIN_PATH));
		}
		}
		catch (Exception e) {
			req.getSession().setAttribute("ERROR_PRODUCT_CREATE", ERROR_PRODUCT_CREATE);
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), CREATEPRODUCT_JSP));
		}
		// req.getSession().setAttribute("ERROR_PRODUCT_CREATE", "");
		// resp.sendRedirect(String.format("%s%s", req.getContextPath(),
		// VIEWADMIN_PATH));

	}

}
