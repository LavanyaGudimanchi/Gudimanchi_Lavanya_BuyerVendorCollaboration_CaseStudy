package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.OrderLine;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.security.AuthenticatedUserService;
import teksystems.casestudy.service.CartService;
import teksystems.casestudy.service.OrderLineService;
import teksystems.casestudy.service.OrderService;

import java.util.List;

@PreAuthorize("hasAuthority('BUYER')")
@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private OrderService orderService;

    @PostMapping("buyer/addToCart")
    public ModelAndView addtoCart(@RequestParam("productId")Integer[] productIds) throws Exception {
        User user = authenticatedUserService.getCurrentUser();
        cartService.AddtoCart(productIds, user);
        return displayCart();
    }

    @GetMapping("buyer/shoppingcart")
    public ModelAndView displayShoppingCart() throws Exception {
        return displayCart();
    }

    private ModelAndView displayCart()
    {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/shoppingcart");
        User user = authenticatedUserService.getCurrentUser();
        Order order =  orderService.getPendingOrder(user);
        if (order != null)
        {
            List<OrderLine> orderLines = order.getOrderlines();
            order.setOrderTotal(orderService.getGrandTotal(user));
            orderService.saveOrder(order);
            response.addObject("order", order);
            response.addObject("orderLines", orderLines);

        }

        return response;
    }

}
