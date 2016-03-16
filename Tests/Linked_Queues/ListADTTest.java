/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linked_Queues;

import Stacks.EmptyCollectionException;
import java.util.Iterator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author John Verwolf
 */
public class ListADTTest extends TestCase {
    
    public ListADTTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ListADTTest.class);
        return suite;
    }

    /**
     * Test of addFirst method, of class ListADT.
     */
    public void testAddFirst() {
        System.out.println("addFirst");
        ListADT instance = new ListADTImpl();
        instance.addFirst();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLast method, of class ListADT.
     */
    public void testAddLast() {
        System.out.println("addLast");
        ListADT instance = new ListADTImpl();
        instance.addLast();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFirst method, of class ListADT.
     */
    public void testRemoveFirst() throws Exception {
        System.out.println("removeFirst");
        ListADT instance = new ListADTImpl();
        Object expResult = null;
        Object result = instance.removeFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeLast method, of class ListADT.
     */
    public void testRemoveLast() throws Exception {
        System.out.println("removeLast");
        ListADT instance = new ListADTImpl();
        Object expResult = null;
        Object result = instance.removeLast();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of first method, of class ListADT.
     */
    public void testFirst() {
        System.out.println("first");
        ListADT instance = new ListADTImpl();
        Object expResult = null;
        Object result = instance.first();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of last method, of class ListADT.
     */
    public void testLast() {
        System.out.println("last");
        ListADT instance = new ListADTImpl();
        Object expResult = null;
        Object result = instance.last();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class ListADT.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ListADT instance = new ListADTImpl();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class ListADT.
     */
    public void testSize() {
        System.out.println("size");
        ListADT instance = new ListADTImpl();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class ListADT.
     */
    public void testIterator() {
        System.out.println("iterator");
        ListADT instance = new ListADTImpl();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ListADT.
     */
    public void testToString() {
        System.out.println("toString");
        ListADT instance = new ListADTImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ListADTImpl implements ListADT {

        public void addFirst() {
        }

        public void addLast() {
        }

        public T removeFirst() throws EmptyCollectionException {
            return null;
        }

        public T removeLast() throws EmptyCollectionException {
            return null;
        }

        public T first() {
            return null;
        }

        public T last() {
            return null;
        }

        public boolean isEmpty() {
            return false;
        }

        public int size() {
            return 0;
        }

        public Iterator<T> iterator() {
            return null;
        }

        public String toString() {
            return "";
        }
    }
    
}
