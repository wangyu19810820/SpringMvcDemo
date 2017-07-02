package controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2017/7/2.
 */
@Controller
public class LoginController {

    @RequestMapping(method = RequestMethod.GET, value = "login1")
    public String login() {
        return "login";
    }
}
