package com.example.demoAPI;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	ProductDAO p = new ProductDAO();
	
	
	@GetMapping("/hello/{name}")
	public String helloWorld(@PathVariable("name") String name) {
		System.out.println("Hello ");
		return "Return -- Hello my name is " + name;
	}
	
	@GetMapping("/cartProducts")
	public ArrayList<ProductDetails> productsInCart() {
		return p.showCart();
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody ProductDetails item) {
		p.addProduct(item);
		return "Product Added Successfully - " + item.getProductName();
	}
	
	//FIX
	@DeleteMapping("/removeProduct/{itemName}")
	public String removeProduct(@PathVariable("itemName") String itemName) {
		p.removeProduct(itemName);
		return "Product Removed From Cart - " + itemName;
	}
	
	@GetMapping("/cartCount")
	public int cartCount() {
		return p.cartCount();
	}
	
	@GetMapping("/cartTotal")
	public double cartTotal() {
		return p.cartTotal();
	}
}
