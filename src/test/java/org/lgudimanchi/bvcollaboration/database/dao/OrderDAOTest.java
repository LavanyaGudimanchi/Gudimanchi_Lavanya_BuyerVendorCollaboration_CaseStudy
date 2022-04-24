package org.lgudimanchi.bvcollaboration.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.lgudimanchi.bvcollaboration.database.entity.Order;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderDAOTest {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private UserDAO userDAO;

    @ParameterizedTest
    @ValueSource(strings = {"Lavanya"})
    @org.junit.jupiter.api.Order(1)
    void save(String input)
    {
        Order order = new Order();
        order.setStatus("PENDING");
        order.setOrderTotal(200.00);

        User user =  userDAO.findByLoginId(input);
        order.setBuyer(user);

        Assertions.assertEquals(order, orderDAO.save(order));
    }


    @Test
    @org.junit.jupiter.api.Order(2)
    void getById()
    {
        Order order = new Order();
        order.setStatus("ORDERED");
        order.setOrderTotal(264.00);

        Assertions.assertEquals(order.getStatus(), orderDAO.getById(7).getStatus());
        Assertions.assertEquals(order.getOrderTotal(), orderDAO.getById(7).getOrderTotal());

    }
}