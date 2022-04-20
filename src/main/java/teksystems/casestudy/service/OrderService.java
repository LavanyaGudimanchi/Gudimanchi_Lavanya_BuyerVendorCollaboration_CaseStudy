package teksystems.casestudy.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.OrderDAO;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.OrderLine;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderdao;

    public Order getPendingOrder(User user)
    {
       return orderdao.getOrderByBuyer(user);
    }

    public Order saveOrder(Order order)
    {
       return orderdao.save(order);
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
