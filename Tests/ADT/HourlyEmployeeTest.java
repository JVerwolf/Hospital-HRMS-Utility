/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author C0432660
 */
public class HourlyEmployeeTest {

    public HourlyEmployeeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getHoursWorked method, of class HourlyEmployee.
     */
    @Test
    public void testGetHoursWorked() {
        System.out.println("getHoursWorked");
        HourlyEmployee instance = new HourlyEmployee();
        int expResult = 0;
        int result = instance.getHoursWorked();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPayRate method, of class HourlyEmployee.
     */
    @Test
    public void testGetPayRate() {
        System.out.println("getPayRate");
        HourlyEmployee instance = new HourlyEmployee();
        double expResult = 0.0;
        double result = instance.getPayRate();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getRegularPay method, of class HourlyEmployee.
     */
    @Test
    public void testGetRegularPay() {
        System.out.println("getRegularPay");
        HourlyEmployee instance = new HourlyEmployee();
        double expResult = 0.0;
        double result = instance.getRegularPay();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getOverTimePay method, of class HourlyEmployee.
     */
    @Test
    public void testGetOverTimePay() {
        System.out.println("getOverTimePay");
        HourlyEmployee instance = new HourlyEmployee();
        double expResult = 0.0;
        double result = instance.getOverTimePay();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of toString method, of class HourlyEmployee.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        HourlyEmployee instance = new HourlyEmployee();
        String expResult = "HourlyEmployee: hoursWorked=0, payRate=0.0, regularPay=0.0, overTimePay=0.0";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

}
