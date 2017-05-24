package service.impl;

import controller.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ShopService;

/**
 * Created by admin on 2017/5/24.
 */
@Service
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopCart cart;

    @Override
    public void addToCart(Product p) {
        cart.add(p);
    }

    @Override
    public void showAllInCart() {
        cart.show();
    }
}
