package com.capg.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class User1 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
    private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="mobile_no")
	private long mobileNo;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_type")
	private char userType;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JsonProperty(access=Access.WRITE_ONLY)
	private List<Booking> booking;

	public User1() {
		
	}

	public User1(int userId, String userName, long mobileNo, String emailId, String password, char userType,
			List<Booking> booking) {
		this.userId = userId;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
		this.userType = userType;
		this.booking = booking;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
		this.userType = userType;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "User1 [userId=" + userId + ", userName=" + userName + ", mobileNo=" + mobileNo + ", emailId=" + emailId
				+ ", password=" + password + ", userType=" + userType + ", booking=" + booking + "]";
	}
	
	
	
}
