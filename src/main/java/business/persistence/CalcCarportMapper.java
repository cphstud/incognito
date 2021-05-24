package business.persistence;

import business.entities.CarportItem;
import business.entities.Material;
import business.entities.Order;
import business.exceptions.UserException;
import business.services.MaterialFacade;
import business.services.OrderFacade;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalcCarportMapper {
    // Method for calling the posts, beams and rafters
    private static Database database;

    CarportItem carportItems;
    MaterialFacade materialFacade;
    OrderFacade orderFacade;

    public CalcCarportMapper(MaterialFacade materialFacade) {
        this.materialFacade = materialFacade;

    }

    //Overskrift "Udregnng af stolper"
    public List<CarportItem> calcPost() throws UserException {
        List<CarportItem> carportItems = new ArrayList<>();

        //1. Hent Part via id (henter id_nr 10 = stolpe)
        Material material = materialFacade.getCarportItemById(10);


        //2. Ud fra kundens forespørgsel i orders(780 - 120cm = 660)
        // ( 660 / 310 = 2,12 --> 3 stolper. 3 x 2 = 6(qty).
        int showOrder = orderFacade.showAllOrders().get(80).getLength(); // length 360 from id 1
        int cm = 360; // 360 cm
        int result = showOrder - cm;  // 780 - 360
        System.out.println("result is: " + result); // 420

        // ( 660 / 310 = 2,12 --> 3 stolper. 3 x 2 = 6(qty).
        int show_order = orderFacade.showAllOrders().get(1).getLength();
        int centi_meter = 120;
        int divide_show_order_centimeter = show_order / centi_meter; // 420 / 360
        int quantity = show_order / centi_meter * 3;

        System.out.println("Dividing the result of 420 with the length equals to: " + divide_show_order_centimeter); // 420 / 360 = ...
        System.out.println("result of length divided by 310 is: " + quantity); // // 420 / 360 * 3 - gange med 3 fordi vi vil ha 3 stolper

        //3.  Udregn pris (qty * price_per_unit)
        // quantity is 3.5 = round up to the nearest whole number which is 4
        int price_per_unit = orderFacade.showAllOrders().get(1).getSubtotal();
        int quantity_of_three_posts = 4;
        int calculate_price = price_per_unit * quantity_of_three_posts;
        System.out.println("The calculated price of quantity times by price per unit is: " + calculate_price);


        //4.  Hard code beskrivelse: String des = "Stolpe til tag"
        String description = "Stolper nedgraves 90 cm. i jord";


        //5. Byg CarportItem (length, qty,  price, des)

        //6. lave en CarportItem Array -> add(new CarportItem)


        //7. Gemmer enkelte plads i array i DB

        // Method for the actual calculations on how many post there has to be when the length of the carport is X.
        // Maximum distance between 2 posts is 3,1 meters.
        // First posts is 1 meter in from the front of the beam.
        // Last post is 0,2 meter in from the back of the beam.
        // To calculate the amount of posts needed do:
        // ( Length(780) - 120 cm  = ??????(660) )
        // ( ??????(660) / 310 cm = ??????(2,12) )
        // ( Fx. 2,12 rounds up to 3 = 3 posts on each side of carport ).
        // Return (3 x 2 = 6) 6 posts with a length of 300 cm to CalcCarport.java Class.
        return carportItems;
    }

    public void calcBeam(int length, int width) {
        // Method for the actual calculations on how many beams there has to be when the length of the carport is X.
        // Infinite length of beam?
        // Return 2 beams with a length of 780cm to CalcCarport.java Class when asked for simplicities sake?
    }

    public void calcRafter(int length, int width) {
        // Method for the actual calculations in how many rafters there has to be when the length of the carport is X.
        // Maximum distance between 2 rafters is 0,55 meters.
        // Rafters start from from to back of the width of a carport.
        // To calculate the amount of rafters needed do:
        // ( Width cm / 55 cm = fx. 14,15 -> 15 rafters.
        // Return  15 rafters with the length of 600cm to CalcCarport.java Class.

    }


}

