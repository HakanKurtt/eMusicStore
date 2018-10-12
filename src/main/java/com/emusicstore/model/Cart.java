package com.emusicstore.model;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Cart {
    private int cartId;
    private Map<String, CartItem> cartItems;
    private double grandTotal;

    private Cart(){
        cartItems=new HashMap<String, CartItem>();
        grandTotal=0;
    }

    public Cart(int cartId){
        this();
        this.cartId=cartId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void addCart(CartItem item){
        String productId = Integer.toString(item.getProduct().getProductId());

        if(cartItems.containsKey(productId)){ // Eger sepette bu üründen daha once var ise, var olan ile topla
            CartItem existingCartItem = cartItems.get(item);
            existingCartItem.setQuantity(existingCartItem.getQuantity()+item.getQuantity());
            cartItems.put(productId, existingCartItem);
        }else { //yoksa map'e koy
            cartItems.put(productId, item);
        }

        updateGrandTotal();
    }

    public void removeCartItem(CartItem item){
        String productId = Integer.toString(item.getProduct().getProductId());
        cartItems.remove(productId);

        updateGrandTotal();
    }

    public void updateGrandTotal(){
        grandTotal=0;

        for(CartItem item: cartItems.values()){
            grandTotal = grandTotal+item.getTotalPrice();
        }
    }


}
