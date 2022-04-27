package org.lgudimanchi.bvcollaboration.controller;

import org.lgudimanchi.bvcollaboration.database.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.lgudimanchi.bvcollaboration.database.entity.Order;
import org.lgudimanchi.bvcollaboration.service.OrderService;
import org.lgudimanchi.bvcollaboration.service.PaymentService;

@PreAuthorize("hasAuthority('BUYER')")
@Controller
public class PaymentController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("buyer/payment")
    public ModelAndView capturePayment(@RequestParam("orderId") Integer[] orderIds) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/payment");
        Double paymentTotal = 0.0;
        Order order;
        for (Integer orderId : orderIds) {
            order = orderService.getOrderById(orderId);
            paymentTotal += order.getOrderTotal();
        }
        response.addObject("paymentTotal", paymentTotal);
        response.addObject("orderIds", orderIds);

        return response;
    }

    @GetMapping("buyer/paymentSubmit")
    public ModelAndView paymentSuccess(@RequestParam("orderId") Integer[] orderIds) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/paymentsuccess");


        // loop thought all order Ids
        // for each if
        // I got the order by user id
        //then i changed the status of the order to paid
        Order order;
        Double paymentTotal = 0.0;
        for (Integer orderId : orderIds) {
            order = orderService.getOrderById(orderId);
            paymentTotal += order.getOrderTotal();
            orderService.payOrder(order);
        }

        // now created a payment object and saved it  with payment total
        Payment payment = new Payment();
        payment.setAmountPaid(paymentTotal);
        paymentService.savePayment(payment);

        //again loop thorugh ids
        //add order to the payment
        //this is where the relations gets established
        for (Integer orderId : orderIds) {
            order = orderService.getOrderById(orderId);
            paymentService.addOrder(payment, order);
        }


        return response;
    }


}
