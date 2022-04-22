package teksystems.casestudy.validation;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import teksystems.casestudy.database.dao.OrderLineDAO;
import teksystems.casestudy.database.dao.ProductDAO;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.OrderLine;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HasOrdersImpl implements ConstraintValidator<HasOrders, Integer> {

    public static final Logger LOG = LoggerFactory.getLogger(HasOrdersImpl.class);

    @Autowired
    private OrderLineDAO orderLineDAO;

    @Override
    public void initialize(HasOrders constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if ( value == null ) {
            return true;
        }

        if ( orderLineDAO == null ) {
            return true;
        }

        OrderLine orderLine = orderLineDAO.findByProductId(value);

        return ( orderLine == null );
    }

}
