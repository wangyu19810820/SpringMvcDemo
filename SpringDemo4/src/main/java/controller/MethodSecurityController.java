package controller;

import model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.SecuredSpittleService;
import service.impl.SecuredSpittleServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        try {
            service.addSpittle(spittle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "security/index";
    }

    @RequestMapping("/method2")
    public String method2() {
        System.out.println("metod2");
        service.showSpittle();
        return "security/index";
    }

    @RequestMapping("/method3")
    public String method3() {
        List list = new ArrayList();

        Spittle spittle1 = new Spittle();
        spittle1.setName("user");
        list.add(spittle1);

        Spittle spittle2 = new Spittle();
        spittle2.setName("admin");
        list.add(spittle2);

        Spittle spittle3 = new Spittle();
        spittle3.setName("aaa");
        list.add(spittle3);

        service.addSpittleList(list);
        return "security/index";
    }

    @RequestMapping("/method4")
    public String method4() {
        List<Spittle> list = service.showList();
        System.out.println(list);
        return "security/index";
    }

    @RequestMapping("/method5")
    public String method5() {
        List list = new ArrayList();

        Spittle spittle1 = new Spittle();
        spittle1.setName("user");
        list.add(spittle1);

        Spittle spittle2 = new Spittle();
        spittle2.setName("admin");
        list.add(spittle2);

        Spittle spittle3 = new Spittle();
        spittle3.setName("aaa");
        list.add(spittle3);

        service.deleteSpittle(list);
        return "security/index";
    }
}

