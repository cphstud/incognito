package business.services;

import business.entities.SeeAllSellers;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.SeeAllSellersMapper;

import java.sql.SQLException;
import java.util.List;

public class SeeSellersFacade {

    private SeeAllSellersMapper seeAllSellersMapper;

    public SeeSellersFacade(Database database) {
        this.seeAllSellersMapper = new SeeAllSellersMapper(database);
    }

    public List<SeeAllSellers> ShowAllSellers() throws UserException {
        return seeAllSellersMapper.ShowAllSellers();

    }
}
