package teksystems.casestudy.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.OrderDAO;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.OrderLine;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;

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
