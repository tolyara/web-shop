package servlets.admin;

import java.io.IOException;

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
    private static final Storage SHOP_WEB = StorageIdentifier.getStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        SHOP_WEB.addProduct(new Product(SHOP_WEB.generateProductId(), req.getParameter("productname")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWADMIN_PATH));
    }

}
