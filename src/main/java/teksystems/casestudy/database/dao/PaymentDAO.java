package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.Payment;

@Repository
public interface PaymentDAO extends JpaRepository<Payment,Integer> {



}
