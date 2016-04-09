package employee_types;

import employee_types.HourlyEmployee;

/**
 *
 * @author John Verwolf
 */
public class CasualEmployee extends HourlyEmployee implements java.io.Serializable {

    /**
     * Availability
     */
    private boolean availability;

    /**
     * Default constructor. Assigns all values to blank/0/False
     */
    public CasualEmployee() {
        super();
        this.availability = false;
    }

    /**
     * Constructor
     *
     * @param name         Name of employee
     * @param availability Availability of employee
     */
    public CasualEmployee(String name, boolean availability) {
        super();
        super.setName(name);
        this.availability = availability;
    }

    /**
     * get the Availability of the Casual Employee
     *
     * @return availability
     */
    public boolean getAvailability() {
        return availability;
    }

    /**
     * set the Availability of the Casual Employee
     *
     * @param availability
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     * String representation of the object
     *
     * @return String representation of the object
     *
     */
    @Override
    public String toString() {
        return "CasualEmployee{" + "availability=" + availability + '}';
    }

}
