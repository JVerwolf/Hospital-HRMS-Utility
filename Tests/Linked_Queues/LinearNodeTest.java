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
public class LinearNodeTest extends TestCase {
    
    public LinearNodeTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(LinearNodeTest.class);
        return suite;
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNext method, of class LinearNode.
     */
    public void testSetNext() {
        System.out.println("setNext");
        LinearNode instance = new LinearNode();
        instance.setNext(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElement method, of class LinearNode.
     */
    public void testGetElement() {
        System.out.println("getElement");
        LinearNode instance = new LinearNode();
        Object expResult = null;
        Object result = instance.getElement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setElement method, of class LinearNode.
     */
    public void testSetElement() {
        System.out.println("setElement");
        Object elem = null;
        LinearNode instance = new LinearNode();
        instance.setElement(elem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
