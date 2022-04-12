package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.PaymentDAO;

@Service
public class PaymentService {

    @Autowired
    private PaymentDAO paymentdao;
}
