package business.services;


import business.entities.ConfirmedOrders;
import business.exceptions.UserException;
import business.persistence.ConfirmedOrdersMapper;
import business.persistence.Database;

import java.sql.SQLException;
import java.util.List;


public class ConfirmedOrdersFacade {

    private ConfirmedOrdersMapper confirmedOrdersMapper;

    public ConfirmedOrdersFacade(Database database) {
        this.confirmedOrdersMapper = new ConfirmedOrdersMapper(database);
    }

    public List<ConfirmedOrders> ListOfAllConfirmedOrders() throws UserException, SQLException {
        return confirmedOrdersMapper.ListOfAllConfirmedOrders();

    }
}
