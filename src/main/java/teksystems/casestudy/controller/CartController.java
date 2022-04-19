package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.OrderLine;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.service.OrderLineService;

@Controller
public class CartController {
    @Autowired
    private OrderLineService orderLineService;

    @GetMapping("buyer/addToCart")
    public ModelAndView addtoCart(@ModelAttribute("orderLine") OrderLine orderLine) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/shoppingcart");
        orderLineService.save(orderLine);
        return response;
    }
}
