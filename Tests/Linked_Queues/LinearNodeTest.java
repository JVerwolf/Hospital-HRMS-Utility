/*
 *
 */
package Linked_Queues;

import data_structures.LinearNode;
import junit.framework.TestCase;

/**
 *
 * @author John Verwolf
 */
public class LinearNodeTest extends TestCase {
    
    public LinearNodeTest(String testName) {
        super(testName);
    }

    /**
     * Test of getNext method, of class LinearNode.
     */
    public void testGetNext() {
        System.out.println("getNext");
        LinearNode instance = new LinearNode();
        LinearNode expResult = null;
        LinearNode result = instance.getNext();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNext method, of class LinearNode.
     */
    public void testSetNext() {
        System.out.println("setNext");
        LinearNode instance = new LinearNode();
        instance.setNext(instance);
        assertEquals(instance.getNext(), instance);
    }

    /**
     * Test of getElement method, of class LinearNode.
     */
    public void testGetElement() {
        System.out.println("getElement");
        LinearNode<String> instance = new LinearNode<>("test");
        Object expResult = "test";
        Object result = instance.getElement();
        assertEquals(expResult, result);       
    }

    /**
     * Test of setElement method, of class LinearNode.
     */
    public void testSetElement() {
        System.out.println("setElement");
        Object elem = null;
        LinearNode instance = new LinearNode();
        instance.setElement("test");
        assertEquals(instance.getElement(), "test"); 
    }
    
}
