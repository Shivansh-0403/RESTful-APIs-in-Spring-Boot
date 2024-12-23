package com.shivansh.springboot.restful_web_services.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String desc;
	private float rating;

	// @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date releaseDate;
	private String brand;
	private String category;

	private String imageName;
	private String imageType;
	@Lob
	private byte[] imageData;

	// public Product() {}
	
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", rating=" + rating + ", releaseDate="
				+ releaseDate + ", brand=" + brand + ", category=" + category + "]";
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public String getImageName() {
		return imageName;
	}
	public String getImageType() {
		return imageType;
	}
	public byte[] getImageData() {
		return imageData;
	}
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

}
