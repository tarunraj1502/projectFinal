package com.capg.utility;

public class AppConstant {
	
	//--------Exceptions for movie
	public static final String MOVIE_ALREADY_EXIST_INFO = "MOVIE_IS_ALREADY_EXISTS";
    public static final String MOVIE_ID_NOT_FOUND_INFO="MOVIE_ID_IS_NOT_FOUND,ENTER_VALID_MOVIE_ID";
    public static final String MOVIE_NOT_FOUND_INFO="MOVIE_IS_NOT_FOUND";
    public static final String NULL_VALUE_INFO ="MOVIE_NAME_IS_NULL.ENTER_VALID_MOVIE_NAME";
    
    //------------Exception for hall
    public static final String SCREEN_ALREADY_EXISTS_INFO="SCREEN_IS_ALREADY_EXISTS_OR_INVALID_SCREEN";
    public static final String HALL_ID_NOT_FOUND_INFO="HALL_ID_IS_NOT_FOUND,ENTER_VALID_HALL_ID";
    public static final String INVALID_SCREEN_TYPE = "INVALID_SCREEN_TYPE,ENTER_VALID_SCREEN_TYPE";
    
    //-------------Exception for show
    public static final String INVALID_SLOT_NO_INFO="INVALID_SLOT_NUMBER,ENTER_A_VALID_NUMBER";
    public static final String SHOW_ALREADY_RUNNING_INFO = "A_SHOW_IS_ALREADY_RUNNING_IN_THE_HALL";
    public static final String SHOW_ID_NOT_FOUND_INFO="SHOW_ID_IS_NOT_FOUND,ENTER_VALID_SHOW_ID";
   
    
    //-------------Exception for seat type
    public static final String SEAT_ID_NOT_FOUND_INFO="SEAT_ID_IS_NOT_FOUND,ENTER_VALID_SEAT_ID";
	public static final String SEAT_ALREADY_EXISTS_INFO ="SEAT_IS_ALREADY_EXISTS";
	public static final String INVALID_SEAT_TYPE = "INVALID_SEAT_TYPE,ENTER_VALID_SEAT_TYPE";
	
	//------------Exception for user
	public static final String INVALID_NAME_INFO="INVALID_NAME_FORMAT";
	public static final String INVALID_EMAIL_INFO="INVALID_EMAIL_FORMAT";
	public static final String INVALID_PASSWORD_INFO="INVALID_PASSWORD_FORMAT";
	public static final String USER_INVALID_EMAIL_INFO="NO_USER_FOUND";
	public static final String USER_ID_NOT_FOUND_INFO="USER_ID_IS_NOT_FOUND";
	public static final String USERNAME_OR_PASSWORD_MISMATCH="USERNAME_OR_PASSWORD_MISMATCH";
	public static final String USER_IS_ALREADY_EXISTS = "USER_IS_ALREADY_EXISTS";
	
	
	//-------------------Excepiton for booking
	public static final String BEFORE_BOOKING_DATE_INFO="SHOW_DATE_IS_BEFORE_BOOKING_DATE";
    public static final String SHOW_NOT_IN_RANGE_INFO="SHOW_IS_NOT_IN_RANGE";
	public static final String SHOW_IS_NOT_AVAILABLE_INFO="SHOW_IS_NOT_AVAILABLE_IN_THE_DATE";
	public static final String SEAT_NOT_AVAILABLE_INFO="SEAT_IS_NOT_AVAILABLE";
	
	//---------------------Exception for cancelling
	public static final String BOOKING_ID_NOT_FOUND = "BOOKING_ID_IS_NOT_FOUND";
	public static final String CANCELLED_SEATS_INFO = "SEATS_ALREADY_CANCELLED";
	public static final String CANNOT_CANCEL_INFO = "CANNOT_CANCEL.CANCEL_SEAT_BEFORE_48_HOURS_OF_SHOW_DATE";
	
	
	
	
}
	
