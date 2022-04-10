package teksystems.casestudy.database.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="products")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name ="productName")
    private String productName;

    @Column(name ="productDescription")
    private String productDescription;

    @Column(name ="price")
    private Double price;

    @Column(name ="isAvailable")
    private boolean isAvailable;

    @ManyToOne
    private User user;

}
