package teksystems.casestudy.database.entity;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phoneNumber")
    private Long phoneNumber;

    @Column(name="companyName")
    private String companyName;

    @Column(name="loginId")
    private String loginId;

    @Column(name="password")
    private String password;

    @Column(name="addressLine1")
    private String addressLine1;

    @Column(name="addressLine2")
    private String addressLine2;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="zipcode")
    private Integer zipcode;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @Column(name ="isBuyer")
    private boolean isBuyer;

}
