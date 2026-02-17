package com.ecom.entity;

public class Product {
	
	private String productName;
	private int productID;
	private int price;
	private int availableQuantity;
	
	public Product() {
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	
	
	@Override
	public String toString() {
		return "product name- "+this.productName+" product id-"+ this.productID+" price -"+ this.price+"  quantity -"+this.availableQuantity;
	}

}