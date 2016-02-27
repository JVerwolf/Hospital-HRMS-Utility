/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stacks;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ADT.FullTimeEmployee;

/**
 *
 * @author C0432660 John Verwolf
 */
public class ArrayStackTest {

    public ArrayStackTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of push method, of class ArrayStack.
     */
    @Test
    public void testPush() {
        System.out.println("test push:");
        Integer element1 = 1;
        Integer element2 = 2;
        Integer element3 = 3;
        ArrayStack<Integer> instance = new ArrayStack<>();
        instance.push(element1);
        instance.push(element2);
        instance.push(element3);
        System.out.println("\tPass");

    }

    /**
     * Test of pop, push methods of class ArrayStack.
     */
    @Test
    public void testPopPush() {
        {
            /**
             * Try to push and pop from stack
             *
             */
            System.out.println("Try .push() and .pop() on stack");
            ArrayStack<Integer> instance = new ArrayStack<>();

            Integer element1 = 1;
            Integer element2 = 2;
            Integer element3 = 3;

            instance.push(element1);
            instance.push(element2);
            instance.push(element3);

            try {
                System.out.println("\t" + instance.pop());
                System.out.println("\t" + instance.pop());                
                System.out.println("\t" + instance.pop());
                System.out.println("\t" + instance.pop());//pop empty stack

                fail("\tno exception thrown in try block"); //exception should be thrown before this line is called
            } catch (EmptyCollectionException e) {
                System.out.println("\t" + e);
            } catch (Exception e) {
                System.out.println(e);
                fail("\tfailed: An unnexpected exception was thrown");
            }
        }
    }

    /**
     * Test of peek method, of class ArrayStack.
     */
    @Test
    public void testPeek() throws Exception {
        System.out.println("test peek method:");
        ArrayStack<Integer> instance = new ArrayStack<>();
        Integer element1 = 1;
        instance.push(element1);       
        Object result = instance.peek();
        assertEquals(element1, result);
        
    }

    /**
     * Test of isEmpty method, of class ArrayStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayStack instance = new ArrayStack();
        Boolean expResult = true;
        Boolean result = instance.isEmpty();
        assertEquals(expResult, result);        
    }

    /**
     * Test of size method, of class ArrayStack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayStack instance = new ArrayStack();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);        
    }

}
