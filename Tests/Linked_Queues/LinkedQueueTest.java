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
public class LinkedQueueTest extends TestCase {
    
    public LinkedQueueTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(LinkedQueueTest.class);
        return suite;
    }

    /**
     * Test of enqueue method, of class LinkedQueue.
     */
    public void testEnqueue() {
        System.out.println("enqueue");
        Object element = null;
        LinkedQueue instance = new LinkedQueue();
        instance.enqueue(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dequeue method, of class LinkedQueue.
     */
    public void testDequeue() throws Exception {
        System.out.println("dequeue");
        LinkedQueue instance = new LinkedQueue();
        Object expResult = null;
        Object result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class LinkedQueue.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedQueue instance = new LinkedQueue();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of first method, of class LinkedQueue.
     */
    public void testFirst() {
        System.out.println("first");
        LinkedQueue instance = new LinkedQueue();
        Object expResult = null;
        Object result = instance.first();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class LinkedQueue.
     */
    public void testSize() {
        System.out.println("size");
        LinkedQueue instance = new LinkedQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
