package business.persistence;

public class CalcPart {

    public void calcPost() {
        // Method for the actual calculations on how many post there has to be when the length of the carport is X.
        // Maximum distance between 2 posts is 3,1 meters.
        // First posts is 1 meter in from the front of the beam.
        // Last post is 0,2 meter in from the back of the beam.
        // To calculate the amount of posts needed do:
        // ( Length - 120 cm  = ?????? )
        // ( ?????? / 310 cm = ?????? )
        // ( ?????? rounds up to fx. 2,15 -> 3 = 3 posts on each side of carport ).
        // Return (3 x 2 = 6) 6 posts with a length of 300 cm to CalcCarport.java Class.
    }

    public void calcBeam() {
        // Method for the actual calculations on how many beams there has to be when the length of the carport is X.
        // Infinite length of beam?
        // Return 2 beams with a length of 780cm to CalcCarport.java Class when asked for simplicities sake?
    }

    public void calcRafter() {
        // Method for the actual calculations in how many rafters there has to be when the length of the carport is X.
        // Maxium distance between 2 rafters is 0,55 meters.
        // Rafters start from from to back of the width of a carport.
        // To calculate the amount of rafters needed do:
        // ( Width cm / 55 cm = fx. 14,15 -> 15 rafters.
        // Return  15 rafters with the length of 600cm to CalcCarport.java Class.

    }

}
