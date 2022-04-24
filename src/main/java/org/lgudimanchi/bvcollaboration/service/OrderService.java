package org.lgudimanchi.bvcollaboration.service;

import org.lgudimanchi.bvcollaboration.database.dao.OrderDAO;
import org.lgudimanchi.bvcollaboration.database.entity.Order;
import org.lgudimanchi.bvcollaboration.database.entity.OrderLine;
import org.lgudimanchi.bvcollaboration.database.entity.Product;
import org.lgudimanchi.bvcollaboration.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderdao;

    public Order getPendingOrder(User user)
    {
       return orderdao.getOrderByBuyerAndStatus(user,"PENDING");
    }

    public List<Order> getPlacedOrders(User user)
    {
        return orderdao.getPlacedOrders(user.getId(),"PENDING");
    }

    public void placeOrder(User user) {
        Order order = getPendingOrder(user);
        order.setStatus("ORDERED");
        orderdao.save(order);

    }

    public void payOrder(Order order) {
        order.setStatus("PAID");
        orderdao.save(order);
    }

    public Double getGrandTotal(User user)
    {
        return orderdao.getGrandTotal(user.getId());
    }

    public Order saveOrder(Order order)
    {
       return orderdao.save(order);
    }

    public Order getOrderById(Integer oderId)
    {
        return orderdao.getById(oderId);
    }

    public OrderLine getOrderLine(Order order, Product product)
    {
        for (OrderLine orderline:order.getOrderlines())
        {
            if (orderline.getProduct() ==product)
            {
                return  orderline;
            }
        }
        return null;
    }
}
