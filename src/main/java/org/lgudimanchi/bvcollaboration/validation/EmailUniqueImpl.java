package org.lgudimanchi.bvcollaboration.validation;



    import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
    import org.lgudimanchi.bvcollaboration.database.entity.User;
    import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.lgudimanchi.bvcollaboration.database.dao.UserDAO;

public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {

        public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);

        @Autowired
        private UserDAO userDao;

        @Override
        public void initialize(EmailUnique constraintAnnotation) {

        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if ( StringUtils.isEmpty(value) ) {
                return true;
            }

            User user = userDao.findByEmail(value);

            return ( user == null );
        }

    }
