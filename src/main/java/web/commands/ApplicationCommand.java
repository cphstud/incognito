package web.commands;

import business.services.ApplicationFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplicationCommand extends CommandUnprotectedPage
{
    private ApplicationFacade applicationFacade;



    public ApplicationCommand(String pageToShow)
    {
        super(pageToShow);
        this.applicationFacade = new ApplicationFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String width = request.getParameter("width");
        String length = request.getParameter("length");
        String roof_type = request.getParameter("roof_type");
        String toolroom_width = request.getParameter("toolroom_width");
        String toolroom_length = request.getParameter("toolroom_length");
        String price = request.getParameter("price");

        applicationFacade.createApplication(width, length, roof_type, toolroom_length, toolroom_width, price);



            return pageToShow;
        }


}
