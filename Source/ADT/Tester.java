package ADT;

import employee_types.HourlyEmployee;
import employee_types.FullTimeEmployee;

/**
 *
 * @author C0432660 John Verwolf
 */
public class Tester {

    /**
     * This method creates a few FullTimeEmployee employee objects and returns
     * them in an array
     *
     * @return array of FullTimeEmployee objects
     */
    private FullTimeEmployee[] listOfEmployees() {
        FullTimeEmployee Employee1 = new FullTimeEmployee("Bob1", 50000);
        FullTimeEmployee Employee2 = new FullTimeEmployee("Bob2", 60000);

        HourlyEmployee Employee3 = new HourlyEmployee("Bob3", 60000);
        HourlyEmployee Employee4 = new HourlyEmployee("Bob4", 70000);

        FullTimeEmployee[] ArrayEmployee = {Employee1, Employee2, Employee3, Employee4};
        return (ArrayEmployee);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create instance of Tester Class. This allows for non - static methods.
        Tester testInstance = new Tester();

        Company c1 = new Company("Test Company", testInstance.listOfEmployees());

        /*
         * This temp variable holds the reference to the best paid employee so
         * that the searching algorithm does not need to be invoked multiple
         * times
         */
        FullTimeEmployee bestPaidEmployee = c1.findBestPaid();

        System.out.println("Best Paid Employee: Name = " + bestPaidEmployee.getName() + ", Gross Pay = " + bestPaidEmployee.getGrossPay());

    }
}
