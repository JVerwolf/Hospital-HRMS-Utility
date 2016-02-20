package ADT;

/**
 *
 * @author C0432660 John Verwolf
 */
public interface Employee {

    String getName(); //Stores name of Employee

    double getGrossPay(); //Stores gross pay of employee

    @Override
    String toString();  //toString must be updated and overridden 
}
