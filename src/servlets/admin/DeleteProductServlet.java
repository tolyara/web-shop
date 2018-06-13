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
 * Сервлет обслуживает удаление товара из каталога.
 * 
 * @author AnatoliiMelchenko
 */
public class DeleteProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEWADMIN_PATH = "/admin/view";
	private static final String DELETEPRODUCT_PATH = "/views/Admin/DeleteProduct.jsp";
    private static final Storage CLINIC_WEB = StorageIdentifier.getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", CLINIC_WEB.getProductById(Integer.valueOf(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher(DELETEPRODUCT_PATH);
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CLINIC_WEB.deleteProduct(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWADMIN_PATH));
    }

}
