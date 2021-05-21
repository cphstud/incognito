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

        //1. Hent Part via id (henter id_nr 1 = stolpe)
        Material material = materialFacade.getCarportItemById(10);

        //2. Ud fra kundens forespørgsel i orders(780 - 120cm = 660)
        // ( 660 / 310 = 2,12 --> 3 stolper. 3 x 2 = 6(qty).
        

        //3.  Udregn pris (carportItem_qty * price_per_unit)

        //4.  Hard code beskrivelse: String des = "Stolpe til tag"

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
        //  return result;
        // }
/*
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
*/
        return null;
    }

}

