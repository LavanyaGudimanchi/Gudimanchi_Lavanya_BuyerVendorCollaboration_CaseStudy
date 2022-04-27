package org.lgudimanchi.bvcollaboration.controller;

import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.lgudimanchi.bvcollaboration.database.entity.Order;
import org.lgudimanchi.bvcollaboration.security.AuthenticatedUserService;
import org.lgudimanchi.bvcollaboration.service.OrderService;

import java.util.List;

@PreAuthorize("hasAuthority('BUYER')")
@Controller
public class OrderController {

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private OrderService orderService;

    @GetMapping("buyer/myorders")
    public ModelAndView displayOrders() throws Exception {
        return displayNonPendingOrders();
    }

    @GetMapping("buyer/placeOrder")
    public ModelAndView placeOrder() throws Exception {
        User user = authenticatedUserService.getCurrentUser();
        orderService.placeOrder(user);

       return displayNonPendingOrders();
    }

    private ModelAndView displayNonPendingOrders()
    {
        ModelAndView response = new ModelAndView();
        response.setViewName("buyer/myorders");
        User user = authenticatedUserService.getCurrentUser();
        List<Order> orders =  orderService.getPlacedOrders(user);
        response.addObject("orders", orders);
        return response;
    }
}
