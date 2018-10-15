package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao {

    private Map<String, Cart> listOfCarts;

    public CartDaoImpl(){
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart createCart(Cart cart) {

        if(listOfCarts.keySet().contains(Integer.toString(cart.getCartId()))){
            throw new IllegalArgumentException(String.format("The cart with the given id(%) is already exist.",Integer.toString(cart.getCartId())));
        }

        listOfCarts.put(Integer.toString(cart.getCartId()), cart);

        return cart;
    }

    public Cart readCart(String cartId) {

        return listOfCarts.get(cartId);
    }

    public void updateCart(String cartId, Cart cart) {

        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can not update. The cart with the given id(%) is not exist.", cartId));
        }

        listOfCarts.put(cartId, cart);
    }

    public void deleteCart(String cartId) {

        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can not delete. The cart with the given id(%) is not exist.", cartId));
        }

        listOfCarts.remove(cartId);


    }
}
