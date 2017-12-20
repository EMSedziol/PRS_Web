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
	
	private int purchaseRequestId;
	private int productID;
	private int quantity;
	
	public PurchaseRequestLineItem() {
		id = 0;
		purchaseRequestId = 0;
		productID = 0;
		quantity = 0;
	}
	
	public PurchaseRequestLineItem(int conPR, int conProductId, int conQuantity) {
		id = conPR;
		productID = conProductId;
		quantity = conQuantity;
	} // note 'con' indicates constructor
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPurchaseRequestId() {
		return purchaseRequestId;
	}

	public void setPurchaseRequestId(int purchaseRequestId) {
		this.purchaseRequestId = purchaseRequestId;
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
		return "\npurchaseRequestLineItem [id=" + id + ", purchaseRequestID=" + purchaseRequestId + ", productID="
				+ productID + ", quantity=" + quantity + "]";
	}
	
}
