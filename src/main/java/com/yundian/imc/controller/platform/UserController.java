package com.yundian.imc.controller.platform;

import com.yundian.imc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users",method = RequestMethod.GET)
    public String getUsers(ModelMap model){
        model.addAttribute("users",userService.getUsers());
        return "/users";
    }

    @RequestMapping("/{userId}")
    public String getUser(@PathVariable Long userId, ModelMap model){
        System.out.println("userId ====>" + userId);
        model.addAttribute("user",userService.find(userId));
        return "/user";
    }

}
