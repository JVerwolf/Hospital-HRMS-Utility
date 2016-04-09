/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stacks;

import hospital_components.Patient;
import hospital_components.Bed;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author C0432660 John Verwolf
 */
public class PatientTest {
    
    public PatientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getBed and setBed method, of class Patient.
     */
    @Test
    public void testGetAndSetBed() {
        System.out.println("getBed");
        Patient instance = new Patient();
        Bed bed = new Bed("TestBed","");
        instance.setBed(bed);               //test setBed
        Bed expResult = bed;
        Bed result = instance.getBed();     //test getBed
        assertEquals(expResult, result);        
    } 

    /**
     * Test of getName method, of class Patient.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Patient instance = new Patient("TestName", 1);
        String expResult = "TestName";
        String result = instance.getName();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setName method, of class Patient.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        Patient instance = new Patient("", 1);
        instance.setName("TestName");
        String expResult = "TestName";
        String result = instance.getName();
        assertEquals(expResult, result); 
        
    }

    /**
     * Test of getPriority method, of class Patient.
     */
    @Test
    public void testGetPriority() {
        System.out.println("getPriority");      
        Patient instance = new Patient("TestName", 1);
        int expResult = 1;
        int result = instance.getPriority();
        assertEquals(expResult, result);        
    
    }

    /**
     * Test of setPriority method, of class Patient.
     */
    @Test
    public void testSetPriority() {
        System.out.println("setPriority");
        Patient instance = new Patient("", 1);
        instance.setPriority(5);
        int expResult = 5;
        int result = instance.getPriority();
        assertEquals(expResult, result); 
    }

    /**
     * Test of toString method, of class Patient.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Patient instance = new Patient("TestName",1);
        String expResult = "Patient: bed=null, name=TestName, priority=1";        
        String result = instance.toString();        
        assertEquals(expResult, result);
    }    
}
