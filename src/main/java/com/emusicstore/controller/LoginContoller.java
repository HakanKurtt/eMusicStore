package com.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginContoller {

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error",required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model){
        if(error != null){
            model.addAttribute("error", "Geçersiz kullanıcı adı ve şifre!");
        }

        if(logout != null){
            model.addAttribute("msg", "Başarılı bir şekilde çıkış yaptınız.");
        }

        return "login";
    }
}
