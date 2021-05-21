package business.services;

import business.entities.CarportItem;
import business.exceptions.UserException;
import business.persistence.CarportItemMapper;
import business.persistence.CalcCarportMapper;
import business.persistence.Database;

import java.sql.SQLException;
import java.util.List;


public class CarportItemFacade {

    private CarportItemMapper carportItemMapper;
    private CalcCarportMapper calcCarportMapper;

    public CarportItemFacade(Database database) {
        this.carportItemMapper = new CarportItemMapper(database);
    }

    public List<CarportItem> CarportItemFacade() throws UserException, SQLException {
        return carportItemMapper.CarportItemMap();

    }

    public List<CarportItem> calcPost() throws UserException {
        return calcCarportMapper.calcPost();

    }

}
