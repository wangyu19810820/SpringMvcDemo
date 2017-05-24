package service.impl;

import controller.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/5/24.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShopCart {

    private List<Product> list = new ArrayList<>();

    public void add(Product p) {
        list.add(p);
    }

    public void show() {
        list.forEach(System.out::println);
    }
}
