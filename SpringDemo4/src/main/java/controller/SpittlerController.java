package controller;

import model.Spittler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.SpittlerService;

/**
 * Created by admin on 2017/5/19.
 */
@RequestMapping("/spittler")
@Controller
public class SpittlerController {

    @Autowired
    private SpittlerService spittlerService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/spittler/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@Validated Spittler spittler, Errors errors) {
        if (errors.hasErrors()) {
            return "/spittler/register";
        }
        spittlerService.register(spittler);
//        return "redirect:/spittler/" + spittler.getId();
        return "forward:/spittler/" + spittler.getId();
    }

    @RequestMapping(value = "/register1", method = RequestMethod.GET)
    public String register1(Model model) {
        model.addAttribute(new Spittler());
        return "/spittler/register1";
    }

    @RequestMapping(value = "/register1", method = RequestMethod.POST)
    public String doRegister1(@Validated Spittler spittler, Errors errors) {
        if (errors.hasErrors()) {
            return "/spittler/register1";
        }
        spittlerService.register(spittler);
        return "redirect:/spittler/" + spittler.getId();
    }

    @RequestMapping(value = "/register2", method = RequestMethod.GET)
    public ModelAndView register2() {
        ModelAndView mv = new ModelAndView("/spittler/register2");
        Spittler spittler = new Spittler();
        spittler.setName("aaaaaaa");
        mv.addObject("spittler", spittler);
        return mv;
    }

    @RequestMapping(value = "/register2", method = RequestMethod.POST)
    public String doRegister2(@Validated Spittler spittler, Errors errors) {
        if (errors.hasErrors()) {
            return "/spittler/register2";
        }
        spittlerService.register(spittler);
        return "redirect:/spittler/" + spittler.getId();
    }

    @RequestMapping("/{id}")
    public String detail(@PathVariable("id")long id, Model model) {
        model.addAttribute("spittler", spittlerService.get(id));
        return "/spittler/detail";
    }

    @ModelAttribute("spittler")
    public Spittler spittler() {
        return new Spittler();
    }
}
