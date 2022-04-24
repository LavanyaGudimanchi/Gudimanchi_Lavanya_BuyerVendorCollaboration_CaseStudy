package org.lgudimanchi.bvcollaboration.service;

import org.lgudimanchi.bvcollaboration.database.dao.OrderLineDAO;
import org.lgudimanchi.bvcollaboration.database.entity.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {

    @Autowired
    private OrderLineDAO orderlinedao;

    public void save(OrderLine orderLine) {
        orderlinedao.save(orderLine);
    }

}
