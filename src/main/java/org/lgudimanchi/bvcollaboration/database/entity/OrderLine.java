package org.lgudimanchi.bvcollaboration.database.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="orderlines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToOne
    private Product product;

    @Column(name="quantity")
    private Integer quantity;

    @ManyToOne
    private Order order;

}
