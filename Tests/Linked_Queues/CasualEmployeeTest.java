/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linked_Queues;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author John Verwolf
 */
public class CasualEmployeeTest extends TestCase {
    
    public CasualEmployeeTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(CasualEmployeeTest.class);
        return suite;
    }

    /**
     * Test of getAvailability method, of class CasualEmployee.
     */
    public void testGetAvailability() {
        System.out.println("getAvailability");
        CasualEmployee instance = new CasualEmployee();
        boolean expResult = false;
        boolean result = instance.getAvailability();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailability method, of class CasualEmployee.
     */
    public void testSetAvailability() {
        System.out.println("setAvailability");
        boolean availability = false;
        CasualEmployee instance = new CasualEmployee();
        instance.setAvailability(availability);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CasualEmployee.
     */
    public void testToString() {
        System.out.println("toString");
        CasualEmployee instance = new CasualEmployee();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
