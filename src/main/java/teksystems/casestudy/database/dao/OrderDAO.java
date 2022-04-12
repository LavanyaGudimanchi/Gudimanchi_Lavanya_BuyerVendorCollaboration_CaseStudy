package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order,Integer> {
}
