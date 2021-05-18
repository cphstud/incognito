package business.services;

import business.entities.Requests;
import business.exceptions.UserException;
import business.persistence.CustomerViewRequestsMapper;
import business.persistence.Database;
import java.sql.SQLException;
import java.util.List;


public class CustomerRequestsFacade {

    private CustomerViewRequestsMapper customerViewRequestsMapper;

    public CustomerRequestsFacade(Database database) {
        this.customerViewRequestsMapper = new CustomerViewRequestsMapper(database);
    }

    public List<Requests> ViewAllCustomoerRequests() throws UserException, SQLException {
        return customerViewRequestsMapper.ViewAllCustomoerRequests();
    }
}
