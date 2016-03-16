/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linked_Queues;

import java.util.Iterator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author John Verwolf
 */
public class LinkedListTest extends TestCase {
    
    public LinkedListTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(LinkedListTest.class);
        return suite;
    }

    /**
     * Test of addFirst method, of class LinkedList.
     */
    public void testAddFirst_0args() {
        System.out.println("addFirst");
        LinkedList instance = new LinkedList();
        instance.addFirst();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFirst method, of class LinkedList.
     */
    public void testAddFirst_GenericType() {
        System.out.println("addFirst");
        Object element = null;
        LinkedList instance = new LinkedList();
        instance.addFirst(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLast method, of class LinkedList.
     */
    public void testAddLast_0args() {
        System.out.println("addLast");
        LinkedList instance = new LinkedList();
        instance.addLast();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLast method, of class LinkedList.
     */
    public void testAddLast_GenericType() {
        System.out.println("addLast");
        Object element = null;
        LinkedList instance = new LinkedList();
        instance.addLast(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFirst method, of class LinkedList.
     */
    public void testRemoveFirst() throws Exception {
        System.out.println("removeFirst");
        LinkedList instance = new LinkedList();
        Object expResult = null;
        Object result = instance.removeFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeLast method, of class LinkedList.
     */
    public void testRemoveLast() throws Exception {
        System.out.println("removeLast");
        LinkedList instance = new LinkedList();
        Object expResult = null;
        Object result = instance.removeLast();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class LinkedList.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class LinkedList.
     */
    public void testSize() {
        System.out.println("size");
        LinkedList instance = new LinkedList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of first method, of class LinkedList.
     */
    public void testFirst() {
        System.out.println("first");
        LinkedList instance = new LinkedList();
        Object expResult = null;
        Object result = instance.first();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of last method, of class LinkedList.
     */
    public void testLast() {
        System.out.println("last");
        LinkedList instance = new LinkedList();
        Object expResult = null;
        Object result = instance.last();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class LinkedList.
     */
    public void testIterator() {
        System.out.println("iterator");
        LinkedList instance = new LinkedList();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
