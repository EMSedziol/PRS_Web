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

	private int userId;
	
	private String description = "";
	
	private String justification = "";
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Timestamp dateNeeded;
	
	private String deliveryMode;
	
	private int statusId;
	
	private double total;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Timestamp submittedDate;  // not entered  by the user
	
	public PurchaseRequest() {
		id = 0;
		userId = 0;
		description = "";
		justification = "";
		dateNeeded = new Timestamp(System.currentTimeMillis());
		deliveryMode = "";
		statusId = 0;
		total = 0.0;
		submittedDate = new Timestamp(System.currentTimeMillis());
	}
	
	public PurchaseRequest(int conId, int conUserId, String conDescription, String conJustification, Timestamp conDateNeeded,
			String conDeliveryMode, int conStatusId, double conTotal, Timestamp conSubmittedDate) {
		id = conId;
		userId = conUserId;
		description = conDescription;
		justification = conJustification;
		dateNeeded = conDateNeeded;
		deliveryMode = conDeliveryMode;
		statusId = conStatusId;
		total = conTotal;
		submittedDate = conSubmittedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
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

	@Override
	public String toString() {
		return "PurchaseRequest [id=" + id + ", userId=" + userId + ", description=" + description + ", justification="
				+ justification + ", dateNeeded=" + dateNeeded + ", deliveryMode=" + deliveryMode + ", statusId="
				+ statusId + ", total=" + total + ", submittedDate=" + submittedDate + "]";
	}
	

}
