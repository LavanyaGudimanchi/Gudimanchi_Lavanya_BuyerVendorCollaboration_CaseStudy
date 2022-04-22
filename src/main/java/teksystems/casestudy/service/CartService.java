package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.OrderLine;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;

@Service
public class CartService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderLineService orderLineService;

    public void AddtoCart(Integer[] productIds, User user)
    {

        Order order = orderService.getPendingOrder(user);
        if (order == null)
        {
            order = new Order();
            order.setBuyer(user);
            order.setStatus("PENDING");

        }
        orderService.saveOrder(order);
        for (Integer productId: productIds)
        {
            Product product = productService.getProductById(productId);
            OrderLine orderLine= orderService.getOrderLine(order,product);
            if (orderLine == null)
            {
                orderLine = new OrderLine();
                orderLine.setProduct(product);
                orderLine.setOrder(order);
                orderLine.setQuantity(1);

            }
            else
            {
                orderLine.setQuantity(orderLine.getQuantity()+1);

            }
            orderLineService.save(orderLine);
        }

    }

}
