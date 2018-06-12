package Service;

import Models.WebShop;
import Storages.JdbcStorage;
import Storages.Storage;

/**
 * Данный класс нужен для определения типа хранилища данных.
 * @author Anatolii Melchenko
 */

public class StorageIdentifier {

    private static String storageType = "memory";

    public static Storage getStorage() {
        switch (storageType) {
            case "memory":
                return WebShop.getInstance(); 
            case "jdbc":
                return new JdbcStorage(); 
            default:
                throw new RuntimeException("Ошибка! Тип хранилища не определен.");
        }
    }

}
