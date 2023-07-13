package com.surokkha.usermanagementservice.user.service;
import static org.mockito.Mockito.*;
import com.surokkha.usermanagementservice.user.UserRepository;
import com.surokkha.usermanagementservice.user.dto.SignupDto;
import com.surokkha.usermanagementservice.user.mapper.UserMapper;
import com.surokkha.usermanagementservice.user.model.User;
import com.surokkha.usermanagementservice.user.model.UserRole;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = UserServiceTest.class)
class UserServiceTest {


    @Mock
    UserRepository userRepository;

    @Mock
     UserMapper userMapper;

    @Mock
     User user;
    @InjectMocks
    UserServiceImpl userService;

//    @Test
//    void signUp() {
//    }

    @Test
    public void testSignUp_NewUser_Success() {
        // Arrange
        SignupDto signupDto = new SignupDto();
        signupDto.setNid("1234567890");
        signupDto.setBirthCertificateId("ABC1234567890");
        signupDto.setName("John Doe");
        signupDto.setPhone("1234567890");
        signupDto.setUserRole(UserRole.CITIZEN);
        signupDto.setPassword("password");

        //user = userMapper.toEntity(signupDto);
        when(userRepository.findByNid(signupDto.getNid())).thenReturn(Optional.empty());
        when(userRepository.findByBirthCertificateId(signupDto.getBirthCertificateId())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(new User());
        when(userMapper.toEntity(signupDto)).thenReturn(user);
        //when(user.getPassword()).thenReturn(user.getPassword());
        // Act
        User result = userService.signUp(signupDto);

        // Assert
        assertNotNull(result);
//        verify(userRepository, times(1)).findByNid(signupDto.getNid());
//        verify(userRepository, times(1)).findByBirthCertificateId(signupDto.getBirthCertificateId());
//        verify(userRepository, times(1)).save(any(User.class));
    }


    @Test
    public void testGetUser_ExistingUser_Success() {
        // Arrange
        String userId = "123";
        User user = new User();
        user.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        User result = userService.getUser(userId);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getId());
    }




    @Test
    public void testCheckHashedPassword_PasswordMatch_ReturnsTrue() {
        // Arrange
        String hashedPassword = "hashedPassword";
        String password = "hashedPassword";

        // Act
        boolean result = userService.checkHashedPassword(hashedPassword, password);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testCheckHashedPassword_PasswordMismatch_ReturnsFalse() {
        // Arrange
        String hashedPassword = "hashedPassword";
        String password = "wrongPassword";

        // Act
        boolean result = userService.checkHashedPassword(hashedPassword, password);

        // Assert
        assertFalse(result);
    }

    @Test
    void getUser() {

       // List<User> myUsers = new ArrayList<User>();
        String userId = "123";
        User user = new User();
        user.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        User result = userService.getUser(userId);

        assertNotNull(result);
        assertEquals(userId, result.getId());
    }

//    @Test
//    void checkHashedPassword() {
//    }
}