package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.OrderLineDAO;
import teksystems.casestudy.database.entity.OrderLine;

@Service
public class OrderLineService {

    @Autowired
    private OrderLineDAO orderlinedao;

}
