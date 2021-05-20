package business.services;

import business.entities.Material;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.MaterialMapper;

public class MaterialFacade {
    Database database;
    MaterialMapper materialMapper;

    public MaterialFacade(Database database) {
        this.database = database;
        materialMapper = new MaterialMapper(database);
    }

    public Material getCarportItemById(int id) throws UserException
    {
        return materialMapper.getCarportItemById(id);
    }
}
