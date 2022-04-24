package org.lgudimanchi.bvcollaboration.database.dao;

import org.lgudimanchi.bvcollaboration.database.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineDAO  extends JpaRepository<OrderLine, Integer> {

    public OrderLine findByProductId(Integer id);
}
