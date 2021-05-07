package business.services;

import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.RequestMapper;
import org.omg.CORBA.Request;

public class RequestFacade {

    private RequestMapper requestMapper;

    public RequestFacade(Database database) {
        this.requestMapper = new RequestMapper(database);
    }

    public Request createRequest(String width, int length, String roof_type, int toolroom_width, int toolroom_length, String name, String address, int postcode, int phone) throws UserException {
        // TODO:: insert data into database
        Request request = new Request(width, length, roof_type, toolroom_width, toolroom_length, name, address, postcode, phone);
        requestMapper.createRequest(request);
        return request;
    }
}
