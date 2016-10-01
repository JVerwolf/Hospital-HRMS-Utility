package hospital_components;

/**
 *
 * @author C0432660 John Verwolf
 */
public interface Employee {
    
    /**
     * Stores name of Employee
     *
     * @return name of employee
     */
    String getName();

    /**
     * returns the gross pay of the employee
     *
     * @return
     */
    double getGrossPay();

    /**
     * Return a string representation of the object
     *
     * @return a string representation of the object
     */
    @Override
    String toString();
}