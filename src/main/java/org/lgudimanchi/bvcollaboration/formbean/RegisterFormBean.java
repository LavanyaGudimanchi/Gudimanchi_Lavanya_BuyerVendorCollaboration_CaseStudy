package org.lgudimanchi.bvcollaboration.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.lgudimanchi.bvcollaboration.validation.EmailUnique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@ToString
@Getter@Setter
public class RegisterFormBean {

    private Long  phoneNumber;

    private String companyName;

    private Integer id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @EmailUnique(message = "Email already exists in database")
    @NotBlank(message = "Email is required")
    @Email(message = "@Email from spring validator")
    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Email format invalid in regex check")
    private String email;

    private String loginId;

    @Length(min = 3, max = 15, message="Password must be between 3 and 15 characters")
    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private Integer zipcode;

}
