package com.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartItemController {

    @RequestMapping
    public String get(HttpServletRequest request){
        // session Id 'yi cart Id olarak kullanıyoruz. Sebebi her cart'ı spesifik bir session'a bağlamaktır. OneToOne relation.
        return "redirect:/cart/"+request.getSession(true).getId();
    }

    @RequestMapping(value = "/{cartId}" ,method= RequestMethod.GET)
    public String getCart(@PathVariable(value = "cartId") String cartId, Model model){
        model.addAttribute("cartId",cartId);

        return "cart";
    }
}
