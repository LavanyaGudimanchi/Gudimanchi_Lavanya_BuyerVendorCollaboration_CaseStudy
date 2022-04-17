package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.OrderLineDAO;
import teksystems.casestudy.database.entity.OrderLine;
import teksystems.casestudy.database.entity.Product;

@Service
public class OrderLineService {

    @Autowired
    private OrderLineDAO orderlinedao;

    public void save(OrderLine orderLine) {
    }
}
