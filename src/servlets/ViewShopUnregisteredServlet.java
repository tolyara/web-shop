package servlets;

import service.StorageIdentifier;
import storages.Storage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Basket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Сервлет обслуживает вывод основных элементов интернет-магазина для незарегистрированного (каталог товаров, корзина).
 * 
 * @author AnatoliiMelchenko
 */
public class ViewShopUnregisteredServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	private static final String VIEWSHOP_UNREGISTERED_JSP = "/views/ViewShopUnregistered.jsp";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();
	private static final Basket BASKET = Basket.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", SHOP_WEB.getProducts().values());
        req.setAttribute("bufferProducts", BASKET.getBufferProducts().values());
        RequestDispatcher dispatcher = req.getRequestDispatcher(VIEWSHOP_UNREGISTERED_JSP);
        dispatcher.forward(req, resp);
    }

    /*
     * В случае использования данных из БД через JDBC этот метод нужен для корректного закрытия соединения с БД.(non-Javadoc)
     */
    @Override
    public void destroy() {
        super.destroy();
        SHOP_WEB.close();
    }

}



