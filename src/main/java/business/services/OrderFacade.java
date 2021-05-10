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


    public Order createOrder(String customer_id, String length, String width, String date, String subtotal, String status, String roof_type) throws UserException {
        Order order = new Order(customer_id, length, width, date, subtotal, status, roof_type);
        orderMapper.createOrder(order);

        return order;
    }
}
