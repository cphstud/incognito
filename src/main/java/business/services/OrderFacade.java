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


    public Order createOrder(String order_id, String length, String width, String date) throws UserException {
        Order order = new Order(order_id, length, width, date);
        orderMapper.createOrder(order);

        return order;
    }
}
