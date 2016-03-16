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
public class Queue_List_MainClassTest extends TestCase {
    
    public Queue_List_MainClassTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(Queue_List_MainClassTest.class);
        return suite;
    }

    /**
     * Test of main method, of class Queue_List_MainClass.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Queue_List_MainClass.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
