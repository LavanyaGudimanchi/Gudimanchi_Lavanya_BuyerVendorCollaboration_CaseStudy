package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.OrderDAO;
import teksystems.casestudy.database.dao.PaymentDAO;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.Payment;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentDAO paymentdao;

   public void savePayment(Payment payment)
   {
       paymentdao.save(payment);
   }
    public void addOrder(Payment payment, Order order)
    {
        payment.getOrders().add(order);
        paymentdao.save(payment);
    }
}
