package Linked_Queues;

import Stacks.ArrayStack;
import Stacks.Bed;

import Stacks.EmptyCollectionException;
import Stacks.Patient;

/**
 *
 * @author John Verwolf
 */
public class Queue_List_MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Here, new instance of the CareFacility class is instantiated. A stack
         * of Patient objects and a stack of Bed objects are passed, and the
         * assignBed() method is called.
         * <p>
         * A loop then prints out the list of the Patient objects in the
         * CareFacility instance, displaying their properties 'priority' and
         * 'bed'.
         * <p>
         * The expected output is a of patients sorted from lowest to highest
         * 'priority', with all the bed objects assigned to those with the
         * highest priority.
         */
        CareFacility2 CF = new CareFacility2("Test lab", stackOfPatients(), listOfBeds(), QueueOfCasualEmployees());
        {

            //this method assigns beds to patients
            CF.assignBedAndCasualEmployee();

            /**
             * Get a copy of the patientStack instance variable of CF
             * CareFacility object.
             */
            ArrayStack<Patient> tempPatientStack = CF.getCopyPatientStack();

            /**
             * This loop prints out the list of the Patient objects in the
             * CareFacility instance CF, displaying their properties 'priority'
             * and 'bed'.
             */
            try {
                while (!tempPatientStack.isEmpty()) {               //loop while there are still elements in the patientStack
                    Patient p = tempPatientStack.pop();             //pop a patient, assign to temp variable

                    String bed = "n/a";                          //instantiate bed variable to default value "NO BED"                                                                                       
                    if (p.getBed() != null) {                       //If the current patient (in the temp variable) has a bed...
                        bed = p.getBed().getName();                 //change bed variable to the name of the bed
                    }
                    String CEmployee = "n/a";
                    if (p.getCasualEmployee() != null) {                       //If the current patient (in the temp variable) has a bed...
                        CEmployee = p.getCasualEmployee().getName();        //change bed variable to the name of the bed
                    }

                    String name = p.getName();              //instantiate name varaible to hold name of patient

                    System.out.println("PATIENT NAME: " + name + "\tPATIENT PRIORITY: " + p.getPriority() + "\tBED: " + bed + "\tCASUAL EMPLOYEE:" + CEmployee);  //print out properties of current patient in temp vraible
                }
            } catch (EmptyCollectionException e) {
                System.out.println(e);
            }
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

    private static LinkedQueue<CasualEmployee> QueueOfCasualEmployees() {
        CasualEmployee e1 = new CasualEmployee("Bob1", true);
        CasualEmployee e2 = new CasualEmployee("Bob2", true);
        CasualEmployee e3 = new CasualEmployee("Bob3", true);

        LinkedQueue<CasualEmployee> CEQueue = new LinkedQueue<>();

        for (CasualEmployee e : new CasualEmployee[]{e1, e2, e3}) {
            CEQueue.enqueue(e);
        }
        return CEQueue;
    }
}
