package business.persistence;

import business.entities.Material;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialMapperTest {
    private final static String USER = "root";
    private final static String PASSWORD = "root123";
    private final static String URL = "jdbc:mysql://localhost:3306/incogcarport?serverTimezone=CET";
    // TODO: lav en test-database og peg på den med urlen

    Database database;
    MaterialMapper materialMapper;
    Material material;


    @BeforeEach
    void setUp() throws ClassNotFoundException {
        database = new Database(USER,PASSWORD,URL);
        materialMapper = new MaterialMapper(database);
        material = new Material(780,"Rem","meter");

    }

    @Test
    void createMaterial() {
        materialMapper.createMaterial(material);
    }
}