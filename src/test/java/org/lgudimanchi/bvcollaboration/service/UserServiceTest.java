package org.lgudimanchi.bvcollaboration.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

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

        Assertions.assertEquals(user, userService.saveUser(user));

    }

    @Test
    @Transactional
    void validateUser() {
        User user = new User();
        user.setId(1);
        user.setFirstName("First");
        user.setLastName("Last");
        user.setEmail("abc@mnc.com");
        user.setLoginId("user");
        user.setPassword("user");
        user.setCompanyName("company");
        user.setPhoneNumber(1234567L);

        Assertions.assertEquals(user, userService.validateUser("user","user"));

    }
}