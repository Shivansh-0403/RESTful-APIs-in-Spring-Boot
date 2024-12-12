package com.shivansh.springboot.restful_web_services.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String desc;
	private float rating;
	
	// @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date releaseDate;
	private String brand;
	private String category;

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	public float getRating() {
		return rating;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public String getBrand() {
		return brand;
	}
	public String getCategory() {
		return category;
	}

	public Product() {}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", rating=" + rating + ", releaseDate="
				+ releaseDate + ", brand=" + brand + ", category=" + category + "]";
	}

	public Product(int id, String name, String desc, float rating, Date releaseDate, String brand, String category) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.brand = brand;
		this.category = category;
	}
	
}
