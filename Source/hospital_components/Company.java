package hospital_components;

/**
 *
 * @author C0432660 John Verwolf
 */
public class Company {

    private String name; //holds name of company
    private FullTimeEmployee[] fullTimeEmployee; //holds array of employees

    /**
     * Initialize this company object by assigning it a "no name" name and an
     * array of full time employees that is null
     */
    public Company() {
        name = "";
        fullTimeEmployee = new FullTimeEmployee[0];
    }
    /**
     * Initializes this Company object's name and array of employees from a
     * specified name and array of employees
     * @param name name of company
     * @param fullTimeEmployee full time  employees
     */
    public Company(String name, FullTimeEmployee[] fullTimeEmployee) {
        this.name = name;
        this.fullTimeEmployee = fullTimeEmployee;
    }

    /**
     * This is method finds the highest paid employee in the company instance
     *
     * @return returns the FullTimeEmployee object with the highest grossPay
     *         value in the instance array fullTimeEmployee
     */
    public FullTimeEmployee findBestPaid() {
        try {
            return findBestPaid(fullTimeEmployee);
        } catch (NullPointerException e) {
            return (null);
        }
    }

    /**
     * This method determines the highest paid employee when passed an array of
     * FullTimeEmployee objects. It returns the FullTimeEmployee object with the
     * highest grossPay value.
     *
     * @param ArrayEmployee An array containing FullTimeEmployee objects
     * @return FullTimeEmployee object with the highest grossPay value.
     */
    public FullTimeEmployee findBestPaid(FullTimeEmployee[] ArrayEmployee) {
        try {
            FullTimeEmployee Highestpaid = ArrayEmployee[0];            //variable used to store highest paid employee
            for (FullTimeEmployee e : ArrayEmployee) {                  //iterate through array
                if (e.getGrossPay() > Highestpaid.getGrossPay()) {      //search for higher grossPay value
                    Highestpaid = e;                                    //update highest paid employeee
                }
            }
            return (Highestpaid);

        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            return (null);
        }
    }
}
