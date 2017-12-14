package prs.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@JsonProperty("Code")
	private String code;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Address")
	private String address;
	
	@JsonProperty("City")
	private String city;
	
	@JsonProperty("State")
	private String state;
	
	@JsonProperty("Zip")
	private String zip;
	
	@JsonProperty("Phone")
	private String phone;
	
	@JsonProperty("Email")
	private String email;
	@JsonProperty("IsPreApproved")
	@Column(name="ispreapproved")
	private boolean isPreApproved;
	
	@JsonProperty("IsActive")
	@Column(name="isactive")
	private boolean isActive;
	
	@OneToMany(mappedBy = "vendor", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name="productId")  replaced by mappedBy in Spring
	@JsonIgnore  //
	private List<Product> products;  // this needs getter/setters in this class
	
/*	SELECT v.name, v.code, p.partnumber, p.name
	FROM vendor v
	join product p on  v.ID=p.ProductId
	*/
	
	public Vendor() {
		
	}
	
	public Vendor(int id, String code, String name, String address, String city, String state, String zip, String phone,
			String email, boolean isPreApproved, boolean isActive) {
		setId(id);
		setCode(code);
		setName(name);
		setAddress(address);
		setCity(city);
		setState(state);
		setZip(zip);
		setPhone(phone);
		setEmail(email);
		setPreApproved(isPreApproved);
		setActive(isActive);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isPreApproved() {
		return isPreApproved;
	}
	public void setPreApproved(boolean isPreApproved) {
		this.isPreApproved = isPreApproved;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", code=" + code + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email=" + email + ", isPreApproved="
				+ isPreApproved + ", isActive=" + isActive + ", products=" + products + "]";
	}
}
