package teksystems.casestudy.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HasOrdersImpl.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface HasOrders {

    String message() default "There are orders associated with this product. Product cannot be deleted. Please mark the product as out of stock";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

