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
public class Linked_QueuesSuite extends TestCase {
    
    public Linked_QueuesSuite(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("Linked_QueuesSuite");
        suite.addTest(LinkedListTest.suite());
        suite.addTest(ListADTTest.suite());
        suite.addTest(LinearNodeTest.suite());
        suite.addTest(CasualEmployeeTest.suite());
        suite.addTest(ElementNotFoundExceptionTest.suite());
        suite.addTest(Queue_List_MainClassTest.suite());
        suite.addTest(ForTestingTest.suite());
        suite.addTest(BusinessRulesTest.suite());
        suite.addTest(LinkedQueueTest.suite());
        suite.addTest(QueueADTTest.suite());
        return suite;
    }
    
}
