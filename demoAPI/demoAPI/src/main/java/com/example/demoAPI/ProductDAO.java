package com.example.demoAPI;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ProductDAO {
	ArrayList<ProductDetails> cart = new ArrayList<ProductDetails>();
	double total;
	
	
	ProductDAO(){
		ProductDetails p = new ProductDetails();
		p.setProductName("Atomic Aquatics Blade Fins");
		p.setProductPrice(150.00);
		this.addProduct(p);
		
		ProductDetails p2 = new ProductDetails();
		p2.setProductName("Cressi Alligator Scissor & Knife");
		p2.setProductPrice(58.07);
		this.addProduct(p2);
	}
	
	//Add new product to cart -- CREATE
	public String addProduct(ProductDetails p) {
		cart.add(p);
		return "Product added";
	}
	
	//Showing all products in cart -- READ -- REST: GetMapping
	public ArrayList<ProductDetails> showCart() {
		return cart;
	}
	
	//Update 
	
	//Remove product from cart -- DELETE
	public void removeProduct(String itemName) {
		for (ProductDetails item : cart) {
			if (item.getProductName().replace(" ","").equals(itemName)) {
				cart.remove(item);
			}
		}
	}
	
	public int cartCount() {
		return cart.size();
	}
	
	public double cartTotal() {
		for (ProductDetails item : cart) {
			total += item.getProductPrice();
		}
		return total;
	}
	


}
