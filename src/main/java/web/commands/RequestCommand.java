/*package web.commands;

import business.entities.User;
import business.persistence.Database;
import business.services.RequestFacade;
import business.services.UserFacade;
import business.exceptions.UserException;
import org.omg.CORBA.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestCommand extends CommandUnprotectedPage
{
    private RequestFacade requestFacade;
    Request request1;



    public RequestCommand(String pageToShow)
    {
        super(pageToShow);
        this.requestFacade = new RequestFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String width = request.getParameter("width");
        int length =Integer.parseInt("length");
        String roof_type = request.getParameter("roof_type");
        int toolroom_width = Integer.parseInt("toolroom_width");
        int toolroom_length = Integer.parseInt("toolroom_length");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int postcode = Integer.parseInt("postcode");
        int phone = Integer.parseInt("phone");
            Request request2 = requestFacade.createRequest(width, length, roof_type, toolroom_width,
                    toolroom_length, name, address, postcode, phone);
            HttpSession session = request.getSession();

            session.setAttribute("width", width);
            session.setAttribute("length", length);
            session.setAttribute("roof_type", roof_type);
            session.setAttribute("roof_type", toolroom_width);
            session.setAttribute("roof_type", toolroom_length);
            session.setAttribute("name", name);
            session.setAttribute("address", address);
            session.setAttribute("postcode", postcode);
            session.setAttribute("phone", phone);
            session.setAttribute("error", "the two passwords did not match");

            requestFacade.createRequest(address, length, roof_type, toolroom_width,
                                toolroom_length, name, width, postcode, phone);

            return "registerpage";
        }


}

 */
