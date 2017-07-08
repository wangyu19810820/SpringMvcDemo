package controller;

import model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.SecuredSpittleService;
import service.impl.SecuredSpittleServiceImpl;

/**
 * Created by admin on 2017/7/7.
 */
@Controller
@RequestMapping("/method")
public class MethodSecurityController {

    @Autowired
    private SecuredSpittleService service;

    @RequestMapping("/method1")
    public String method1() {
        System.out.println("metod1");
        Spittle spittle = new Spittle();
        spittle.setMessage("aaa");
        service.addSpittle(spittle);
        return "security/index";
    }

    @RequestMapping("/method2")
    public String method2() {
        System.out.println("metod2");
        service.showSpittle();
        return "security/index";
    }
}

