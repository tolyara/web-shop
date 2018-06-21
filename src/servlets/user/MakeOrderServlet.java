package servlets.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import models.Order;
import models.Product;
import service.StorageIdentifier;
import storages.Storage;

/**
 * Сервлет обслуживает создание заказа пользователем.
 * 
 * @author AnatoliiMelchenko
 */
public class MakeOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String VIEWUSER_PATH = "/user/view";
    private static final String MAKEORDER_JSP = "/views/User/MakeOrder.jsp";
    private static final Storage SHOP_WEB = StorageIdentifier.getStorage();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("userLogin", SHOP_WEB.getProductById(Integer.valueOf(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAKEORDER_JSP);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        SHOP_WEB.makeOrder(req.getParameter("userLogin"), new Order());
//        SHOP_WEB.addProduct(new Product(SHOP_WEB.generateProductId(), req.getParameter("productname")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), VIEWUSER_PATH));
    }

}
