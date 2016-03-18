package Stacks;

import ADT.Company;
import Linked_Queues.CasualEmployee;
import Linked_Queues.LinkedList;
import Linked_Queues.LinkedQueue;

/**
 * This class models a care facility with patients, beds, and hourly employees.
 *
 * @author John Verwolf
 */
public class CareFacility extends Company {

    private LinkedList<Bed> bedList;
    private java.lang.String facilityName;
    private ArrayStack<Patient> patientStack;
    private LinkedQueue<CasualEmployee> casualEmployee;

    /**
     * Initializes this Care Facility object's name and array of employees,
     * array of beds and array of patients to null
     */
    public CareFacility() {
        facilityName = "";
        casualEmployee = new LinkedQueue<>();
        bedList = new LinkedList<>();
        patientStack = new ArrayStack<>();
    }

    /**
     * Initializes this Care Facility object's name and array of employees array
     * of beds and array of patients from a specified name and array of
     * employees, array of beds and array of patients
     *
     * @param facilityName   The name of the facility
     * @param patientStack   A stack of patient objects
     * @param bedList        A stack of beds
     * @param casualEmployee An linked list of hourly employees
     */
    public CareFacility(String facilityName, ArrayStack<Patient> patientStack, LinkedList<Bed> bedList, LinkedQueue<CasualEmployee> casualEmployee) {
        this.facilityName = facilityName;
        this.patientStack = patientStack;
        this.bedList = bedList;
        this.casualEmployee = casualEmployee;

        sortPatientStack(); //sort data in  passed stack of patients
    }

    /**
     * Initializes this Care Facility object's name and array of employees from
     * specified name and array of employees The array of beds and array of
     * patients will be set to null
     *
     * @param facilityName   The name of the facility
     * @param casualEmployee An linked list of hourly employees
     */
    public CareFacility(String facilityName, LinkedQueue<CasualEmployee> casualEmployee) {
        this.facilityName = facilityName;
        this.casualEmployee = casualEmployee;
        bedList = new LinkedList<>();
        patientStack = new ArrayStack<>();
    }

    /**
     * This method adds a patient to the patient stack and places it in order or
     * priority on the stack.
     *
     * @param p patient object to be inserted in order into the priority stack
     */
    public void addPatient(Patient p) {
        insert(patientStack, p);
    }

    /**
     * This method will sort the instance object patientStack according to
     * priority.
     */
    public final void sortPatientStack() {
        sort(patientStack);
    }

    /**
     * This method will sort an ArrayObject of generic type Patient by priority.
     * It is an expensive call, likely O(n^2), so use judiciously.
     *
     * @param stack ArrayStack of Patient type to be sorted.
     */
    private void sort(ArrayStack<Patient> stack) {
        try {
            if (stack == null) {
                return;
            } else if (stack.isEmpty()) {      //when stack becomes empty, return to right after sort(s); call, before insert(s, t) below.
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
     * This method will insert a patient into a stack in order of priority. The
     * patients with the lowest priority are placed on the top of the stack
     * because they are most likely to be popped off of the stack, and this will
     * cause less time for the sorting algorithm to resort whenever a patient
     * leaves the facility.
     *
     * @param stack   ArrayStack of Patients in which patient will be inserted
     * @param patient Patient to be inserted
     */
    private void insert(ArrayStack<Patient> stack, Patient patient) {

        try {
            if (stack.isEmpty()) {      //if the stack is empty
                stack.push(patient);    //push patient on stack
                return;
            }
            if (stack.peek().getPriority() < patient.getPriority()) {   //check if priority of top element on stack is lower
                Patient t = stack.pop();                                //pop top element and store in a temp variable
                insert(stack, patient);             //recursive call. (Do it all again with one less element on the call-stack).    
                stack.push(t);                      //put topElement back on to stack as recursion unwinds
            } else {                                //insert patient when priority is not larger than the top stack element
                stack.push(patient);                //insert patient in proper place on stack
            }
        } catch (EmptyCollectionException e) {
            System.out.println("Something went wrong in Carefacility.insert(s,p):\t" + e);
        }
    }

    /**
     * Assign registered patients to existing beds, without kicking people
     * already in beds out.
     */
    public void assignBed() {
        bedTime(patientStack, bedList);
    }

    /**
     * This class assigns beds (from a stack of Bed objects ) to patients (in a
     * stack of Patient objects). It will recursively call itself till the
     * patient stack is empty, then start assigning beds to the patients with
     * the highest priority which reside at the bottom of the patient stack.
     *
     * @param PatientS A stack of (sorted) Patient objects
     * @param bedS     A stack of Bed objects
     */
    private static void bedTime(ArrayStack<Patient> PatientS, LinkedList<Bed> bedS) {
        try {
            if (bedS == null) {
                return;
            }
            if (bedS.isEmpty()) {
                return;
            }
            if (!PatientS.isEmpty()) {
                Patient t = PatientS.pop();                     //pop temp element off of the stack
                bedTime(PatientS, bedS);                        //recursive call (ie reverse stack by pushing to call-stack)
                //                                              //recursion unwinds and starts returning to this line
                if (t.getBed() == null && !bedS.isEmpty()) {    //if Patient t does not have a bed and if there are beds available...
                    t.setBed(bedS.removeFirst());               //remove bed from bed linked list and give to Patient 
                }
                PatientS.push(t);                               //put temp element back on to stack as recursion unwinds
            }
        } catch (EmptyCollectionException e) {
            System.out.println("Something went wrong in the .bedTime method:\t" + e);
        }
    }

    /**
     * Assign casual employees to patients with the highest priority value
     */
    public void assignCasualEmployee() {
        AssignCasualE(patientStack, casualEmployee);
    }

    /**
     * This method recursively assigns casual employees to the patients with the
     * highest priority value
     *
     * @param PatientS The stack of patients to have casual employees assigned
     * @param CEList   The linked list of casual employees
     */
    private void AssignCasualE(ArrayStack<Patient> PatientS, LinkedQueue<CasualEmployee> CEList) {
        try {
            if (CEList == null) {
                return;
            }
            if (CEList.isEmpty()) {
                return;
            }
            if (!PatientS.isEmpty()) {
                Patient p = PatientS.pop();                                 //pop temp element off of the stack
                AssignCasualE(PatientS, CEList);                            //recursive call (ie reverse stack by pushing to call-stack)
                //                                                          //recursion unwinds and starts returning to this line
                if (p.getCasualEmployee() == null && !CEList.isEmpty()) {   //if Patient t does not have a bed and if there are beds available...
                    p.setCasualEmployee(CEList.dequeue());                  //remove bed from bed linked list and give to Patient 
                }
                PatientS.push(p);                                           //put temp element back on to stack as recursion unwinds
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e + "Something went wrong in the AssignCasualE() method:\t");
        }
    }

    /**
     * Assign a bed and a casual employee to each patient in order of highest
     * priority value first, while there are still beds and casual employees
     * available
     */
    public void assignBedAndCasualEmployee() {
        assignBed();
        assignCasualEmployee();
    }

    /**
     * Returns a copy of the patient stack. This allows the data to be printed
     * out without emptying the original stack
     *
     * @return copy of patientStack
     */
    public ArrayStack<Patient> getCopyPatientStack() {
        return patientStack.copy();
    }

    /**
     * Returns a copy of the casual employee queue. This allows the data to be
     * printed out without emptying the original stack
     *
     * @return copy of casual employee queue
     */
    public LinkedQueue<CasualEmployee> getCopyCasualEmployeeQueue() {
        return casualEmployee.copy();
    }

    /**
     * Returns a copy of the bed linked list. This allows the data to be printed
     * out without emptying the original stack
     *
     * @return copy of bed linked list
     */
    public LinkedList<Bed> getCopyBedList() {
        return bedList.copy();
    }
}
