package business.services;

import business.entities.ConfirmPayment;
import business.entities.Requests;
import business.exceptions.UserException;
import business.persistence.ConfirmPaymentMapper;
import business.persistence.CustomerViewRequestsMapper;
import business.persistence.Database;
import java.sql.SQLException;
import java.util.List;


public class ConfirmPaymentFacade {

    private ConfirmPaymentMapper confirmPaymentMapper;

    public ConfirmPaymentFacade(Database database) {
        this.confirmPaymentMapper = new ConfirmPaymentMapper(database);
    }

    public List<ConfirmPayment> ViewAllConfirmedPayments() throws UserException, SQLException {
        return confirmPaymentMapper.ViewAllConfirmedPayments();
    }



}
