package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command
{
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND ="404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database)
    {
        commands = new HashMap<>();
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("employeepage", new CommandProtectedPage("employeepage", "employee"));
        commands.put("thankyoupage", new CreateNewOrderCommand("thankyoupage", "customer"));
        commands.put("seeonepieceslistpage", new ShowAllCarportItemsCommand("seeonepieceslistpage", "employee"));
        commands.put("employeerequestpage", new CommandProtectedPage("employeerequestpage", "employee"));
        commands.put("seallcustomersrequests", new ShowAllOrdersCommand("seallcustomersrequests", "employee"));
        commands.put("seallconfirmedorders", new CommandProtectedPage("seallconfirmedorders", "employee"));
        commands.put("customeroverview", new CommandProtectedPage("customeroverview", "employee"));
        commands.put("seallproducts", new CommandProtectedPage("seallproducts", "employee"));
        commands.put("createoffer", new CommandProtectedPage("createoffer", "employee"));
        commands.put("requestpage", new CommandProtectedPage("requestpage", "customer"));
        commands.put("adminpage", new CommandProtectedPage("adminpage", "admin"));
        commands.put("seallproductpage", new CommandProtectedPage("seallproductpage", "admin"));
        commands.put("addnewproductpage", new CommandProtectedPage("addnewproductpage", "admin"));
        commands.put("seallsellerspage", new CommandProtectedPage("seallsellerspage", "admin"));
        commands.put("addnewsellerpage", new CommandProtectedPage("addnewsellerpage", "admin"));
        commands.put("customerviewrequestspage", new ViewCustomerRequestsCommand("customerviewrequestspage", "customer"));
        commands.put("confirmpaymentpage", new ConfirmPaymentCommand("confirmpaymentpage", "customer"));
        commands.put("showsvg",new showSVGCommand  ("svgpage"));
    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db)
    {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null)
        {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException, SQLException;

}
