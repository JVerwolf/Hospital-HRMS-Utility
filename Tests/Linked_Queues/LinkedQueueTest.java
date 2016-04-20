/*
 *
 */
package Linked_Queues;

import data_structures.LinkedQueue;
import data_structures.EmptyCollectionException;
import junit.framework.TestCase;

/**
 *
 * @author John Verwolf
 */
public class LinkedQueueTest extends TestCase {

    public LinkedQueueTest(String testName) {
        super(testName);
    }

    /**
     * Test of enqueue method, of class LinkedQueue.
     */
    public void testEnqueue() {
        try {
            System.out.println("enqueue");
            Object element = "TEST";
            LinkedQueue<String> instance = new LinkedQueue<>();
            instance.enqueue("TEST");
            assertEquals(instance.dequeue(), "TEST");
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    /**
     * Test of dequeue method, of class LinkedQueue.
     */
    public void testDequeue() throws Exception {
        System.out.println("dequeue");
        LinkedQueue<String> instance = new LinkedQueue<>();
        instance.enqueue("TEST");
        Object expResult = "TEST";
        Object result = instance.dequeue();
        assertEquals(expResult, result);

    }

    /**
     * Test of isEmpty method, of class LinkedQueue.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedQueue instance = new LinkedQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

    /**
     * Test of first method, of class LinkedQueue.
     */
    public void testFirst() {
        System.out.println("first");
        LinkedQueue<String> instance = new LinkedQueue<>();
        instance.enqueue("TEST");
        Object expResult = "TEST";
        Object result = instance.first();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of copy method, of class LinkedQueue.
     */
    public void testCopy() {
        System.out.println("copy");
        LinkedQueue<String> instance = new LinkedQueue<>();
        instance.enqueue("TEST");
        LinkedQueue<String>  result = instance.copy();
        if (instance == result) {
            fail();
        }
    }
}
