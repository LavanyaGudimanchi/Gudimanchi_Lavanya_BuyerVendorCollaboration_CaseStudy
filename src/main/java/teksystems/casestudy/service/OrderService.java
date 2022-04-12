package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.OrderDAO;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderdao;
}
