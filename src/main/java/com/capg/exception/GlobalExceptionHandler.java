package com.capg.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
 
	//----------------Exception handler for movies
	@ExceptionHandler(MovieAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> movieAlreadyExist(MovieAlreadyExistsException movieAlreadyExistException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(movieAlreadyExistException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(NullValueException.class)
	public ResponseEntity<ErrorInfo> nullValue(NullValueException nullValueException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(nullValueException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MovieNotExistsException.class)
	public ResponseEntity<ErrorInfo> movieNotExists(MovieNotExistsException movieNotExistException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(movieNotExistException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	//--------------------Exception handler for id not found
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorInfo> idNotFound(IdNotFoundException idNotFoundException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(idNotFoundException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	//---------------------Exception for Hall
	@ExceptionHandler(ScreenAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> screenExists(ScreenAlreadyExistsException screenExistsException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(screenExistsException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	//------------------Exception for show
	@ExceptionHandler(InvalidSlotNoException.class)
	public ResponseEntity<ErrorInfo> invalidSlotNo(InvalidSlotNoException invalidSlotException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(invalidSlotException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ShowAlreadyRunningException.class)
	public ResponseEntity<ErrorInfo> showRunning(ShowAlreadyRunningException showAlreadyRunningException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(showAlreadyRunningException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ShowNotInRangeException.class)
	public ResponseEntity<ErrorInfo> shownotInRange(ShowNotInRangeException showNotInRange)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(showNotInRange.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	//---------------------Exception for Seat type
	@ExceptionHandler(SeatAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> seatExists(SeatAlreadyExistsException seatAlreadyExists)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(seatAlreadyExists.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	//-----------------Exception for user
	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<ErrorInfo> invalidName(InvalidNameException invalidName)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(invalidName.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> userAlreadyExists(UserAlreadyExistsException userAlreadyExists)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(userAlreadyExists.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ErrorInfo> invalidEmail(InvalidEmailException invalidEmail)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(invalidEmail.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ErrorInfo> invalidPassword(InvalidPasswordException invalidPassword)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(invalidPassword.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	//---------------Exception for booking
	
	@ExceptionHandler(ShowDateNotFoundException.class)
	public ResponseEntity<ErrorInfo> beforeBookedDate(ShowDateNotFoundException beforeBooked)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(beforeBooked.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SeatNotAvailableException.class)
	public ResponseEntity<ErrorInfo> seatNotAvailable(SeatNotAvailableException seatNotAvailableException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(seatNotAvailableException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ShowNotAvailable.class)
	public ResponseEntity<ErrorInfo> showNotAvailable(ShowNotAvailable showNotAvailableException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(showNotAvailableException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	//--------------------exception handler for cancellation
	
	@ExceptionHandler(BookingAlreadyCancelledException.class)
	public ResponseEntity<ErrorInfo> bookingAlreadyCancelled(BookingAlreadyCancelledException alreadyCancelledException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(alreadyCancelledException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(CannotCancelException.class)
	public ResponseEntity<ErrorInfo> cannotCancel(CannotCancelException cannotCancelException)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(cannotCancelException.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
}