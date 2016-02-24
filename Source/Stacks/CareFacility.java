package Stacks;

import ADT.Company;
import ADT.FullTimeEmployee;
import ADT.HourlyEmployee;

/**
 *
 * @author John Verwolf
 */
public class CareFacility extends Company {

    private java.lang.String facilityName;
    public ArrayStack<Patient> patientStack;
    private ArrayStack<Bed> bedStack;
    private HourlyEmployee[] hourlyEmployee;

    /**
     * Initializes this Care Facility object's name and array of employees,
     * array of beds and array of patients to null
     */
    public CareFacility() {
        facilityName = null;
        hourlyEmployee = new HourlyEmployee[50];
        bedStack = new ArrayStack<>();
        patientStack = new ArrayStack<>();
    }

    /**
     * Initializes this Care Facility object's name and array of employees array
     * of beds and array of patients from a specified name and array of
     * employees, array of beds and array of patients
     *
     * @param facilityName
     * @param patientStack
     * @param bedStack
     * @param hourlyEmployee
     */
    public CareFacility(String facilityName, ArrayStack<Patient> patientStack, ArrayStack<Bed> bedStack, HourlyEmployee[] hourlyEmployee) {
        this.facilityName = facilityName;
        this.patientStack = patientStack;
        this.bedStack = bedStack;
        this.hourlyEmployee = hourlyEmployee;
    }

    /**
     * Initializes this Care Facility object's name and array of employees from
     * specified name and array of employees The array of beds and array of
     * patients will be set to null
     *
     * @param facilityName
     * @param hourlyEmployee
     */
    public CareFacility(String facilityName, HourlyEmployee[] hourlyEmployee) {
        this.facilityName = facilityName;
        this.hourlyEmployee = hourlyEmployee;
        bedStack = null;
        patientStack = null;
    }

    public void addPatient(Patient p) {
        //System.out.println("\nNEW INSERT"); //uncomment to view algorithm in action
        insert(patientStack, p);
    }

    private void insert(ArrayStack<Patient> s, Patient p) {

        try {
            if (s.isEmpty()) { //if the stack is empty
                //System.out.println("push1");
                s.push(p);//push patient on stack
                return;
            }
            if (s.peek().getPriority() < p.getPriority()) { //check if priority of top element on stack is lower
                Patient t = s.pop();//peek at top element 
                //System.out.println("in"); 
                insert(s, p); //recursive call. Do it all again with one less element on the stack.    
                //System.out.println("out, push2");
                s.push(t); //put topElement back on to stack as recursion unwinds
            } else {
                //System.out.println("push3");
                s.push(p);
                return;
            }

        } catch (EmptyCollectionException e) {
            System.out.println("Something went wrong in the queue ADT:\t" + e);
        }

    }

    /**
     * Assign registered patients to existing beds
     */
    public void assignBed() {

    }
//
//        ArrayStack<Patient> tempPatientStack = new ArrayStack<>();
//
//        try {
//            while (!tempPatientStack.isEmpty()) {
//
//            }
//        } catch (EmptyCollectionException e) {
//            System.out.println("Something went wrong in the assign bed first try block\t" + e);
//        }

    //now we have two stacks of patients, one with beds, one without
    //take the stack without beds and 
//        ArrayStack<Patient> tempPatientNoBedStack = new ArrayStack<>();
//        ArrayStack<Patient> tempPatientHasBedStack = new ArrayStack<>();
//        try {
//            for (int i = patientStack.size(); i >= 0; i--) { //(i >= 0) is a candidate for errors. TODO: check this                
//                Patient p = patientStack.pop();
//                if (p.getBed() == null) { //if the patient does not have a bed assigned to them
//                    //put in tempPatientNoBedStack
//                    tempPatientNoBedStack.push(p);
//                } else {
//                    //put in tempPatientHasBedStack
//                    tempPatientHasBedStack.push(p);
//                }
//            }
//        } catch (EmptyCollectionException e) {
//            System.out.println("Something went wrong in the assign bed first try block\t" + e);
//        }
//        //now we have two stacks of patients, one with beds, one without
//        //take the stack without beds and 
//    }
//        /**
//         *
//         * get stack of beds (bed3, bed2, bed1)
//         *
//         * For sorting algorithm
//         * first pick from all those with most criticallity who have no bed and
//         * assign all to beds. Nest pick all those (who have no bed) with second
//         * worst criticallity and assign all to beds. wash, rinse, repeat
//         *
//         * Things to note: people in beds should probably stay in beds
//         *          *
//         * assign temp stack of patients
//         * check each patient in patient stack and see if there are any not in a
//         * bed
//         * if they have no bed, put them into the temp stack
//         *
//         * check to make sure bed is not in use
//         *
//         */
//        ASQueue<Patient> tempPatientQueue = new ASQueue<>(); //check to ensure that this is initially big enough to hold all data 
//
//        for (int i = patientStack.size(); i >= 0; i--) {
//            Patient p = patientStack.peek();
//            if (p.getBed() == null){
//                
//            }
//        }
//        
//        try {
//            if (!patientStack.isEmpty()) {
//                Patient topElement = patientStack.pop();
//                tempPatientQueue.push(topElement)
//            }
//        } catch (EmptyCollectionException e) {
//            System.out.println("Something went wrong in the queue ADT:\t" + e);
//        }
//    }
//
////        try {
////
////            if (!patientStack.isEmpty()) {
////                Patient topElement = patientStack.pop();//pop top element off of the stack
////                tempPatientStack.push(topElement); //copy patients into another data structure TODO: investigate Queue
////                this.push(element); //recursive call
////                patientStack.push(topElement); //put topElement back on to stack as recursion unwinds
////            } else {
////                patientStack.push(element); //put element at the bottom of the stack
////            }
////
////        } catch (EmptyCollectionException e) {
////            System.out.println("Something went wrong in the queue ADT:\t" + e);
////        }
////    }
////    private ASQueue copyStackToQueue(ArrayStack tempStack) {
////        ASQueue<Patient> tempPatientQueue = new ASQueue<>();
////        try {
////            if (!tempStack.isEmpty()) {
////                Patient topElement = patientStack.pop();//pop top element off of the stack
////            }
////        } catch (EmptyCollectionException e) {
////            System.out.println("Something went wrong in the queue ADT:\t" + e);
////        }
//}
//iterate through array
}
