package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private List<Product> productList;



    public List<Product> getProductList(){
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();

        product1.setProductName("Guitar");
        product1.setProductCategory("Instrument");
        product1.setProductDescription("This is a fender strat guitar.");
        product1.setProductPrice(1500);
        product1.setProductCondition("New");
        product1.setProductStatus("Active");
        product1.setUnitInStock(15);
        product1.setProductManufacturer("Fender");

        product2.setProductName("Violin");
        product2.setProductCategory("Instrument");
        product2.setProductDescription("This is a amazing violin.");
        product2.setProductPrice(2000);
        product2.setProductCondition("Old");
        product2.setProductStatus("Active");
        product2.setUnitInStock(34);
        product2.setProductManufacturer("Asus");

        product3.setProductName("Harp");
        product3.setProductCategory("Stringed");
        product3.setProductDescription("This is a fender affordable harp.");
        product3.setProductPrice(450);
        product3.setProductCondition("New");
        product3.setProductStatus("Active");
        product3.setUnitInStock(7);
        product3.setProductManufacturer("HarpInc");

        productList = new ArrayList<Product>();

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        return productList;
    }
}
