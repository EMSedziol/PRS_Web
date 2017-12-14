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
	@ManyToOne
	@JoinColumn(name="vendorid")
	private Vendor vendor;
	
	@Column(name="productid")
	private int productId;
	
	@Column(name="partnumber")
	@JsonProperty("PartNumber")
	private String partNumber;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Price")
	private double price;
	
	@JsonProperty("Unit")
	private String unit;
	
	@Column(name="photopath")
	@JsonProperty("Photopath")
	private String photopath;

	
	public Product() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
/*
	public static Product getProduct() {
		return product;
	}*/
	
	@Override
	public String toString() {
		return "\nProduct [id=" + id + ", vendor=" + vendor + ", productId=" + productId + ", partNumber="
				+ partNumber + ", name=" + name + ", price=" + price + ", unit=" + unit + ", photopath=" + photopath
				+"]";
	}

}
