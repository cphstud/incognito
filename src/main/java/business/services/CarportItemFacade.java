package business.services;

import business.entities.CarportItem;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.BillOfMaterialsMapper;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.sql.SQLException;
import java.util.List;


public class CarportItemFacade {

    private BillOfMaterialsMapper billOfMaterialsMapper;

    public CarportItemFacade(Database database) {
        this.billOfMaterialsMapper = new BillOfMaterialsMapper(database);
    }

    public List<CarportItem> BillOfMaterials() throws UserException, SQLException {
        return billOfMaterialsMapper.BillOfMaterials();

    }
}
