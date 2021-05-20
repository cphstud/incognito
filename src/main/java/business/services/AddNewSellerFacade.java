package business.services;

import business.entities.AddSeller;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.AddNewSellerMapper;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class AddNewSellerFacade {

    private AddNewSellerMapper addNewSellerMapper;

    public AddNewSellerFacade(Database database) {
        this.addNewSellerMapper = new AddNewSellerMapper(database);
    }


    public AddSeller AddNewSeller(String name, String address, String phone, String email, String password) throws UserException {
        AddSeller seller = new AddSeller(name, address, phone, email, password);
        seller = addNewSellerMapper.AddNewSeller(seller);
        return seller;
    }
}
