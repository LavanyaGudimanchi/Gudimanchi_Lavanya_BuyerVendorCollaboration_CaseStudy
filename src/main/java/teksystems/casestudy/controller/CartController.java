package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.OrderLine;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.security.AuthenticatedUserService;
import teksystems.casestudy.service.CartService;
import teksystems.casestudy.service.OrderLineService;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @PostMapping("buyer/addToCart")
    public ModelAndView addtoCart(@RequestParam("productId")Integer[] productIds) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/shoppingcart");
        cartService.AddtoCart(productIds, authenticatedUserService.getCurrentUser());
        return response;
    }

}
