package com.capg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserDto {
	private int userId;
	private String userName;
	@JsonProperty(access=Access.WRITE_ONLY)
	private char userType;
	private long mobileNo;
	private String emailId;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	private String movieListUrl;
	private String movieByNameUrl;
	private String movieByIdUrl;
	private String showByIdUrl;
	private String showBetweenDatesUrl;
	private String bookingSeatUrl;
	private String cancelSeatUrl;
	private String forgotPasswordUrl;
	
	
	
	public UserDto() {
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
		this.movieListUrl="localhost:9080/api/v1/user/getAllMovie";
		this.movieByNameUrl="localhost:9080/api/v1/user/movie/{movieName}";
		this.movieByIdUrl="localhost:9080/api/v1/user/getMovie/{movieId}";
		this.showByIdUrl="localhost:9080/api/v1/user/getShow/{showId}";
		this.showBetweenDatesUrl="localhost:9080/api/v1/user/betweenDates";
		this.bookingSeatUrl="localhost:9080/api/v1/user/booking";
		this.cancelSeatUrl="localhost:9080/api/v1/user/cancelBooking/new/{bookingId}";
		this.forgotPasswordUrl="localhost:9080/api/v1/user/forgotPassword";
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
		this.userType = userType;
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

	public String getMovieListUrl() {
		return movieListUrl;
	}

	public void setMovieListUrl(String movieListUrl) {
		this.movieListUrl = movieListUrl;
	}

	public String getMovieByNameUrl() {
		return movieByNameUrl;
	}

	public void setMovieByNameUrl(String movieByNameUrl) {
		this.movieByNameUrl = movieByNameUrl;
	}

	public String getMovieByIdUrl() {
		return movieByIdUrl;
	}

	public void setMovieByIdUrl(String movieByIdUrl) {
		this.movieByIdUrl = movieByIdUrl;
	}

	public String getShowByIdUrl() {
		return showByIdUrl;
	}

	public void setShowByIdUrl(String showByIdUrl) {
		this.showByIdUrl = showByIdUrl;
	}

	public String getShowBetweenDatesUrl() {
		return showBetweenDatesUrl;
	}

	public void setShowBetweenDatesUrl(String showBetweenDatesUrl) {
		this.showBetweenDatesUrl = showBetweenDatesUrl;
	}

	public String getBookingSeatUrl() {
		return bookingSeatUrl;
	}

	public void setBookingSeatUrl(String bookingSeatUrl) {
		this.bookingSeatUrl = bookingSeatUrl;
	}

	public String getCancelSeatUrl() {
		return cancelSeatUrl;
	}

	public void setCancelSeatUrl(String cancelSeatUrl) {
		this.cancelSeatUrl = cancelSeatUrl;
	}

	public String getForgotPasswordUrl() {
		return forgotPasswordUrl;
	}

	public void setForgotPasswordUrl(String forgotPasswordUrl) {
		this.forgotPasswordUrl = forgotPasswordUrl;
	}

	@Override
	public String toString() {
		return "UsersDto [userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", mobileNo="
				+ mobileNo + ", emailId=" + emailId + "]";
	}
	
}
