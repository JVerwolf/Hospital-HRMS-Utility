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
        sortPatientStack(); //sort data in  passed stack of patients
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
        bedStack = new ArrayStack<>();
        patientStack = new ArrayStack<>();
    }

    public void addPatient(Patient p) {
        //System.out.println("\nNEW INSERT"); //uncomment to view algorithm in action
        insert(patientStack, p);
    }

    /**
     * This method will sort the instance object patientStack according to
     * criticallity.
     */
    public void sortPatientStack() {
        sort(patientStack);
    }

    /**
     * This method will sort an ArrayObject of generic type Patient by
     * criticallity. It is an expensive call, likely O(n^2), so use judiciously.
     *
     * @param stack ArrayStack of Patient type to be sorted.
     */
    private void sort(ArrayStack<Patient> stack) {
        try {
            if (stack.isEmpty()) {      //when stack becomes empty, return to right after sort(s); call, before insert(s, t) below.
                return;
            }
            Patient t = stack.pop();    //Peel every element off of stack and store in call-stack
            sort(stack);                //recursive call
            insert(stack, t);           //sort top element of call stack back into stack.
        } catch (EmptyCollectionException e) {
            System.out.println("Something went wrong in Carefacility.sort(s):\t" + e);
        }
    }

    /**
     * This method will insert a patient into a stack in order of criticallity.
     * The patients with the lowest criticallity are placed on the top of the
     * stack because they are most likely to be popped off of the stack, and
     * this will cause less time for the sorting algorithm.
     *
     * @param stack   ArrayStack of Patients in which patient will be inserted
     * @param patient Patient to be inserted
     */
    private void insert(ArrayStack<Patient> stack, Patient patient) {

        try {
            if (stack.isEmpty()) { //if the stack is empty
                //System.out.println("push1");
                stack.push(patient);//push patient on stack
                return;
            }
            if (stack.peek().getPriority() < patient.getPriority()) {   //check if priority of top element on stack is lower
                Patient t = stack.pop();                                //pop top element and store in a temp variable
                //System.out.println("in"); 
                insert(stack, patient);             //recursive call. (Do it all again with one less element on the call-stack).    
                //System.out.println("out, push2");
                stack.push(t);                      //put topElement back on to stack as recursion unwinds
            } else {                                //insert patient when priority is not larger than the top stack element
                //System.out.println("push3");
                stack.push(patient);                //insert patient in proper place on stack
            }
        } catch (EmptyCollectionException e) {
            System.out.println("Something went wrong in Carefacility.insert(s,p):\t" + e);
        }
    }

    private static void bedTime(ArrayStack<Patient> PatientS, ArrayStack<Bed> bedS) {

        try {
            if (!bedS.isEmpty()) {
                return;
            }
            if (!PatientS.isEmpty()) {
                Patient t = PatientS.pop();                     //pop temp element off of the stack
                bedTime(PatientS, bedS);                        //recursive call
                //if (t.getBed() == null && !bedS.isEmpty()) {    //(if there is a patient without a bed, and beds in the bedStack)
                if (t.getBed() == null) {
                    t.setBed(bedS.pop());                       //pop bed from bed stack and give to patient 
                }
                PatientS.push(t);          //put temp element back on to stack as recursion unwinds
            }
        } catch (EmptyCollectionException e) {
            System.out.println("Something went wrong in the queue ADT:\t" + e);
        }
    }

    /**
     * Assign registered patients to existing beds, without kicking people in
     * beds out.
     */
    public void assignBed() {
        bedTime(ArrayStack < Patient > PatientS, ArrayStack < Bed > bedS) /*
                 * ArrayStack<Patient> tempStack = new ArrayStack<>();
                 *
                 * //reverse order by flipping stack into tempStack Bed[]
                 * bedArray = new Bed[patientStack.size()]; //make an array to
                 * hold references to bed objects try { int i = 0; //iterator
                 * varaible to store position for bed insertion into array while
                 * (patientStack.peek() != null) { //loop while there are still
                 * elements in the stack we are pulling from Patient p1 =
                 * patientStack.pop(); //temp variable holds popped element if
                 * (p1.getBed() != null) { //if (the patient has a bed assigned
                 * to them){... bedArray[i] = p1.getBed(); //assign reference to
                 * bed then add to array i++; //increment array position
                 * iterator } tempStack.push(p1); //push the patient into the
                 * tempStack } } catch (EmptyCollectionException e) {
                 * System.out.println("Something went wrong in
                 * Carefacility.assignBed():\t" + e);
                 *
                 * }
                 * try { while (tempStack.peek() != null) { //while there are
                 * elements in the tempStack Patient p2 = tempStack.pop(); if
                 * (p2.getBed() == null) { //if the patient does not have a bed
                 * assigned to them) //asign bed }
                 *
                 * }
                 * } catch (EmptyCollectionException e) {
                 * System.out.println("Something went wrong in
                 * Carefacility.assignBed():\t" + e); }
                 */

    }

}
