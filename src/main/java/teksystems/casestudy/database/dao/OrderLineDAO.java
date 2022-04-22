package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.OrderLine;

@Repository
public interface OrderLineDAO  extends JpaRepository<OrderLine, Integer> {

    public OrderLine findByProductId(Integer id);
}
