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
public class CareFacilityTest {

    public CareFacilityTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addPatient method, of class CareFacility.
     */
    @Test
    public void testAddPatient() {

        Patient p4 = new Patient("", 4);
        Patient p3 = new Patient("", 3);
        Patient p2 = new Patient("", 2);
        Patient p1 = new Patient("", 1);
        Patient p0 = new Patient("", 0);

        ArrayStack<Patient> pStack = new ArrayStack<>();

        CareFacility CF = new CareFacility("TestLab", pStack, null, null);

        CF.addPatient(p1);//first in, last out
        CF.addPatient(p2);
        CF.addPatient(p3);
        CF.addPatient(p0);
        CF.addPatient(p4);//last in, first out

        /**
         * this loop will compare priory values of patients in the stack. the
         * priority value should be the same as the counter i.
         */
        int i = 0;
        try {
            while (!CF.forTestGetPatientStack().isEmpty()) {
                if (i != CF.forTestGetPatientStack().pop().getPriority()) {
                    fail(); //fail if the list is not the right length
                }

                i++;  //increment priority counter
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }


    }

    /**
     * Test of sortPatientStack method, of class CareFacility.
     */
    @Test
    public void testSortPatientStack() {
        System.out.println("sortPatientStack");
        CareFacility instance = new CareFacility();
        instance.sortPatientStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assignBed method, of class CareFacility.
     */
    @Test
    public void testAssignBed() {
        System.out.println("assignBed");
        CareFacility instance = new CareFacility();
        instance.assignBed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
