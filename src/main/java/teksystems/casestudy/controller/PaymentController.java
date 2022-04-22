package teksystems.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

    @GetMapping("buyer/payment")
    public ModelAndView capturePayment() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/payment");
        return response;
    }

    @GetMapping("buyer/paymentsuccess")
    public ModelAndView paymentSuccess() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/paymentsuccess");
        return response;
    }
}
