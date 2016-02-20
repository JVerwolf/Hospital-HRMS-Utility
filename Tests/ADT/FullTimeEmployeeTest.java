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
public class FullTimeEmployeeTest {
    
    public FullTimeEmployeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getName method, of class FullTimeEmployee.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        FullTimeEmployee instance = new FullTimeEmployee();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getGrossPay method, of class FullTimeEmployee.
     */
    @Test
    public void testGetGrossPay() {
        System.out.println("getGrossPay");
        FullTimeEmployee instance = new FullTimeEmployee();
        double expResult = 0.0;
        double result = instance.getGrossPay();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of toString method, of class FullTimeEmployee.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FullTimeEmployee instance = new FullTimeEmployee();        
        String expResult = "FullTimeEmployee: name=, grossPay=0.0";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
