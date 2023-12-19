package com.capg;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.dto.UserDto;
import com.capg.entity.User1;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.InvalidEmailException;
import com.capg.exception.InvalidNameException;
import com.capg.exception.InvalidPasswordException;
import com.capg.exception.UserAlreadyExistsException;
import com.capg.repository.UserRepository;
import com.capg.service.UserServiceImpl;
import com.capg.utility.AppConstant;

@SpringBootTest
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;
@Test
void testRegistration() throws UserAlreadyExistsException, InvalidEmailException, InvalidPasswordException, InvalidNameException{
    User1 user = new User1();
    user.setEmailId("athulya@gmail.com");
    user.setUserName("athulya");
    user.setPassword("athu@123");

    when(userRepository.findByEmailId("athulya@gmail.com")).thenReturn(null);
    when(userRepository.save(user)).thenReturn(user);

    User1 createdUser = userService.registration(user);

    assertNotNull(createdUser);
    assertEquals("athulya@gmail.com", createdUser.getEmailId());
}

//@Test
//void testRegistration_UserAlreadyExistsException() {
//    User1 user = new User1();
//    user.setEmailId("athulya@gmail.com");
//
//    when(userRepository.findByEmailId("athulya@gmail.com")).thenReturn(user);
//
//    assertThrows(UserAlreadyExistsException.class,() -> userService.registration(user));
//}
//
//@Test
//void testRegistration_InvalidNameException() {
//    User1 user = new User1();
//    user.setUserName("723sukku");
//
//    assertThrows(InvalidNameException.class, () -> userService.registration(user));
//}

@Test
void testDeleteUser() throws IdNotFoundException
 {
    int userId = 1;
    User1 user = new User1();
    user.setUserId(userId);

    when(userRepository.findByUserId(userId)).thenReturn(user);

    String result = userService.deleteUser(userId);

    assertEquals("Id deleted Successfully", result);
    verify(userRepository, times(1)).deleteById(userId);
}
//@Test
//void testForgotPassword(){
//    UserDto userDto = new UserDto();
//    userDto.setEmailId("rachana@gmail.com");
//    userDto.setPassword("rachana@123");
//   
//
//    User1 user = new User1();
//    user.setEmailId("rachana@gmail.com");
//    user.setPassword("rachana@123");
//    when(userRepository.findByEmailId("rachana@gmail.com")).thenReturn(user);
//    when(userRepository.save(any(User1.class))).thenReturn(user);
//    try {
//    String result = userService.forgotUserPassword(userDto);
//    assertEquals("Password Reset Successful", result); 
//    assertEquals("Akila@123", user.getPassword());
//    }catch(InvalidEmailException e) {
//    	assertEquals(AppConstant.INVALID_EMAIL_INFO,e.getMsg());
//    }catch(InvalidPasswordException e) {
//    	assertEquals(AppConstant.INVALID_PASSWORD_INFO,e.getMsg());
//    }
//}
private void assertThrows(Class<UserAlreadyExistsException> class1, Object object) {
	// TODO Auto-generated method stub
	
}

private void assertEquals(String string, String emailId) {
	// TODO Auto-generated method stub
	
}
private void assertNotNull(User1 createdUser) {
	// TODO Auto-generated method stub
	
}


}