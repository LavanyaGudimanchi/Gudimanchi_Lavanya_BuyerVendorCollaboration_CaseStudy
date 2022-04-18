package teksystems.casestudy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();

    @ManyToOne
    private User buyer;

    @Column(name ="orderTotal")
    private Double orderTotal;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderlines = new ArrayList<>();

    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<Payment> payment = new ArrayList<>();
}
