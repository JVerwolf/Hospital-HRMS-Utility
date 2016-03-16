/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linked_Queues;

import Stacks.EmptyCollectionException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author John Verwolf
 */
public class QueueADTTest extends TestCase {
    
    public QueueADTTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(QueueADTTest.class);
        return suite;
    }

    /**
     * Test of enqueue method, of class QueueADT.
     */
    public void testEnqueue() {
        System.out.println("enqueue");
        Object element = null;
        QueueADT instance = new QueueADTImpl();
        instance.enqueue(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dequeue method, of class QueueADT.
     */
    public void testDequeue() throws Exception {
        System.out.println("dequeue");
        QueueADT instance = new QueueADTImpl();
        Object expResult = null;
        Object result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of first method, of class QueueADT.
     */
    public void testFirst() {
        System.out.println("first");
        QueueADT instance = new QueueADTImpl();
        Object expResult = null;
        Object result = instance.first();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class QueueADT.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        QueueADT instance = new QueueADTImpl();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class QueueADT.
     */
    public void testSize() {
        System.out.println("size");
        QueueADT instance = new QueueADTImpl();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class QueueADT.
     */
    public void testToString() {
        System.out.println("toString");
        QueueADT instance = new QueueADTImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class QueueADTImpl implements QueueADT {

        public void enqueue(T element) {
        }

        public T dequeue() throws EmptyCollectionException {
            return null;
        }

        public T first() {
            return null;
        }

        public boolean isEmpty() {
            return false;
        }

        public int size() {
            return 0;
        }

        public String toString() {
            return "";
        }
    }
    
}
