package org.lgudimanchi.bvcollaboration.database.dao;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.lgudimanchi.bvcollaboration.database.entity.Product;
import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    @ParameterizedTest
    @ValueSource(strings = {"Ikat"})
    @Order(1)
    void findByCategory(String input) {

        List<Product> products = productDAO.findByCategory(input);

        assertEquals(products.size(), 3);


    }

    @ParameterizedTest
    @ValueSource(strings = {"26"})
    @Order(2)
    void findByVendorId(String input) {

        List<Product> products = productDAO.findByVendorId(Integer.valueOf(input));

        assertEquals(products.size(), 8);
    }

    @ParameterizedTest
    @ValueSource(strings = {"apalepu@gmail.com"})
    @Order(3)
    public void save(String input)
    {
        Product product = new Product();

        User user =  userDAO.findByEmail(input);

        product.setProductName("Testing");
        product.setProductDescription("Testing Description");
        product.setPrice(20.00);
        product.setIsAvailable('Y');
        product.setVendor(user);

       Product savedproduct =  productDAO.save(product);

       assertEquals(savedproduct.getProductName(),product.getProductName());
       assertEquals(savedproduct.getProductDescription(),product.getProductDescription());


    }

    @ParameterizedTest
    @ValueSource(strings = {"27"})
    @Order(4)
    public void delete(String input)
    {

        List<Product> products = productDAO.findByVendorId(Integer.valueOf(input));

        for (Product product:products
             ) {

            if (product.getProductName() =="Testing")
            {
                productDAO.delete(product);
            }
            }

        List<Product> newproducts = productDAO.findByVendorId(Integer.valueOf(input));

        Boolean found = false;
        for (Product product:newproducts
        ) {

            if (product.getProductName() =="Testing")
            {
                found = true;
            }
        }

        assertEquals(found,false);

    }


}

