package Servlets.Admin;

import Service.StorageIdentifier;
import Storages.Storage;

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
public class ViewAdminPanelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	private static final String VIEWADMIN_PATH = "/views/admin/ViewAdminPanel.jsp";
	private final Storage shopWeb = StorageIdentifier.getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", shopWeb.getProducts().values());
//        req.setAttribute("viewpets", getPetsView(shopWeb.getAllPets()));
//        req.setAttribute("wildAnimals", shopWeb.getWildAnimals());
        RequestDispatcher dispatcher = req.getRequestDispatcher(VIEWADMIN_PATH);
        dispatcher.forward(req, resp);
    }

    // В случае использования данных из БД через JDBC этот метод нужен для корректного закрытия соединения с БД.
    @Override
    public void destroy() {
        super.destroy();
        shopWeb.close();
    }

}



