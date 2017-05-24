package service;

import controller.Product;

/**
 * Created by admin on 2017/5/24.
 */
public interface ShopService {

    void addToCart(Product p);
    void showAllInCart();
}
