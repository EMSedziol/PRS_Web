package prs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Product {

//	private static final Product product = null;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int vendorId;
	
	private String partNumber;
	
	private String name;
	
	private double price;
	
	private String unit;
	
	private String photopath;

	public Product() {
		id = 0;
		vendorId = 0;
		partNumber = "";
		name = "";
		price = 0.0;
		unit = "";
		photopath = "";
		
	}
	
	
	public Product(int id, int vendorId, String partNumber, String name, 
			double price, String unit, String photopath) {
		this.id = id;
		vendorId = 0;
		partNumber = "";
		name = "";
		price = 0.0;
		unit = "";
		photopath = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", vendorId=" + vendorId + ", partNumber=" + partNumber + ", name=" + name
				+ ", price=" + price + ", unit=" + unit + ", photopath=" + photopath + "]";
	}



}
