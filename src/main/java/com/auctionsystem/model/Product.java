package com.auctionsystem.model;

public class Product {
	
	private int id;
	private String name;
	private String description;
	private int category;
	

	
	
	public Product() {
	}





	public Product(int id, String name, String description, int category) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
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




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public int getCategory() {
		return category;
	}




	public void setCategory(int category) {
		this.category = category;
	}




	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category + "]";
	}


	
	
	
	

}
