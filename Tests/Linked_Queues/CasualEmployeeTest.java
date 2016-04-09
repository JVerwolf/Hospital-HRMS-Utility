/*
 *
 */
package Linked_Queues;

import employee_types.CasualEmployee;
import junit.framework.TestCase;

/**
 *
 * @author John Verwolf
 */
public class CasualEmployeeTest extends TestCase {

    public CasualEmployeeTest(String testName) {
        super(testName);
    }

    /**
     * Test of getAvailability method, of class CasualEmployee.
     */
    public void testGetAvailability() {
        System.out.println("getAvailability");
        CasualEmployee instance = new CasualEmployee("Test", true);
        boolean expResult = true;
        boolean result = instance.getAvailability();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvailability method, of class CasualEmployee.
     */
    public void testSetAvailability() {
        System.out.println("setAvailability");
        boolean availability = true;
        CasualEmployee instance = new CasualEmployee();
        instance.setAvailability(availability);
        boolean expResult = true;
        boolean result = instance.getAvailability();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class CasualEmployee.
     */
    public void testToString() {
        System.out.println("toString");
        CasualEmployee instance = new CasualEmployee("Test", true);
        //System.out.println(instance.toString());
        String expResult = "CasualEmployee{availability=true}";
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }

}
