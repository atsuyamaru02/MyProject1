package com.example.demo.form;

public class PurchaseForm {
	private int id;
	
	private String name;
	
	private int price;
	
	private String hotcold;
	
	private int quantity;

	public PurchaseForm(int id, String name, int price, String hotcold, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.hotcold = hotcold;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getHotcold() {
		return hotcold;
	}

	public void setHotcold(String hotcold) {
		this.hotcold = hotcold;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
}
