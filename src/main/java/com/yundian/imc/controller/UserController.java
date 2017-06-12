package com.yundian.imc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/user")
public class UserController {

    @RequestMapping("users")
    public String getUsers(ModelMap model){
        return "/users";
    }


}
