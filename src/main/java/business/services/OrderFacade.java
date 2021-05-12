package business.services;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class OrderFacade {

    private OrderMapper orderMapper;

    public OrderFacade(Database database) {
        this.orderMapper = new OrderMapper(database);
    }


    public Order createOrder(int customer_id, int length, int width, long date, int subtotal, String roof_type) throws UserException {
        Order order = new Order(customer_id, length, width, date, subtotal, roof_type);
        order = orderMapper.createOrder(order);
        return order;
    }

    public List<Order> showAllOrders() throws UserException {
        return orderMapper.showAllOrders();

    }
}
