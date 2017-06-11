package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/5/17.
 */
@Controller
@RequestMapping("/Demo1")
public class Demo1 {

    @RequestMapping()
    public String index() {
//        return "demo1";
        return "/demo1/index";
    }

    @RequestMapping("/demo3")
    public ModelAndView index1() {
//        return "demo1";
        ModelAndView mv = new ModelAndView("/demo1/abc");
        return mv;
    }

    @RequestMapping("/test")
    public Map test() {
        Map map = new HashMap();
        map.put("aa", "bb");
        return map;
    }
}
