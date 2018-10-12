package com.emusicstore.dao;

import com.emusicstore.model.Cart;

public interface CartDao {

    Cart createCart(Cart cart);

    Cart readCart(String cartId);

    void updateCart(String cartId, Cart cart);

    void deleteCart(String cartId);
}
