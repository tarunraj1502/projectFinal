package com.capg.service;

import java.util.List;

import com.capg.dto.AdminDto;
import com.capg.dto.UserDto;
import com.capg.entity.User1;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.InvalidEmailException;
import com.capg.exception.InvalidNameException;
import com.capg.exception.InvalidPasswordException;
import com.capg.exception.UserAlreadyExistsException;

public interface UserService {

	 User1 registration(User1 user)
			throws UserAlreadyExistsException, InvalidEmailException, InvalidPasswordException, InvalidNameException;

	 String deleteUser(int userId) throws IdNotFoundException;

	 String login(User1 user) throws InvalidEmailException, InvalidPasswordException;

	 String forgotUserPassword(UserDto userDto) throws InvalidEmailException,InvalidPasswordException;

	UserDto getUserDashboard(int userId);

	
	

}
