/*
 *
 */
package SearchAndSort;

import Linked_Queues.CasualEmployee;
import Linked_Queues.LinkedList;
import Linked_Queues.LinkedQueue;
import Stacks.ArrayStack;
import Stacks.Bed;
import Stacks.EmptyCollectionException;
import Stacks.Patient;

/**
 *
 * @author John Verwolf
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayStack<Patient> testStack = stackOfPatients();
        
        new WriteFile<>(testStack).writeTo("TempSerFiles/testStack.ser");
        ArrayStack<Patient> testInputStack = (ArrayStack<Patient>)new ReadFile<Patient>("TempSerFiles/testStack.ser").getFile();
        
        try {
            while (!testInputStack.isEmpty()) {               //loop while there are still elements in the patientStack
                System.out.println(testInputStack.pop().getName());             //pop a patient, assign to temp variable
                
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    /**
     * Generate and return a stack of 10 patients.
     *
     * @return a stack of 10 patients.
     */
    private static ArrayStack stackOfPatients() {
        Patient p10 = new Patient("Bob10", 10);
        Patient p9 = new Patient("Bob9", 9);
        Patient p8 = new Patient("Bob8", 8);
        Patient p7 = new Patient("Bob7", 7);
        Patient p6 = new Patient("Bob6", 6);
        Patient p5 = new Patient("Bob5", 5);
        Patient p4 = new Patient("Bob4", 4);
        Patient p3 = new Patient("Bob3", 3);
        Patient p2 = new Patient("Bob2", 2);
        Patient p1 = new Patient("Bob1", 1);

        ArrayStack<Patient> pStack = new ArrayStack<>();

        for (Patient e : new Patient[]{p2, p1, p3, p8, p5, p9, p7, p6, p4, p10}) {
            pStack.push(e);
        }

        return pStack.copy();
    }

    /**
     * Generate and return a stack of beds with 4 beds.
     *
     * @return a stack of beds with 4 beds.
     */
    private static LinkedList<Bed> listOfBeds() {
        Bed b1 = new Bed("Bed1", "1");
        Bed b2 = new Bed("Bed2", "1");
        Bed b3 = new Bed("Bed3", "1");
        Bed b4 = new Bed("Bed4", "1");
        Bed b5 = new Bed("Bed5", "1");
        Bed b6 = new Bed("Bed6", "1");

        LinkedList<Bed> bList = new LinkedList<>();

        for (Bed e : new Bed[]{b1, b2, b3, b4, b5, b6}) {
            bList.addLast(e);
        }
        return bList;
    }

    private static LinkedQueue<CasualEmployee> queueOfCasualEmployees() {
        CasualEmployee e1 = new CasualEmployee("Emp1", true);
        CasualEmployee e2 = new CasualEmployee("Emp2", true);
        CasualEmployee e3 = new CasualEmployee("Emp3", true);

        LinkedQueue<CasualEmployee> CEQueue = new LinkedQueue<>();

        for (CasualEmployee e : new CasualEmployee[]{e1, e2, e3}) {
            CEQueue.enqueue(e);
        }
        return CEQueue;
    }
}
