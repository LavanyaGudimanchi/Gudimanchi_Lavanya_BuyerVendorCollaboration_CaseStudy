package teksystems.casestudy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="paymentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate = new Date();

    @Column(name ="amountPaid")
    private Double amountPaid;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "orders_payments",
            joinColumns = {
                    @JoinColumn(name = "payment_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "order_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Order> orders = new ArrayList<>();
}
