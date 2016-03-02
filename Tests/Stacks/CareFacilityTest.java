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
            while (!CF.patientStackClone().isEmpty()) {
                if (i != CF.patientStackClone().pop().getPriority()) {
                    fail("at testAddPatient()"); //fail if the list is not the right length
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

        Patient p4 = new Patient("", 4);
        Patient p3 = new Patient("", 3);
        Patient p2 = new Patient("", 2);
        Patient p1 = new Patient("", 1);
        Patient p0 = new Patient("", 0);
        ArrayStack<Patient> pStack = new ArrayStack<>();
        pStack.push(p0);
        pStack.push(p1);
        pStack.push(p2);
        pStack.push(p3);
        pStack.push(p4);

        CareFacility CF = new CareFacility("TestLab", pStack, null, null);

        CF.sortPatientStack();  //This is the call of the method to be tested

        /**
         * this loop will compare priory values of patients in the stack. the
         * priority value should be the same as the counter i.
         */
        int i = 0;
        try {
            while (!CF.patientStackClone().isEmpty()) {
                if (i != CF.patientStackClone().pop().getPriority()) {
                    fail("at testSortPatientStack"); //fail if the priority is not correct
                }
                i++;  //increment priority counter
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }

    }

    /**
     * Test of assignBed method, of class CareFacility.
     */
    @Test
    public void testAssignBed() {
        System.out.println("assignBed");
        /**
         * Generate stack of 3 Patients
         */
        Patient p2 = new Patient("", 2);
        Patient p1 = new Patient("", 1);
        Patient p0 = new Patient("", 0);
        ArrayStack<Patient> pStack = new ArrayStack<>();
        pStack.push(p0);
        pStack.push(p1);
        pStack.push(p2);

        /**
         * Generate stack of 2 Beds
         */
        Bed b1 = new Bed("Bed1", "1");
        Bed b2 = new Bed("Bed2", "1");
        ArrayStack<Bed> bStack = new ArrayStack<>();
        bStack.push(b1);
        bStack.push(b2);

        /**
         * Generate CareFacility object and pass both stacks. Call assignBed
         * method
         */
        CareFacility CF = new CareFacility("TestLab", pStack, bStack, null);
        CF.assignBed();

        /**
         * pop each patient and check to make sure that they have been assigned
         * beds in the correct order
         */
        try {
            if (CF.patientStackClone().pop().getBed() != null) {
                fail("at testAssignBed");
            }
            if (CF.patientStackClone().pop().getBed() == null) {
                fail("at testAssignBed");
            }
            if (CF.patientStackClone().pop().getBed() == null) {
                fail("at testAssignBed");
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
            fail("at testAssignBed");
        }
    }

}
