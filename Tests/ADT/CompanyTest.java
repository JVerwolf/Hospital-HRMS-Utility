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
public class CompanyTest {

    public CompanyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of findBestPaid method, of class Company. Also tested in Tester.java
     * in package ADT
     */
    @Test
    public void testFindBestPaid() {
        System.out.println("findBestPaid");
        Company instance = new Company();
        FullTimeEmployee expResult = null;
        FullTimeEmployee result = instance.findBestPaid();
        System.out.println(result);
        assertEquals(expResult, result);

    }

    /**
     * Test of findBestPaid method, of class Company.
     */
    @Test
    public void testFindBestPaid_FullTimeEmployeeArr() {
        System.out.println("findBestPaid");
        FullTimeEmployee[] ArrayEmployee = null;
        Company instance = new Company();
        FullTimeEmployee expResult = null;
        FullTimeEmployee result = instance.findBestPaid(ArrayEmployee);
        assertEquals(expResult, result);

    }

}
