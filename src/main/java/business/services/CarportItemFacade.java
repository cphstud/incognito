package business.services;

import business.entities.CarportItem;
import business.exceptions.UserException;
import business.persistence.BillOfMaterialsMapper;
import business.persistence.CalcCarportMapper;
import business.persistence.Database;

import java.sql.SQLException;
import java.util.List;


public class CarportItemFacade {

    private BillOfMaterialsMapper billOfMaterialsMapper;
    private CalcCarportMapper calcCarportMapper;

    public CarportItemFacade(Database database) {
        this.billOfMaterialsMapper = new BillOfMaterialsMapper(database);
    }

    public List<CarportItem> BillOfMaterials() throws UserException, SQLException {
        return billOfMaterialsMapper.BillOfMaterials();

    }

    public List<CarportItem> calcPost() throws UserException {
        return calcCarportMapper.calcPost();

    }

}
