package hospital_components;

import data_structures.ArrayStack;
import data_structures.EmptyCollectionException;
import data_structures.LinkedList;
import data_structures.LinkedQueue;
import io_utils.ReadFile;
import io_utils.WriteFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class models a care facility with patients, beds, and hourly employees.
 *
 * @author John Verwolf
 */
public class CareFacility extends Company implements Serializable {

    private LinkedList<Bed> bedListInRepair;
    private LinkedList<Bed> bedListInWorkingOrder;
    private LinkedQueue<CasualEmployee> casualEmployee;
    private java.lang.String facilityName;
    private LinkedQueue<FullTimeEmployee> fullTimeEmployee;
    private ArrayStack<Patient> patientStack;

    /*
     * These vars do NOT hold the total number of each object in the care
     * facility, rather they just count up when called through their getter
     * methods. They are used as a way of distinguishing between default names
     * in the GUI. They were placed in this class so that their values would be
     * stored when this class is saved.
     */
    private int countBeds;
    private int countCE;
    private int countFTE;
    private int countP;

    /**
     * Initializes this Care Facility object's name and array of employees,
     * array of beds and array of patients to null
     */
    public CareFacility() {
        facilityName = "";
        casualEmployee = new LinkedQueue<>();
        fullTimeEmployee = new LinkedQueue<>();
        bedListInWorkingOrder = new LinkedList<>();
        bedListInRepair = new LinkedList<>();
        patientStack = new ArrayStack<>();

        countBeds = 0;
        countCE = 0;
        countFTE = 0;
        countP = 0;
    }

    /**
     * Initializes this Care Facility object. Initializes this Care Facility
     * object's name and array of employees, array of beds and array of patients
     * to empty lists.
     *
     * @param name Sets the name of the care facility
     */
    public CareFacility(String name) {
        this();
        facilityName = name;
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
        this();
        this.facilityName = facilityName;
        this.patientStack = patientStack;
        addBedList(bedList); //assigns beds to bedListUnavailable and bedListAvailable
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
        bedListInWorkingOrder = new LinkedList<>();
        patientStack = new ArrayStack<>();
    }

    /**
     * returns the number of times this method was called. used to create
     * default names in the GUI.
     *
     * @return the number of times this method was called.
     */
    public int getCountBeds() {
        return ++countBeds;
    }

    /**
     * returns the number of times this method was called. used to create
     * default names in the GUI.
     *
     * @return the number of times this method was called.
     */
    public int getCountCE() {
        return ++countCE;
    }

    /**
     * returns the number of times this method was called. used to create
     * default names in the GUI.
     *
     * @return the number of times this method was called.
     */
    public int getCountFTE() {
        return ++countFTE;
    }

    /**
     * returns the number of times this method was called. used to create
     * default names in the GUI.
     *
     * @return the number of times this method was called.
     */
    public int getCountP() {
        return ++countP;
    }

    /**
     * Loads the class from a file
     *
     * @param f file to load
     * @return the care facility class loaded from the file
     */
    public static CareFacility load(File f) {
        CareFacility CF = null;
        FileInputStream fileInput = null;
        ObjectInputStream in = null;
        try {
            fileInput = new FileInputStream(f);
            in = new ObjectInputStream(fileInput);
            CF = (CareFacility) in.readObject();
        } catch (IOException e) {
            System.out.println("There was an IO error: " + e);
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.out.println("The file was not found: " + e);
            System.exit(1);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
                System.out.println("There was an IO error: " + e);
            }
        }
        return CF;
    }

    /**
     * This class assigns beds (from a stack of Bed objects ) to patients (in a
     * stack of Patient objects). It will recursively call itself until the
     * patient stack is empty, then start assigning beds to the patients with
     * the highest priority which reside at the bottom of the patient stack.
     *
     * @param PatientS A stack of (sorted) Patient objects
     * @param bedS     A stack of Bed objects
     */
    private static void bedTime(ArrayStack<Patient> PatientS, LinkedList<Bed> bedS) {
        ArrayStack<Patient> reverseP = new ArrayStack<>();
        LinkedList<Bed> copyB = bedS.copy();

        try {
            ArrayStack<Patient> copyP = PatientS.copy();
            while (!copyP.isEmpty()) {
                reverseP.push(copyP.pop());
            }

            //while (there are beds left) && ( there are patients left)
            while (!reverseP.isEmpty() && !copyB.isEmpty()) {
                if (!copyB.first().isAssignable()) {
                    copyB.removeFirst();
                }
                if (reverseP.peek().getBed() != null) {
                    reverseP.pop();
                }
                if (!reverseP.isEmpty() && !copyB.isEmpty()) {
                    if ((reverseP.peek().getBed() == null) && (copyB.first().isAssignable())) {
                        Bed b = copyB.removeFirst();
                        Patient p = reverseP.pop();

                        p.setBed(b);
                        b.setPatient(p);
                    }
                }
            }
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(CareFacility.class.getName()).log(Level.SEVERE, null, ex);
        }
        //        //Old recurisve algorithm
        //        try {
        //            if (bedS == null) {
        //                return;
        //            }
        //            if (bedS.isEmpty()) {
        //                return;
        //            }
        //            if (!PatientS.isEmpty()) {
        //                Patient t = PatientS.pop();                     //pop temp element off of the stack
        //                bedTime(PatientS, bedS);                        //recursive call (ie reverse stack by pushing to call-stack)
        //                //                                              //recursion unwinds and starts returning to this line
        //                if (t.getBed() == null && !bedS.isEmpty()) {    //if Patient t does not have a bed and if there are beds available...
        //                    t.setBed(bedS.removeFirst());               //remove bed from bed linked list and give to Patient
        //                }
        //                PatientS.push(t);                               //put temp element back on to stack as recursion unwinds
        //            }
        //        } catch (EmptyCollectionException e) {
        //            System.out.println("Something went wrong in the .bedTime method:\t" + e);
        //        }
    }

    /**
     * Save the class to a file
     *
     * @param f file object holding location of save
     */
    public void Save(File f) {
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;
        try {
            fileOut = new FileOutputStream(f);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);
        } catch (IOException i) {
            System.out.println("Failure to write file:");
            i.printStackTrace();
        } finally {
            try {
                if (objOut != null) {
                    objOut.close();
                }
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * adds a Bed to the Care Facility
     *
     * @param bed bed to be added
     */
    public void addBed(Bed bed) {
        LinkedList<Bed> temp = new LinkedList<>();
        temp.addLast(bed);
        addBedList(temp);
        assignBeds();
    }

    /**
     * adds beds by availability and puts them into their respective lists.
     *
     * @param bedList list of beds to be sorted
     */
    public final void addBedList(LinkedList<Bed> bedList) {
        while (!bedList.isEmpty()) {
            try {
                if (bedList.first().getInWorkingOrder()) {
                    bedListInWorkingOrder.addFirst(bedList.removeFirst());
                } else {
                    bedListInRepair.addFirst(bedList.removeFirst());
                }
            } catch (EmptyCollectionException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * adds a new casual employee to the care facility
     *
     * @param cE casual employee
     */
    public void addCasualEmployee(CasualEmployee cE) {
        casualEmployee.enqueue(cE);
        assignCasualEmployee();
    }

    /**
     * adds a new full time employee to the care facility
     *
     * @param fTE FullTimeEmployee object
     */
    public void addFullTimeEmployee(FullTimeEmployee fTE) {
        fullTimeEmployee.enqueue(fTE);
    }

    /**
     * This method adds a patient to the patient stack and places it in order or
     * priority on the stack.
     *
     * @param p patient object to be inserted in order into the priority stack
     */
    public void addPatient(Patient p) {
        insert(patientStack, p);
        assignBedAndCasualEmployee();
    }

    /**
     * Assign a bed and a casual employee to each patient in order of highest
     * priority value first, while there are still beds and casual employees
     * available
     */
    public void assignBedAndCasualEmployee() {
        assignBeds();
        assignCasualEmployee();
    }

    /**
     * Assign registered patients to existing beds, without kicking people
     * already in beds out.
     */
    public void assignBeds() {
        cleanBedLists();
        bedTime(patientStack, bedListInWorkingOrder);
    }

    /**
     * Assign casual employees to patients with the highest priority value
     */
    public void assignCasualEmployee() {
        AssignCasualE(patientStack, casualEmployee);
    }

    /**
     * returns the bed object without removing it.
     *
     * @param n index of bed in list
     * @return bed object at index n
     * @throws EmptyCollectionException
     */
    public Bed getAvailableBed(int n) throws EmptyCollectionException {
        return bedListInWorkingOrder.get(n);
    }

    /**
     * returns a casual employee object without removing it
     *
     * @param n the index of the casual employee from the head of the queue
     * @return casual employee at index n from head
     * @throws EmptyCollectionException
     */
    public CasualEmployee getCasualEmployee(int n) throws EmptyCollectionException {
        return casualEmployee.get(n);
    }

    /**
     * Returns a copy of the bed linked list. This allows the data to be printed
     * out without emptying the original stack
     *
     * @return copy of bed linked list
     */
    public LinkedList<Bed> getCopyBedListAvailable() {
        return bedListInWorkingOrder.copy();
    }

    /**
     * Returns a copy of the bed linked list. This allows the data to be printed
     * out without emptying the original stack
     *
     * @return copy of bed linked list
     */
    public LinkedList<Bed> getCopyBedListUnavailable() {
        return bedListInRepair.copy();
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
     * Returns a copy of the full time employee queue. This allows the data to
     * be printed out without emptying the original stack
     *
     * @return copy of casual employee queue
     */
    public LinkedQueue<FullTimeEmployee> getCopyFullTimeEmployeeQueue() {
        return fullTimeEmployee.copy();
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
     * Returns a copy of the bedListAvailable. This allows the data to be
     * printed out without emptying the original Data Structure
     *
     * @return copy of bedListAvailable
     */
    public LinkedList<Bed> getCopybedListInWorkingOrder() {
        return bedListInWorkingOrder.copy();
    }

    /**
     * Returns a copy of the bedListAvailable. This allows the data to be
     * printed out without emptying the original Data Structure
     *
     * @return copy of bedListUnavailable
     */
    public LinkedList<Bed> getCopybedListUnAvailable() {
        return bedListInRepair.copy();
    }

    /**
     * returns a full Time employee object without removing it
     *
     * @param n the index of the casual employee from the head of the queue
     * @return casual employee at index n from head
     * @throws EmptyCollectionException
     */
    public FullTimeEmployee getFullTimeEmployee(int n) throws EmptyCollectionException {
        return fullTimeEmployee.get(n);
    }

    /**
     * gets without removing the patient at the selected index
     *
     * @param n index
     * @return patient at n index
     * @throws EmptyCollectionException
     */
    public Patient getPatient(int n) throws EmptyCollectionException {
        return patientStack.get(n);
    }

//    private void removeP(ArrayStack<Patient> stack, int n) {
//        //TODO: code case where n is outside of stack
//        try {
//            if (stack == null) {
//                return;
//            } else if (stack.isEmpty()) {
//                return;
//            } if (stack.size() - n == n)
//
//
//            Patient t = stack.pop();
//
//        } catch (EmptyCollectionException e) {
//            System.out.println("Something went wrong in Carefacility.sort(s):\t" + e);
//        }
//    }
    /**
     * returns the bed object without removing it.
     *
     * @param n index of bed in list
     * @return bed object at index n
     * @throws EmptyCollectionException
     */
    public Bed getUnavailableBed(int n) throws EmptyCollectionException {
        return bedListInRepair.get(n);
    }

    /**
     * Loads a list of beds from a file, provided it exists
     */
    public void loadBeds() {
        File f = new File("saves/bedList.ser");

        if (f.isFile()) {
            bedListInWorkingOrder = (LinkedList<Bed>) new ReadFile("saves/bedList.ser").getFile();
        } else {
            System.out.println("Save file does not exist");
        }
    }

    /**
     * Loads a list of casual employees from a file, provided it exists
     */
    public void loadCasualEmployee() {
        File f = new File("saves/casualEmployee.ser");

        if (f.isFile()) {
            casualEmployee = (LinkedQueue<CasualEmployee>) new ReadFile("saves/casualEmployee.ser").getFile();
        } else {
            System.out.println("Save file does not exist");
        }
    }

    /**
     * Loads a list of patients from a file, provided it exists
     */
    public void loadPatientStack() {
        File f = new File("saves/bedList.ser");

        if (f.isFile()) {
            patientStack = (ArrayStack<Patient>) new ReadFile("saves/patientStack.ser").getFile();
        } else {
            System.out.println("Save file does not exist");
        }
    }

    /**
     * Removes and returns bed at specified index.
     *
     * @param n index of bed in list
     * @return bed object at index n
     * @throws EmptyCollectionException
     */
    public Bed removeBedInRepair(int n) throws EmptyCollectionException {
        return bedListInRepair.removeAt(n);
    }

    /**
     * Returns the bed object by removing it. Removes patient from the bed.
     *
     * @param n index of bed in list
     * @return bed object at index n
     * @throws EmptyCollectionException
     */
    public Bed removeBedInWorkingOrder(int n) throws EmptyCollectionException {
        Bed bed = bedListInWorkingOrder.removeAt(n);
        bed.removePatient();
        assignBeds(); //reasign patient to a new bed in the rare instance there are more beds than patients
        return bed;
    }

    /**
     * Removes the casual employee at the selected index, assigns patients to
     * another casual employee.
     *
     * @param n the index of the casual employee from the head of the queue
     * @return casual employee at index n from head
     * @throws EmptyCollectionException
     */
    public CasualEmployee removeCasualEmployee(int n) throws EmptyCollectionException {
        CasualEmployee cE = casualEmployee.removeAt(n);
        cE.removePatient();
        assignCasualEmployee();//reassign patient to a new casual employee in the rare instance there are more casual employees than patients
        return cE;
    }

    /**
     * Removes the full time employee at the selected index, assigns patients to
     * another casual employee.
     *
     * @param n the index of the casual employee from the head of the queue
     * @return casual employee at index n from head
     * @throws EmptyCollectionException
     */
    public FullTimeEmployee removeFullTimeEmployee(int n) throws EmptyCollectionException {
        FullTimeEmployee fTE = fullTimeEmployee.removeAt(n);
        return fTE;
    }

    /**
     * Removes the patient at the selected index, assigns patients bed to a
     * another patient.
     *
     * @param n index
     * @return patient at n index
     * @throws EmptyCollectionException
     */
    public Patient removePatient(int n) throws EmptyCollectionException {
        Patient p = patientStack.remove(n);
        p.removeBed();
        p.removeCasualEmployee();
        assignBedAndCasualEmployee(); //reasign bed and casual employee to a new patient 
        return p;
    }

    /**
     * Saves the list of beds to a file
     */
    public void saveBeds() {
        makeSavesFolder();
        new WriteFile<>(bedListInWorkingOrder).writeTo("saves/bedList.ser");
    }

    /**
     * Saves the list of casual employees to a file
     */
    public void saveCasualEmployee() {
        makeSavesFolder();
        new WriteFile<>(casualEmployee).writeTo("saves/casualEmployee.ser");
    }

    /**
     * Saves the list of patients to a file
     */
    public void savePatientStack() {
        makeSavesFolder();
        new WriteFile<>(patientStack).writeTo("saves/patientStack.ser");
    }

    /**
     * This method will sort the instance object patientStack according to
     * priority.
     */
    public final void sortPatientStack() {
        sort(patientStack);
    }

    /**
     * This method assigns casual employees to the patients with the highest
     * priority value
     *
     * @param PatientS The stack of patients to have casual employees assigned
     * @param CEList   The linked list of casual employees
     */
    private void AssignCasualE(ArrayStack<Patient> PatientS, LinkedQueue<CasualEmployee> CEList) {
        ArrayStack<Patient> reverseP = new ArrayStack<>();
        LinkedQueue<CasualEmployee> copyCE = CEList.copy();

        try {
            ArrayStack<Patient> copyP = PatientS.copy();
            while (!copyP.isEmpty()) {
                reverseP.push(copyP.pop());
            }

            //while (there are casual employee left) && ( there are patients left)
            while (!reverseP.isEmpty() && !copyCE.isEmpty()) {
                if (!copyCE.first().isAssignable()) {
                    copyCE.dequeue();
                }
                if (reverseP.peek().getCasualEmployee() != null) {
                    reverseP.pop();
                }
                if (!reverseP.isEmpty() && !copyCE.isEmpty()) {
                    if ((reverseP.peek().getCasualEmployee() == null) && (copyCE.first().isAssignable())) {
                        CasualEmployee cE = copyCE.dequeue();
                        Patient p = reverseP.pop();

                        p.setCasualEmployee(cE);
                        cE.setPatient(p);
                    }
                }
            }
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(CareFacility.class.getName()).log(Level.SEVERE, null, ex);
        }

//        //Old recursive algorithm
//        } catch (EmptyCollectionException ex) {
//            Logger.getLogger(CareFacility.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try { //TODO: fix this to work with get and remove methods
//            if (CEList == null) {
//                return;
//            }
//            if (CEList.isEmpty()) {
//                return;
//            }
//            if (!PatientS.isEmpty()) {
//                Patient p = PatientS.pop();                                 //pop temp element off of the stack
//                AssignCasualE(PatientS, CEList);                            //recursive call (ie reverse stack by pushing to call-stack)
//                //                                                          //recursion unwinds and starts returning to this line
//                if (p.getCasualEmployee() == null && !CEList.isEmpty()) {   //if Patient t does not have a bed and if there are beds available...
//                    p.setCasualEmployee(CEList.dequeue());                  //remove bed from bed linked list and give to Patient 
//                }
//                PatientS.push(p);                                           //put temp element back on to stack as recursion unwinds
//            }
//        } catch (EmptyCollectionException e) {
//            System.out.println(e + "Something went wrong in the AssignCasualE() method:\t");
//        }
    }

    /**
     * Goes through both the bedListInRepair and bedListInWorkingOrder class
     * variables and makes sure that they each only have beds in repair or beds
     * in working order in each data structure, respectively.
     */
    private void cleanBedLists() {
        try {
            for (int i = 1; i <= bedListInWorkingOrder.size(); i++) {
                if (!bedListInWorkingOrder.get(i).getInWorkingOrder()) {
                    bedListInRepair.addFirst(bedListInWorkingOrder.removeAt(i));
                }
            }
            for (int j = 1; j <= bedListInRepair.size(); j++) {
                if (bedListInRepair.get(j).getInWorkingOrder()) {
                    bedListInWorkingOrder.addFirst(bedListInRepair.removeAt(j));
                }
            }
        } catch (EmptyCollectionException e) {
            e.printStackTrace();
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
     * makes a folder called "saves" if one is not already in the folder from
     * which the program is being run.
     */
    private void makeSavesFolder() {
        File f = new File("saves");
        try {
            if (!f.mkdir()) {
                System.out.println("Error: No Directory Created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

}
