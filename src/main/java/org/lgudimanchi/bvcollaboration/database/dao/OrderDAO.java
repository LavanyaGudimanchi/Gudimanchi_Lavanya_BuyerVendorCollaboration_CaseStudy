package org.lgudimanchi.bvcollaboration.database.dao;

import org.lgudimanchi.bvcollaboration.database.entity.Order;
import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order,Integer> {

    public Order getOrderByBuyerAndStatus(User user, String status);

    @Query("select o from Order o where o.buyer.id = ?1 and o.status <> ?2")
    public List<Order> getPlacedOrders(Integer userId, String status);

    @Query(value = "select sum(price * quantity) as grandtotal \n" +
            "from products p, orderlines ol, orders o \n" +
            "where p.id = ol.product_id and o.id = ol.order_id\n" +
            "and o.buyer_id = ?1 and status = \"PENDING\";", nativeQuery = true)
    public Double getGrandTotal(Integer userId);


    }
