package web.commands;

import business.entities.ConfirmPayment;
import business.entities.User;
import business.services.ConfirmPaymentFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ConfirmPaymentCommand extends CommandProtectedPage
{
    private UserFacade userFacade = new UserFacade(database);
    private ConfirmPaymentFacade confirmPaymentFacade = new ConfirmPaymentFacade(database);


    public ConfirmPaymentCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        User contactInformation = userFacade.getUserById(user.getId());
        request.setAttribute("contactInformation", contactInformation);
        List<ConfirmPayment> confirmPayment = confirmPaymentFacade.ViewAllConfirmedPayments();
        request.setAttribute("confirmPayment", confirmPayment);


        return pageToShow;

    }


}

