package com.ecom.services;

import java.util.HashMap;
import java.util.Map;

import com.ecom.entity.Product;

public class ProductCart {

    private ProductServices productServices;
    private Map<Product, Integer> cart = new HashMap<>();

    
    public ProductCart(ProductServices productServices) {
        this.productServices = productServices;
    }

    public void addProduct(String productName, int quantity) throws Exception {

        Product product = productServices.searchProduct(productName);

        if (product == null) {
            throw new Exception("Product not found");
        }

        if (product.getAvailableQuantity() < quantity) {
            throw new Exception("Insufficient stock");
        }

        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void remove(String productName) throws Exception {

        Product product = productServices.searchProduct(productName);

        if (product == null) {
            throw new Exception("Product not found");
        }

        if (!cart.containsKey(product)) {
            throw new Exception("Product not in cart");
        }

        cart.remove(product);
    }

    public void updateQuantity(String productName, int quantity) throws Exception {

        Product product = productServices.searchProduct(productName);

        if (product == null) {
            throw new Exception("Product not found");
        }

        if (!cart.containsKey(product)) {
            throw new Exception("Product not in cart");
        }

        cart.put(product, quantity);
    }

    public void viewCart() {
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey().getProductName() +
                    " -> " + entry.getValue());
        }
    }
    public void totalPrice() {
    	int total=0;
    	for(var i:cart.entrySet()) {
    		total=total+(i.getKey()).getPrice()*i.getValue();
    	}
    	System.out.println("Total Price="+total);
    }
    //helper function
    public Map<Product,Integer> getAllCartProduct(){
    	return cart;
    }
    //helper function
    public void clearCart() {
        cart.clear();
    }

}
