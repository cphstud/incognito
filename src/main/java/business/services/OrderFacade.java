package business.services;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

public class OrderFacade {

    private OrderMapper orderMapper;

    public OrderFacade(Database database) {
        this.orderMapper = new OrderMapper(database);
    }


    public Order createOrder(String width, String length, String roof_type) throws UserException {
        Order order = new Order(width, length, roof_type);
        orderMapper.createOrder(order);
        return order;
    }
}
