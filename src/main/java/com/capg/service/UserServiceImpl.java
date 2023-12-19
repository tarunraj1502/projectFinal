package com.capg.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.AdminDto;
import com.capg.dto.UserDto;
import com.capg.entity.User1;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.InvalidEmailException;
import com.capg.exception.InvalidNameException;
import com.capg.exception.InvalidPasswordException;
import com.capg.exception.UserAlreadyExistsException;
import com.capg.repository.UserRepository;
import com.capg.utility.AppConstant;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepository;
	
	public User1 registration(User1 user)
	{
		User1 local=this.userRepository.findByEmailId(user.getEmailId());
		System.out.println(local);
		if(local!=null)
		{
			throw new UserAlreadyExistsException(AppConstant.USER_IS_ALREADY_EXISTS);
		}
		else {
			if(!user.getUserName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)?$"))
			{
				throw new InvalidNameException(AppConstant.INVALID_NAME_INFO);
			}			
			if( !user.getEmailId().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) 
			{
				throw new InvalidEmailException(AppConstant.INVALID_EMAIL_INFO);
			}
			if(!user.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$")) 
			{
				throw new InvalidPasswordException(AppConstant.INVALID_PASSWORD_INFO);
			}
		}
		return userRepository.save(user);
	}
	
	
	public String deleteUser(int userId)throws IdNotFoundException
	{
		User1 user= userRepository.findByUserId(userId);
		if(user == null)
		{
			throw new IdNotFoundException(AppConstant.USER_ID_NOT_FOUND_INFO);
		}
		else {
			userRepository.deleteById(userId);
		}
		return "Id deleted Successfully";
	}
	
	public String login(User1 user) throws InvalidEmailException,InvalidPasswordException{
		User1 check_user = userRepository.findByEmailId(user.getEmailId().toLowerCase());
		if(check_user !=null) {
			if(check_user.getPassword().equals(user.getPassword())) {
				if (check_user.getUserType()=='u'||check_user.getUserType()=='U')
					return "Welcome User";
			}else {
				throw new InvalidPasswordException(AppConstant.USERNAME_OR_PASSWORD_MISMATCH);
			}
		}
		throw new InvalidEmailException(AppConstant.USERNAME_OR_PASSWORD_MISMATCH);
	}
	
	public String forgotUserPassword(UserDto userDto) throws InvalidEmailException,InvalidPasswordException{
		User1 user = userRepository.findByEmailId(userDto.getEmailId());
		if(user == null) {
			throw new InvalidEmailException(AppConstant.USER_INVALID_EMAIL_INFO);
		}else if(!userDto.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$"))
			throw new InvalidPasswordException(AppConstant.INVALID_PASSWORD_INFO);
		else{
			user.setPassword(userDto.getPassword());
			userRepository.save(user);
			return "Password Reset Successful";
		}
	}


	public AdminDto getAdminDashboard(int adminId) {
		   if (userRepository.existsById(adminId)) {
		        User1 user = userRepository.findByUserId(adminId);
		        AdminDto adminDto = new AdminDto();

		        if (user.getUserType()=='a'|| user.getUserType()=='A') {
		            adminDto.setUserId(user.getUserId());
		        } else {
		            throw new IdNotFoundException("Admin id not found");
		        }
		        return adminDto;
		    } else {
		        throw new IdNotFoundException("User id not found");
		    }
	}


	@Override
	
   public UserDto getUserDashboard(int userId) throws IdNotFoundException {

				if(userRepository.existsById(userId)) {
				User1 user =userRepository.findByUserId(userId);
				UserDto newUser=new UserDto();
				if(user.getUserType()=='u' || user.getUserType()=='U') {
				newUser.setUserId(user.getUserId());
				newUser.setUserName(user.getUserName());
				newUser.setEmailId(user.getEmailId());
				newUser.setMobileNo(user.getMobileNo());
				return newUser;
				}
				else {
					throw new IdNotFoundException("User Not Found");
				}
				}
				else {

					throw new IdNotFoundException("User id is not found");
				}
			}


	}