package business.services;

import business.entities.Application;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.ApplicationMapper;

public class ApplicationFacade {

    private ApplicationMapper applicationMapper;

    public ApplicationFacade(Database database) {
        this.applicationMapper = new ApplicationMapper(database);
    }


    public Application createApplication(String width, String length, String roof_type, String toolroom_width, String toolroom_length, String price) throws UserException {
        Application application = new Application(width, length, roof_type, toolroom_length, toolroom_width, price);
        applicationMapper.createApplication(application);
        return application;
    }
}
