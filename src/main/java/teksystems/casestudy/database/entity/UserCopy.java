package teksystems.casestudy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class UserCopy {



    public String firstName;

    public String getFirstName() {
        return firstName;
    }

    public String lastName;


    public String email;


    public Long phoneNumber;


    public String companyName;


    public String loginId;


    public String password;



    public String confirmPassword;

}
