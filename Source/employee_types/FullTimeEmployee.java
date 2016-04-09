package employee_types;

/**
 *
 * @author C0432660 John Verwolf
 */
public class FullTimeEmployee implements Employee {

    private String name;
    private double grossPay;

    /**
     * Default Constructor
     */
    public FullTimeEmployee() {
        name = "";
        grossPay = 0;
    }

    /**
     * Constructor
     *
     * @param name     Name of Employee
     * @param grossPay gross Pay of employee
     */
    public FullTimeEmployee(String name, double grossPay) {
        this();  //included for the event where extra instance variables are added
        this.name = name;
        this.grossPay = grossPay;
    }

    /**
     * return name
     *
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * set name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set gross pay
     *
     * @param grossPay
     */
    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    /**
     * get gross pay
     *
     * @return gross pay
     */
    @Override
    public double getGrossPay() {
        return this.grossPay;
    }

    /**
     * returns string representation of the object
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": name=" + name + ", grossPay=" + grossPay;
    }

}
