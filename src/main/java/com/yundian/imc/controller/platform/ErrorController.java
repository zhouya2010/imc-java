package com.yundian.imc.controller.platform;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @RequestMapping("error/{code}")
    public String error(@PathVariable int code) {
        switch (code) {
            case 403:
                return "403";
            case 404:
                return "/error/404";
            case 505:
                return "/error/error-password";
            default:
                return "/error/500";
        }
    }

}
