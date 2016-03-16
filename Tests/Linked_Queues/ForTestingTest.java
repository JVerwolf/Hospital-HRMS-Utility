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
public class ForTestingTest extends TestCase {
    
    public ForTestingTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ForTestingTest.class);
        return suite;
    }

    /**
     * Test of main method, of class ForTesting.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ForTesting.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
