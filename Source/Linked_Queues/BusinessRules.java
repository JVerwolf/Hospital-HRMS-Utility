package Linked_Queues;

/**
 * This class is to hold all business rules for the Company object. This
 * simplifies changes down the road.
 *
 * @author John Verwolf
 */
public class BusinessRules {
    /**
     * this variable holds the over time rate to be paid to hourly employees.
     */
    public static final double OVERTIME_RATE = 2.00; 
    
    /**
     * the number of hours before overtime pay is issued.
     */
    public static final int HOURS_BEFORE_OVERTIME = 40; 
    
    
    /**
     * this class is not meant to be instantiated
     */
    public BusinessRules() {
     throw new UnsupportedOperationException();
    }

   
}
