package com.store.model;


import lombok.Data;

@Data
public class Product {

	private Integer id;
	private String name;
	private String description;
	private double price; 
	private String category;
}
