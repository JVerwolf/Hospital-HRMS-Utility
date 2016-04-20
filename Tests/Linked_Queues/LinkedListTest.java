/*
 *
 */
package Linked_Queues;

import data_structures.LinkedList;
import data_structures.EmptyCollectionException;
import java.util.Iterator;
import junit.framework.TestCase;

/**
 *
 * @author John Verwolf
 */
public class LinkedListTest extends TestCase {

    public LinkedListTest(String testName) {
        super(testName);
    }

    /**
     * Test of addFirst method, of class LinkedList.
     */
    public void testAddFirst() {
        System.out.println("addFirst");

        LinkedList instance = new LinkedList();
        instance.addFirst("TEST");
        try {
            assertEquals(instance.removeFirst(), "TEST");
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    /**
     * Test of addLast method, of class LinkedList.
     */
    public void testAddLast() {
        System.out.println("addLast");
        LinkedList instance = new LinkedList();
        instance.addLast("TEST");
        try {
            assertEquals(instance.removeLast(), "TEST");
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    /**
     * Test of removeFirst method, of class LinkedList.
     */
    public void testRemoveFirst() throws Exception {
        System.out.println("removeFirst");
        LinkedList instance = new LinkedList();
        instance.addFirst("TEST");
        Object expResult = "TEST";
        Object result = instance.removeFirst();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeLast method, of class LinkedList.
     */
    public void testRemoveLast() throws Exception {
        System.out.println("removeLast");
        LinkedList instance = new LinkedList();
        instance.addLast("TEST");
        Object expResult = "TEST";
        Object result = instance.removeLast();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class LinkedList.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedList instance = new LinkedList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of first method, of class LinkedList.
     */
    public void testFirst() {
        System.out.println("first");
        LinkedList instance = new LinkedList();
        instance.addFirst("TEST");
        Object expResult = "TEST";
        Object result = instance.first();
        assertEquals(expResult, result);
    }

    /**
     * Test of last method, of class LinkedList.
     */
    public void testLast() {
        System.out.println("last");
        System.out.println("first");
        LinkedList instance = new LinkedList();
        instance.addLast("TEST");
        Object expResult = "TEST";
        Object result = instance.last();
        assertEquals(expResult, result);
    }

    /**
     * Test of copy method, of class LinkedList.
     */
    public void testCopy() {
        System.out.println("copy");
        LinkedList<String> instance = new LinkedList<>();
        instance.addFirst("TEST");
        LinkedList result = instance.copy();
        if(instance == result){
            fail();
        }        
    }
}
