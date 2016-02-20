package ADT;

/**
 *
 * @author C0432660 John Verwolf
 */
public class FullTimeEmployee implements Employee {

    protected String name;
    protected double grossPay;

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

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getGrossPay() {
        return this.grossPay;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": name=" + name + ", grossPay=" + grossPay;
    }

}
