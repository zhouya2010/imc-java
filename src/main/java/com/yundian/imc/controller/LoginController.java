package com.yundian.imc.controller;

import com.yundian.imc.common.LoginBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;

@Controller
@RequestMapping("admin")
public class LoginController {

    /**
     * 首页
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String main() {
        System.out.println("=======> home");


        return "/sign-in";
    }

    @RequestMapping(value = "reset-password", method = RequestMethod.GET)
    public String resetPassword() {
        return "/reset-password";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password, ModelMap model) {
        System.out.println("=======> login");
        System.out.println("password ==>" + username);
        System.out.println("password ==>" + password);
        return "/index";
    }


}
