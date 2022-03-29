package com.example.demoAPI;

import java.util.List;

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
	ProductDetailsJPA cart;
	
	@GetMapping("/hello/{name}")
	public String helloWorld(@PathVariable("name") String name) {
		System.out.println("Hello ");
		return "Return -- Hello my name is " + name;
	}
	
	
	@GetMapping("/cartProducts")
	public List<ProductDetails> productsInCart() {
		return cart.findAll();
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody ProductDetails item) {
		cart.save(item);
		return "Product Added Successfully";
	}
	
	//FIX
	@DeleteMapping("/removeProduct/{itemID}")
	public String removeProduct(@PathVariable("itemID") long itemID) {
		cart.deleteById(itemID);
		return "Item removed from cart";
	}
	
	@GetMapping("/cartCount")
	public long cartCount() {
		return cart.count();
	}
	
	@GetMapping("/cartTotal")
	public double cartTotal() {
		double total = 0;
		for(ProductDetails item : cart.findAll()) {
			total += item.getProductPrice();
		}
		return total;
	}

}
