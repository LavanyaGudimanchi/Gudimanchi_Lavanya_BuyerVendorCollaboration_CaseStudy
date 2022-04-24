package org.lgudimanchi.bvcollaboration.service;

import org.lgudimanchi.bvcollaboration.database.dao.PaymentDAO;
import org.lgudimanchi.bvcollaboration.database.entity.Order;
import org.lgudimanchi.bvcollaboration.database.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
