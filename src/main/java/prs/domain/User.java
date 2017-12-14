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
	private String UserName;
	
	@JsonProperty("Password")
	private String PassWord;
	
	@JsonProperty("FirstName")
	private String FirstName;
	
	@JsonProperty("LastName")
	private String LastName;
	
	@JsonProperty("Phone")
	private String Phone;
	
	@JsonProperty("Email")
	private String Email;
	
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
		UserName = "";
		PassWord = "";
	}
	
	public User(String UserName, String PassWord, String FirstName, String LastName,
			String Phone, String Email, boolean reviewer, boolean admin, boolean active) {
		setId(id);
		setUserName(UserName);
		setPassWord(PassWord);
		setFirstName(FirstName);
		setLastName(LastName);
		setPhone(Phone);
		setEmail(Email);
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
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String PassWord) {
		this.PassWord = PassWord;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
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
		return "User [UserName=" + UserName
				+ ", password=" + PassWord
				+ ", FirstName=" + FirstName
				+ ", LastName=" + LastName
				+ ", Phone=" + Phone
				+ ", Email=" + Email
				+ ", reviewer=" + reviewer
				+ ", admin=" + admin
				+ ", active=" + active 
				+  "]";
	}

}
