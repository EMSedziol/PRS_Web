package prs.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonProperty("UserName")
	private String userName;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("FirstName")
	private String firstName;
	
	@JsonProperty("LastName")
	private String lastName;
	
	@JsonProperty("Phone")
	private String phone;
	
	@JsonProperty("Email")
	private String email;
	
	@Column(name="isreviewer")
	@JsonProperty("IsReviewer")
	private boolean reviewer;
	
	@Column(name="isadmin")
	@JsonProperty("IsAdmin")
	private boolean admin;
	
	@Column(name="isactive")
	private boolean active;
	
//	@Column(name="datecreated")
//	@JsonProperty("DateCreated")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss.SSS")
//	private Timestamp DateCreated;
	
	public User() {
		userName = "";
		password = "";
	}
	
	public User(String userName, String passWord, String firstName, String lastName,
			String phone, String email, boolean reviewer, boolean admin, boolean active) {
		setId(id);
		setUserName(userName);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setEmail(email);
		setReviewer(reviewer);
		setAdmin(admin);
		setActive(active);
	}
	
/*	public Timestamp getDateCreated() {
		return DateCreated;
	}

	public void setDateCreated(Timestamp date) {
		this.DateCreated = date;
	}
*/
	public int getId() {
		return id;
	}
	public void setId(int rowId) {
		this.id = rowId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public boolean isReviewer() {
		return reviewer;
	}
	public void setReviewer(boolean reviewer) {
		this.reviewer = reviewer;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) { 
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + ", reviewer=" + reviewer
				+ ", admin=" + admin + ", active=" + active + "]";
	}
	


}
