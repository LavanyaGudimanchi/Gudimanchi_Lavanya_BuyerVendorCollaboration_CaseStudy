package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.User;

@Repository
public interface OrderDAO extends JpaRepository<Order,Integer> {

    public Order getOrderByBuyer(User user);

    }
