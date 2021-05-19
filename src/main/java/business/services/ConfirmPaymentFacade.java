package business.services;

import business.entities.ConfirmPayment;
import business.entities.Order;
import business.entities.Requests;
import business.exceptions.UserException;
import business.persistence.ConfirmPaymentMapper;
import business.persistence.CustomerViewRequestsMapper;
import business.persistence.Database;
import com.sun.corba.se.pept.transport.ContactInfo;

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

    public ConfirmPayment ShowContactInformation(String name, String address, int phone, String email) throws Exception {
        ConfirmPayment contactinfo = new ConfirmPayment(name, address, phone, email);
        contactinfo = confirmPaymentMapper.ShowContactInformation(contactinfo);
        return contactinfo;
    }

}
