package business.services;

import business.entities.OrderConfirmation;
import business.entities.Requests;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderConfirmationMapper;

import java.sql.SQLException;
import java.util.List;


public class OrderConfirmationFacade {

    private OrderConfirmationMapper orderConfirmationMapper;

    public OrderConfirmationFacade(Database database) {
        this.orderConfirmationMapper = new OrderConfirmationMapper(database);
    }

    public List<OrderConfirmation> showOrderConfirmation() throws UserException {
        return orderConfirmationMapper.showOrderConfirmation();
    }
}
