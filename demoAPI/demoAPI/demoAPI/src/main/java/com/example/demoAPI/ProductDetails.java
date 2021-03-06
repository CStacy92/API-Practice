
package com.example.demoAPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long productID;
	private String productName;
	private double productPrice;
	private String description;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}
