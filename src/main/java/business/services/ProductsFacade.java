package business.services;

import business.entities.SeeProducts;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.ShowAllProductsMapper;

import java.sql.SQLException;
import java.util.List;

public class ProductsFacade {

    private ShowAllProductsMapper showAllProductsMapper;

    public ProductsFacade(Database database) {
        this.showAllProductsMapper = new ShowAllProductsMapper(database);
    }

    public List<SeeProducts> ShowAllProductsMapper() throws UserException, SQLException {
        return showAllProductsMapper.ShowAllProducts();

    }
}
