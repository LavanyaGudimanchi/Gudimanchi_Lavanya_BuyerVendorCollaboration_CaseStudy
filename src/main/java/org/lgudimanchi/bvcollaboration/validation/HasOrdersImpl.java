package org.lgudimanchi.bvcollaboration.validation;


import org.lgudimanchi.bvcollaboration.database.entity.OrderLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.lgudimanchi.bvcollaboration.database.dao.OrderLineDAO;

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
