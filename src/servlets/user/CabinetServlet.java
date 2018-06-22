package servlets.user;

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
import models.Product;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Сервлет обслуживает вывод личного кабинета при залогиненном аккаунте. В кабинете можно просмотреть все заказы пользователя.
 * 
 * @author AnatoliiMelchenko
 */
public class CabinetServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	private static final String VIEWCABINET_JSP = "/views/User/ViewCabinet.jsp";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	/* Список заказов */   	
        req.setAttribute("userOrders", SHOP_WEB.getUserOrders(req.getParameter("userLogin")).values());              
        RequestDispatcher dispatcher = req.getRequestDispatcher(VIEWCABINET_JSP);
        dispatcher.forward(req, resp);
    }
    
    /*
     *  В случае использования данных из БД через JDBC этот метод нужен для корректного закрытия соединения с БД.
     */
//    @Override
//    public void destroy() {
//        super.destroy();
//        SHOP_WEB.close();
//    }

}



