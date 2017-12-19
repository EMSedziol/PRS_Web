package prs.domain;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class PurchaseRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;
	
	@JsonProperty("Description")
	private String description = "";
	
	@JsonProperty("Justification")
	private String justification = "";
	
	@JsonProperty("DateNeeded")
	private Timestamp dateNeeded;
	
	@JsonProperty("DeliveryMode")
	private String deliveryMode;
	
	@ManyToOne
	@JoinColumn(name="StatusId")
	private Status status;
	
	@JsonProperty("Total")
	private double total;
	
	private Timestamp submittedDate;  // not entered  by the user
	
	@OneToMany(mappedBy = "purchaseRequest", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JoinColumn(name="PurchaseRequestID")
	private List<PurchaseRequestLineItem> lineItems;

	public PurchaseRequest() {
		
	}

public PurchaseRequest(int id, User user, String description, 
			Status status) {
		this.id = id;
		this.user = user;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Timestamp getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(Timestamp dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	public Timestamp getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Timestamp submittedDate) {
		this.submittedDate = submittedDate;
	}


	public List<PurchaseRequestLineItem> getLineItems() {
		return lineItems;
	}


	public void setLineItems(List<PurchaseRequestLineItem> lineItems) {
		this.lineItems = lineItems;
	}
	

}
