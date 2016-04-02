package ADT;

import Linked_Queues.BusinessRules;

/**
 *
 * @author C0432660 John Verwolf
 */
public class HourlyEmployee extends FullTimeEmployee {

    private int hoursWorked;
    private double payRate;
    private double regularPay;
    private double overTimePay;

    /**
     * Default constructor
     */
    public HourlyEmployee() {
        super();
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
        super.setName(name);
        setHoursWorked(hoursWorked);
        this.payRate = payRate;
    }

    /**
     * Sets instance variables to their default values.
     */
    private void setDefaultInstanceVaraibleValues() {
        hoursWorked = 0;
        payRate = 0;
        regularPay = 0;
        overTimePay = 0;
    }

    /**
     * get hours worked 
     * @return hours worked
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     *get the pay rate
     * @return pay rate
     */
    public double getPayRate() {
        return payRate;
    }

    /**
     *get regular pay
     * @return regular pay
     */
    public double getRegularPay() {       
        return regularPay;
    }

    /**
     *get over time pay
     * @return overtime pay
     */
    public double getOverTimePay() {
        return overTimePay;
    }

    /**
     * set hours worked
     * @param hoursWorked
     */
    public final void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
        if (hoursWorked <= BusinessRules.HOURS_BEFORE_OVERTIME) {
            this.regularPay = hoursWorked * payRate;
        } else {
            this.overTimePay = ((BusinessRules.HOURS_BEFORE_OVERTIME - hoursWorked) * BusinessRules.OVERTIME_RATE);
            this.regularPay = BusinessRules.HOURS_BEFORE_OVERTIME * payRate;
        }

    }

    /**
     * set pay rate
     * @param payRate
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": hoursWorked=" + hoursWorked + ", payRate=" + payRate + ", regularPay=" + regularPay + ", overTimePay=" + overTimePay;
    }

}
