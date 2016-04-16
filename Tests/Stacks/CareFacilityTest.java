/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stacks;

import hospital_components.Patient;
import hospital_components.CareFacility;
import hospital_components.Bed;
import data_structures.EmptyCollectionException;
import data_structures.ArrayStack;
import hospital_components.CasualEmployee;
import data_structures.LinkedList;
import data_structures.LinkedQueue;
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
        System.out.println("testAddPatient");

        ArrayStack<Patient> pStack = new ArrayStack<>();
        CareFacility CF = new CareFacility("TestLab", pStack, null, null);

        /**
         * Generate a 5 Patient objects and add them to CF
         */
        Patient p4 = new Patient("", 4);
        Patient p3 = new Patient("", 3);
        Patient p2 = new Patient("", 2);
        Patient p1 = new Patient("", 1);
        Patient p0 = new Patient("", 0);

        CF.addPatient(p1);//first in, last out
        CF.addPatient(p2);
        CF.addPatient(p3);
        CF.addPatient(p0);
        CF.addPatient(p4);//last in, first out

        /**
         * this loop will compare priory values of patients in the stack. the
         * priority value should be the same as the counter i.
         */
        try {
            ArrayStack<Patient> pStackCopy = CF.getCopyPatientStack();
            int i = 0;
            while (!pStackCopy.isEmpty()) {
                if (i != pStackCopy.pop().getPriority()) {
                    fail("at testSortPatientStack");                //fail if the priority is not correct
                }
                i++;                                                //increment priority counter
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

        /**
         * Generate a 5 Patient objects and push them onto an ArrayStack
         */
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

        /**
         * Generate a CareFacility and pass pStack of patient objects to it. The
         * method sortPatientStack() is called in the CareFacility constructor
         * to sort the Patient objects by order of priority.
         */
        CareFacility CF = new CareFacility("TestLab", pStack, null, null);

        /**
         * this loop will compare priory values of patients in the stack. the
         * priority value should be the same as the counter i.
         */
        try {
            ArrayStack<Patient> pStackCopy = CF.getCopyPatientStack();
            int i = 0;
            while (!pStackCopy.isEmpty()) {
                if (i != pStackCopy.pop().getPriority()) {
                    fail("at testSortPatientStack");                //fail if the priority is not correct
                }
                i++;                                                //increment priority counter
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
        LinkedList<Bed> bList = new LinkedList<>();
        bList.addFirst(b1);
        bList.addFirst(b2);

        /**
         * Generate CareFacility object and pass both stacks. Call assignBed
         * method
         */
        CareFacility CF = new CareFacility("TestLab", pStack, bList, null);
        CF.assignBeds();

        /**
         * pop each patient and check to make sure that they have been assigned
         * beds in the correct order
         */
        try {
            ArrayStack<Patient> pStackCopy = CF.getCopyPatientStack();
            if (pStackCopy.pop().getBed() != null) {
                fail("at testAssignBed");
            }
            if (pStackCopy.pop().getBed() == null) {
                fail("at testAssignBed");
            }
            if (pStackCopy.pop().getBed() == null) {
                fail("at testAssignBed");
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
            fail("at testAssignBed");
        }
    }

    /**
     * Test of getCopyPatientStack method, of class CareFacility. Copy the
     * patientStack object, pop a patient off, then compare top elements with
     * original stack to ensure that they are not equal.
     */
    @Test
    public void testGetCopyPatientStack() {
        System.out.println("getCopyPatientStack");

        CareFacility instance = new CareFacility();
        Patient p1 = new Patient("", 1);
        instance.addPatient(p1);
        try {
            ArrayStack<Patient> copyStack1 = instance.getCopyPatientStack();
            copyStack1.pop();
            ArrayStack<Patient> copyStack2 = instance.getCopyPatientStack();
            /**
             * check to make sure that popping patient off of copyStack1 does
             * not affect original CareFacility instance.
             */
            assertEquals(p1, copyStack2.pop());
        } catch (EmptyCollectionException e) {
            System.out.println(e);
            fail("at testAssignBed");
        }

    }

    /**
     * Test of assignCasualEmployee method, of class CareFacility.
     */
    @Test
    public void testAssignCasualEmployee() {
        System.out.println("assignCasualEmployee");

        Patient p0 = new Patient("", 0);
        ArrayStack<Patient> pStack = new ArrayStack<>();
        pStack.push(p0);

        CasualEmployee e3 = new CasualEmployee("Bob3", true);
        LinkedQueue<CasualEmployee> CEQueue = new LinkedQueue<>();
        CEQueue.enqueue(e3);

        CareFacility instance = new CareFacility("TestLab", pStack, null, CEQueue);
        instance.assignCasualEmployee();

        /**
         * pop each patient and check to make sure that they have been assigned
         * beds in the correct order
         */
        try {
            ArrayStack<Patient> pStackCopy = instance.getCopyPatientStack();
            if (pStackCopy.pop().getCasualEmployee() == null) {
                fail("at testAssignBed");
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
            fail("at testAssignBed");
        }
    }

    /**
     * Test of assignBedAndCasualEmployee method, of class CareFacility.
     */
    @Test
    public void testAssignBedAndCasualEmployee() {
        System.out.println("assignBedAndCasualEmployee");

        Patient p0 = new Patient("", 0);
        ArrayStack<Patient> pStack = new ArrayStack<>();
        pStack.push(p0);

        CasualEmployee e3 = new CasualEmployee("Bob3", true);
        LinkedQueue<CasualEmployee> CEQueue = new LinkedQueue<>();
        CEQueue.enqueue(e3);

        Bed b1 = new Bed("Bed2", "1");
        LinkedList<Bed> bList = new LinkedList<>();
        bList.addFirst(b1);

        CareFacility instance = new CareFacility("TestLab", pStack, bList, CEQueue);
        instance.assignBedAndCasualEmployee();
        /**
         * pop each patient and check to make sure that they have been assigned
         * beds in the correct order
         */
        try {
            ArrayStack<Patient> pStackCopy = instance.getCopyPatientStack();
            Patient p = pStackCopy.pop();
            if (p.getCasualEmployee() == null) {
                fail("at testAssignBed");
            }
            if (p.getBed() == null) {
                fail("at testAssignBed");
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
            fail("at testAssignBed");
        }
    }

    /**
     * Test of getCopyCasualEmployeeQueue method, of class CareFacility.
     */
    @Test
    public void testGetCopyCasualEmployeeQueue() {
        System.out.println("getCopyCasualEmployeeQueue");

        CasualEmployee e1 = new CasualEmployee("", true);
        LinkedQueue<CasualEmployee> e = new LinkedQueue<>();
        e.enqueue(e1);

        CareFacility instance = new CareFacility(null, null, null, e);

        LinkedQueue<CasualEmployee> test = instance.getCopyCasualEmployeeQueue();

        if (test == e) {
            fail();
        }
    }

    /**
     * Test of getCopyBedListAvailable method, of class CareFacility.
     */
    public void testGetCopyBedList() {
        System.out.println("getCopyBedList");

        Bed b1 = new Bed("", "");
        LinkedList<Bed> bL = new LinkedList<>();
        bL.addFirst(b1);

        CareFacility instance = new CareFacility(null, null, bL, null);

        LinkedList<Bed> test = instance.getCopyBedListAvailable();

        if (test == bL) {
            fail();
        }
    }

}
