package teksystems.casestudy.database.entity;

import lombok.*;
import teksystems.casestudy.validation.HasOrders;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="products")
public class Product{

    @HasOrders
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
    private Character isAvailable;

    @Column(name ="category")
    private String category;

    @ManyToOne
    private User vendor;

}
