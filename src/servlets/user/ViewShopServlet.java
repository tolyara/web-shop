package servlets.user;

import service.StorageIdentifier;
import storages.Storage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Сервлет обслуживает вывод основных элементов интернет-магазина (каталог товаров, корзина).
 * 
 * @author AnatoliiMelchenko
 */
public class ViewShopServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	private static final String VIEWSHOP_JSP = "/views/User/ViewShop.jsp";
	private static final Storage SHOP_WEB = StorageIdentifier.getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", SHOP_WEB.getProducts().values());
        RequestDispatcher dispatcher = req.getRequestDispatcher(VIEWSHOP_JSP);
        dispatcher.forward(req, resp);
    }

    // В случае использования данных из БД через JDBC этот метод нужен для корректного закрытия соединения с БД.
    @Override
    public void destroy() {
        super.destroy();
        SHOP_WEB.close();
    }

}


