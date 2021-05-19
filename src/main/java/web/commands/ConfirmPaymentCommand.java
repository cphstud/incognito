package web.commands;

import business.entities.ConfirmPayment;
import business.entities.User;
import business.services.ConfirmPaymentFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ConfirmPaymentCommand extends CommandProtectedPage
{
    private ConfirmPaymentFacade confirmPaymentFacade = new ConfirmPaymentFacade(database);


    public ConfirmPaymentCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");

        ConfirmPayment contactInformation = confirmPaymentFacade.ShowContactInformation(name, address, phone, email);
        request.setAttribute("contactInformation", contactInformation);

        List<ConfirmPayment> confirmPayment = confirmPaymentFacade.ViewAllConfirmedPayments();
        request.setAttribute("confirmPayment", confirmPayment);


        return pageToShow;

    }


}

