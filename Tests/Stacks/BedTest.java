/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stacks;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author C0432660 John Verwolf
 */
public class BedTest {

    public BedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getName method, of class Bed.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Bed instance = new Bed("TestName", "");
        String expResult = "TestName";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setName method, of class Bed.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Bed instance = new Bed("", "");
        instance.setName("TestName");
        String expResult = "TestName";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Bed.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Bed instance = new Bed("TestName", "TestLocation");
        String expResult = "Bed: location=TestLocation, name=TestName";
        String result = instance.toString();
        //System.out.println(instance.toString());
        assertEquals(expResult, result);

    }

}
