package teksystems.casestudy.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;
import teksystems.casestudy.database.entity.User;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService us;

    @Test
    void saveUser() {
        User user = new User();

//        user.setFirstName("First");
//        user.setLastName("Last");
//        user.setEmail("abc@mnc.com");
//        user.setLoginId("user");
//        user.setPassword("user");
//        user.setCompanyName("company");
//        user.setPhoneNumber(1234567L);

        Assertions.assertEquals(user, us.saveUser(user));

    }

    @Test
    @Transactional
    void validateUser() {
        User user = new User();
//        user.setId(1);
//        user.setFirstName("First");
//        user.setLastName("Last");
//        user.setEmail("abc@mnc.com");
//        user.setLoginId("user");
//        user.setPassword("user");
//        user.setCompanyName("company");
//        user.setPhoneNumber(1234567L);

        Assertions.assertEquals(user, us.validateUser("user","user"));

    }
}