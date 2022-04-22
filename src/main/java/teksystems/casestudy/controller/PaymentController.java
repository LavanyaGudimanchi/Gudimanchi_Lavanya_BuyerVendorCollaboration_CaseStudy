package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.Payment;
import teksystems.casestudy.service.OrderService;
import teksystems.casestudy.service.PaymentService;

import java.util.List;

@PreAuthorize("hasAuthority('BUYER')")
@Controller
public class PaymentController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("buyer/payment")
    public ModelAndView capturePayment(@RequestParam("orderId")Integer[] orderIds) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/payment");
        Double paymentTotal =0.0;
        Order order;
        for (Integer orderId: orderIds)
        {
            order = orderService.getOrderById(orderId);
            paymentTotal+=order.getOrderTotal();
        }
        response.addObject("paymentTotal", paymentTotal);
        response.addObject("orderIds", orderIds);

        return response;
    }

    @GetMapping("buyer/paymentSubmit")
    public ModelAndView paymentSuccess(@RequestParam("orderId") Integer[] orderIds) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/paymentsuccess");

        Order order;
        Double paymentTotal =0.0;
        for (Integer orderId: orderIds)
        {
            order = orderService.getOrderById(orderId);
            paymentTotal+=order.getOrderTotal();
            orderService.payOrder(order);
        }
        Payment payment = new Payment();
        payment.setAmountPaid(paymentTotal);
        paymentService.savePayment(payment);

        for (Integer orderId: orderIds)
        {
            order = orderService.getOrderById(orderId);
            paymentService.addOrder(payment,order);
        }



        return response;
    }


}
