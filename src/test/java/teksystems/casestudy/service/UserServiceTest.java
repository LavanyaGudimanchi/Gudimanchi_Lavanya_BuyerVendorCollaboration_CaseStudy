package teksystems.casestudy.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import teksystems.casestudy.database.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private static UserService us;

    @BeforeAll
    public static void Setup() {
        us = new UserService();
    }

    @Test
    void getUserbyID() {

    }

    @Test
    void saveUser() {
        User user = new User();
        user.setFirstName("First");
        user.setLastName("Last");
        user.setEmail("abc@mnc.com");
        user.setLoginId("user");
        user.setPassword("user");
        user.setCompanyName("company");
        user.setPhoneNumber(1234567L);

        Assertions.assertEquals(user, us.saveUser(user));





    }
}