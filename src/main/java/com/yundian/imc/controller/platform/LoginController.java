package com.yundian.imc.controller.platform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class LoginController {

    /**
     * 首页
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String main() {
        return "/sign-in";
    }

    @RequestMapping(value = "reset-password", method = RequestMethod.GET)
    public String resetPassword() {
        return "/reset-password";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password, ModelMap model) {
        return "/index";
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(){
        return "/sign-in";
    }

    @RequestMapping(value = "sign-up",method = RequestMethod.GET)
    public String signUp(){
        return "/sign-up";
    }
}
