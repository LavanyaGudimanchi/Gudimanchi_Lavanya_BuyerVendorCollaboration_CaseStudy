package org.lgudimanchi.bvcollaboration.database.dao;

import org.lgudimanchi.bvcollaboration.database.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDAO extends JpaRepository<Payment,Integer> {



}
