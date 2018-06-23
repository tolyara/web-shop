package servlets.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import models.Product;
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		// String s= "05.09.2013";
		try {
			SHOP_WEB.addProduct(new Product(SHOP_WEB.generateProductId(), req.getParameter("productname"),
					Integer.valueOf(req.getParameter("category_id_fk")), req.getParameter("manufacturer_name_fk"),
					Double.valueOf(req.getParameter("price")), parseDateFromString(req.getParameter("creation_date")),
					req.getParameter("colour"), (req.getParameter("size")),
					Integer.valueOf(req.getParameter("amount_in_storage"))));
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWADMIN_PATH));
		} catch (Exception e) {
			// resp.sendRedirect(String.format("%s%s", req.getContextPath(),
			// CREATEPRODUCT_JSP));
			e.printStackTrace();
		}
	}

	private static Date parseDateFromString(String string) throws ParseException {
		// String string = req.getParameter("creation_date");
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd.MM.yyyy");
		Date creationDate;
		// try {
		creationDate = format.parse(string);
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		return creationDate;
	}

}
