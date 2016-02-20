package ADT;

/**
 *
 * @author C0432660 John Verwolf
 */
public class HourlyEmployee extends FullTimeEmployee {

    protected int hoursWorked;
    protected double payRate;
    protected double regularPay;
    protected double overTimePay;

    /**
     * Default constructor
     */
    public HourlyEmployee() {
        setDefaultInstanceVaraibleValues();
    }

    /**
     * Constructor
     *
     * @param name     Name of Employee.
     * @param grossPay Gross yearly pay.
     */
    public HourlyEmployee(String name, double grossPay) {
        super(name, grossPay);
    }

    /**
     * Constructor
     *
     * @param name        Name of Employee
     * @param hoursWorked Hours worked in pay period
     * @param payRate     Pay rate of Employee
     */
    public HourlyEmployee(String name, int hoursWorked, double payRate) {
        super();
        setDefaultInstanceVaraibleValues();
        super.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    /**
     * Sets instance variables to their default values.
     */
    void setDefaultInstanceVaraibleValues() {
        hoursWorked = 0;
        payRate = 0;
        regularPay = 0;
        overTimePay = 0;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getRegularPay() {
        return regularPay;
    }

    public double getOverTimePay() {
        return overTimePay;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": hoursWorked=" + hoursWorked + ", payRate=" + payRate + ", regularPay=" + regularPay + ", overTimePay=" + overTimePay;
    }

}
