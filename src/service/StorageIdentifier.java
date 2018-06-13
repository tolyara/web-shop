package service;

import storages.Storage;
import storages.WebShop;
import storages.WebShopJDBC;

/**
 * Данный класс нужен для определения типа хранилища данных.
 * @author Anatolii Melchenko
 */

public class StorageIdentifier {

    private static String storageType = "jdbc";

    public static Storage getStorage() {
        switch (storageType) {
            case "memory":
                return WebShop.getInstance(); 
            case "jdbc":
                return new WebShopJDBC(); 
            default:
                throw new RuntimeException("Ошибка! Тип хранилища не определен.");
        }
    }

}
