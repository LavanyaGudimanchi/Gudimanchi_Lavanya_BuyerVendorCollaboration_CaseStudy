package org.lgudimanchi.bvcollaboration.database.dao;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;


    @ParameterizedTest
    @ValueSource(strings = {"lgudimanchi@gmail.com"})
    @Order(1)
    void findByEmail(String input) {
        User expected = new User ();
        expected.setFirstName("Lavanya");
        expected.setLastName("Gudimanchi");
        expected.setPhoneNumber(6545643L);
        expected.setLoginId("Lavanya");

        User actual =  userDAO.findByEmail(input);

        Assertions.assertEquals(expected.getFirstName(),actual.getFirstName());
        Assertions.assertEquals(expected.getLastName(),actual.getLastName());
        Assertions.assertEquals(expected.getPhoneNumber(),actual.getPhoneNumber());
        Assertions.assertEquals(expected.getLoginId(),actual.getLoginId());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Lavanya"})
    @Order(2)
    void findByLoginId(String input) {

        User expected = new User ();
        expected.setEmail("lgudimanchi@gmail.com");
        expected.setFirstName("Lavanya");
        expected.setLastName("Gudimanchi");
        expected.setPhoneNumber(6545643L);

        User actual =  userDAO.findByLoginId(input);

        Assertions.assertEquals(expected.getFirstName(),actual.getFirstName());
        Assertions.assertEquals(expected.getLastName(),actual.getLastName());
        Assertions.assertEquals(expected.getPhoneNumber(),actual.getPhoneNumber());
        Assertions.assertEquals(expected.getEmail(),actual.getEmail());
    }

    @ParameterizedTest
    @ValueSource(strings = {"26"})
    @Order(3)
    void deleteById(String input) {

        userDAO.deleteById(Integer.valueOf(input));

        Optional<User> user = userDAO.findById(Integer.valueOf(input));

        Assertions.assertNotNull(user);

    }

    @ParameterizedTest
    @ValueSource(strings = {"Lavanya"})
    @Order(4)
    void Update(String input) {

        User user =  userDAO.findByLoginId(input);

        user.setEmail("gudimanchil@gmail.com");

        userDAO.save(user);

        User actual =  userDAO.findByLoginId(input);

        Assertions.assertEquals(user.getEmail(),actual.getEmail());

    }


}

