package servlets.admin;

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
import models.Order;
import models.Product;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Сервлет обслуживает вывод личного кабинета при залогиненном аккаунте. В кабинете можно просмотреть все заказы пользователя.
 * 
 * @author AnatoliiMelchenko
 */
public class ViewOrdersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	private static final String VIEWORDERS_JSP = "/views/Admin/ViewOrders.jsp";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	/* Список всех заказов */   	
        req.setAttribute("orders", SHOP_WEB.getAllOrders());
        RequestDispatcher dispatcher = req.getRequestDispatcher(VIEWORDERS_JSP);
        dispatcher.forward(req, resp);
    }
    
    /*
     *  При использовании данных из БД через JDBC этот метод нужен для корректного закрытия соединения с БД.
     */
//    @Override
//    public void destroy() {
//        super.destroy();
//        SHOP_WEB.close();
//    }

}



