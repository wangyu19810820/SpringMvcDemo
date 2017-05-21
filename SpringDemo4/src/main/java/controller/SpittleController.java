package controller;

import model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SpittleService;

import java.util.List;

/**
 * Created by admin on 2017/5/18.
 */
@Controller
@RequestMapping("spittle")
public class SpittleController {

    private SpittleService service;

    @Autowired
    public SpittleController(SpittleService service) {
        this.service = service;
    }

    @RequestMapping(value = "showTwenty")
    public List<Spittle> spittles(Model model) {
        model.addAttribute(service.findSpittle(Long.MAX_VALUE, 20));
//        return "spittle";
        return service.findSpittle(Long.MAX_VALUE, 20);
    }

    @RequestMapping()
    public List<Spittle> spittlesByPage(@RequestParam(defaultValue = "" + Long.MAX_VALUE) long top,
                                        @RequestParam(name = "count1", defaultValue = "20") int count) {
        return service.findSpittle(top, count);
    }

    @RequestMapping("/{spittleId}")
    public String get(@PathVariable("spittleId") long id, Model model) {
        model.addAttribute(service.findById(id));
        return "detail";
    }
}
