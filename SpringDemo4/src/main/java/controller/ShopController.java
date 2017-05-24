package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ShopService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/5/24.
 */
@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/add/{name}", method = RequestMethod.GET)
    @ResponseBody
    public void add(@PathVariable String name) {
        Product p = new Product();
        p.setName(name);
        shopService.addToCart(p);
    }

    @RequestMapping(value = "show", method = RequestMethod.GET)
    @ResponseBody
    public void show() {
        shopService.showAllInCart();
    }
}
