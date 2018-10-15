package com.emusicstore.controller;

import com.emusicstore.dao.CartDao;
import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

//REST SERVICE

@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId){
        return cartDao.readCart(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart){
        cartDao.updateCart(cartId, cart);
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value="cartId") String cartId){

        cartDao.deleteCart(cartId);
    }

    @RequestMapping(value = "/addProduct/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") String productId, HttpServletRequest request){
        String sessionId = request.getSession(true).getId();
        Cart cart = cartDao.readCart(sessionId);

        if(cart == null){ //eger boyle bir cart yoksa mevcut session id ile birlikte yeni bir cart oluştur.
            cart = cartDao.createCart(new Cart(Integer.parseInt(sessionId)));
        }

        Product product = productDao.getProductById(productId);

        if(product == null){
            throw new IllegalArgumentException(new Exception());
        }

        cart.addCartItem(new CartItem(product));

        cartDao.updateCart(sessionId, cart);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId")String productId, HttpServletRequest request){
        String sessionId = request.getSession(true).getId();
        Cart cart = cartDao.readCart(sessionId);

        if(cart == null){ //eger boyle bir cart yoksa mevcut session id ile birlikte yeni bir cart oluştur.
            cart = cartDao.createCart(new Cart(Integer.parseInt(sessionId)));
        }

        Product product = productDao.getProductById(productId);

        if(product == null){
            throw new IllegalArgumentException(new Exception());
        }

        cart.removeCartItem(new CartItem(product));

        cartDao.updateCart(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerError(Exception e){}
}
