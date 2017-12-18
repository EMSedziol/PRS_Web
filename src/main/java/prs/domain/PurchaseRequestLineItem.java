package prs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseRequestLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="PurchaseRequestId")
	private PurchaseRequest purchaseRequest;
	
	private int productID;
	private int quantity;
	
	public PurchaseRequestLineItem() {
		id = 0;
		purchaseRequest = null;
		productID = 0;
		quantity = 0;
	}
	
	public PurchaseRequestLineItem(PurchaseRequest inPR, int inPdtID, int inQty) {
		purchaseRequest = inPR;
		productID = inPdtID;
		quantity = inQty;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonIgnore
	public PurchaseRequest getPurchaseRequest() {
		return purchaseRequest;
	}
	
	//@JsonIgnore
	public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
		this.purchaseRequest = purchaseRequest;
	}

	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "\npurchaseRequestLineItem [id=" + id + ", purchaseRequestID=" + purchaseRequest + ", productID="
				+ productID + ", quantity=" + quantity + "]";
	}
	
}
