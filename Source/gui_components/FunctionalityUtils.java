package gui_components;

import data_structures.ArrayStack;
import data_structures.EmptyCollectionException;
import data_structures.LinkedList;
import data_structures.LinkedQueue;
import hospital_components.Bed;
import hospital_components.CareFacility;
import hospital_components.CasualEmployee;
import hospital_components.Patient;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author John Verwolf
 */
public class FunctionalityUtils {

    static void deleteBed(CareFacility cF, int nW, int nIR) {
        try {
            if (nW >= 0) {//if index is from the list of beds in working order 
                cF.removeBedInWorkingOrder(nW);
            } else if (nIR >= 0) {
                cF.removeBedInRepair(nIR);
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
        
    }

    static void modifyCasualEmployees(CareFacility cF, int index, JTextField nameTF, JSpinner casualPay, JCheckBox available) {
        String name = nameTF.getText();
        double pay = (double) casualPay.getValue();
        try {
            if (index >= 0) {
                CasualEmployee cE = cF.getCasualEmployee(index);
                if (!name.equals("")) {
                    cE.setName(name);
                }
                cE.setPayRate(pay);
                cE.setAvailability(available.isSelected());
                cF.assignCasualEmployee();
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    protected static void modifyBeds(CareFacility cF, int nW, int nIR, JTextField nameTF, JTextField locationTF, JCheckBox isAvailable) {
        String name = nameTF.getText();
        String location = locationTF.getText();

        try {
            if (nW >= 0) {
                Bed temp = cF.getAvailableBed(nW);
                if (!name.equals("")) {
                    temp.setName(name);
                }
                if (!location.equals("")) {
                    temp.setLocation(location);
                }
                if (isAvailable.isSelected()) {
                    temp.setInWorkingOrder(true);
                } else {
                    temp.setInWorkingOrder(false);
                }
            } else if (nIR >= 0) {
                Bed temp2 = cF.getUnavailableBed(nIR);
                if (!name.equals("")) {
                    temp2.setName(name);
                }
                if (!location.equals("")) {
                    temp2.setLocation(location);
                }
                if (isAvailable.isSelected()) {
                    temp2.setInWorkingOrder(true);
                } else {
                    temp2.setInWorkingOrder(false);
                }
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
        cF.assignBeds();
    }

    protected static void modifyPatients(CareFacility cF, int pI, JTextField nameTF, JSpinner patientPriority) {
        String name = nameTF.getText();
        int priority = (int) patientPriority.getValue();
        try {
            if (pI >= 0) {
                Patient patient = cF.getPatient(pI);
                if (!name.equals("")) {
                    patient.setName(name);
                }
                patient.setPriority(priority);
                cF.sortPatientStack();
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    protected static void updateBedDisplay(CareFacility CF, JList bedListA, JList bedListU) {
        /**
         * Get a copy of the patientStack instance variable of CF CareFacility
         * object.
         */
        LinkedList<Bed> workingOrder = CF.getCopybedListInWorkingOrder();
        LinkedList<Bed> inRepair = CF.getCopybedListUnAvailable();

        //clear list
        DefaultListModel listModelA = (DefaultListModel) bedListA.getModel();
        DefaultListModel listModelU = (DefaultListModel) bedListU.getModel();

        //Make listModels
        listModelA.removeAllElements();
        listModelU.removeAllElements();

        try {
            while (!workingOrder.isEmpty()) {
                Bed tempBed = workingOrder.removeFirst();
                listModelA.addElement("Name: " + tempBed.getName()
                        + ",  Location: " + tempBed.getLocation()
                        + ",  Usable");
            }
            while (!inRepair.isEmpty()) {
                Bed tempBed = inRepair.removeFirst();
                listModelU.addElement("Name: " + tempBed.getName()
                        + ",  Location: " + tempBed.getLocation()
                        + ",   In Repair");
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }

    }

    protected static void updateCasualDisplay(CareFacility CF, JList<String> cEList) {
        /**
         * Get a copy of the patientStack instance variable of CF CareFacility
         * object.
         */
        LinkedQueue<CasualEmployee> cCopy = CF.getCopyCasualEmployeeQueue();

        //Make listModels
        DefaultListModel listModel = (DefaultListModel) cEList.getModel();

        //clear list
        listModel.removeAllElements();

        try {
            while (!cCopy.isEmpty()) {
                CasualEmployee tempCE = cCopy.dequeue();

                String patient = "no Patient";
                if (tempCE.getPatient() != null) {
                    patient = tempCE.getPatient().getName();
                }
                String available = "No";
                if (tempCE.getAvailability()) {
                    available = "Yes";
                }
                listModel.addElement(tempCE.getName() + ",  Pay:$"
                        + tempCE.getPayRate() + "/hr  Assigned To: " + patient
                        + ",  Available: " + available);
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    protected static void updatePatientDisplay(CareFacility CF, JList patientList) {
        /**
         * Get a copy of the patientStack instance variable of CF CareFacility
         * object.
         */
        ArrayStack<Patient> pStack = CF.getCopyPatientStack();

        //clear list
        DefaultListModel listModelA = (DefaultListModel) patientList.getModel();

        //Make listModels
        listModelA.removeAllElements();

        try {
            while (!pStack.isEmpty()) {
                Patient tempP = pStack.pop();

                String bed = "<font color=red>no bed</font>";
                if (tempP.getBed() != null) {
                    bed = "<font color=green>" + tempP.getBed().getName() + "</font>";
                }
                String employee = "<font color=red>no employee</font>";
                if (tempP.getCasualEmployee() != null) {
                    employee = "<font color=green>" + tempP.getCasualEmployee().getName() + "</font>";
                }
                String html = "<html><pre font face=\"verdana\"><b>Name:</b> " + tempP.getName() + "\t<b>Priority:</b> "
                        + tempP.getPriority() + "\t<b>Bed:</b> " + bed
                        + "\t<b>Assigned:</b> " + employee + "</pre></html>";
                listModelA.addElement(html);
//                listModelA.addElement("Name: " + tempP.getName() + ",  Priority: "
//                        + tempP.getPriority() + ",  Bed: " + bed
//                        + ",  Assigned: " + employee);
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    /**
     * prints a report to the report text area
     *
     * @param CF     care facility object
     * @param report report text area
     */
    protected static void updateReport(CareFacility CF, JTextArea report) {
        //this method assigns beds to patients
        CF.assignBedAndCasualEmployee();

        /**
         * Get a copy of the patientStack instance variable of CF CareFacility
         * object.
         */
        ArrayStack<Patient> tempPatientStack = CF.getCopyPatientStack();

        report.setText(null);//clear text area
        try {
            report.append("\nPATIENT NAME:\tPATIENT \tBED:\tCASUAL EMPLOYEE:\n\t\tPRIORITY:");
            while (!tempPatientStack.isEmpty()) {               //loop while there are still elements in the patientStack
                Patient p = tempPatientStack.pop();             //pop a patient, assign to temp variable

                String bed = "";                                //instantiate bed variable to default value "NO BED"
                if (p.getBed() != null) {                       //If the current patient (in the temp variable) has a bed...
                    bed = p.getBed().getName();                 //change bed variable to the name of the bed
                }
                String CEmployee = "";
                if (p.getCasualEmployee() != null) {                       //If the current patient (in the temp variable) has a bed...
                    CEmployee = p.getCasualEmployee().getName();        //change bed variable to the name of the bed
                }

                String name = p.getName();              //instantiate name varaible to hold name of patient

                report.append(" " + name + "\t\t" + p.getPriority() + "\t\t" + bed + "\t" + CEmployee);  //print out properties of current patient in temp vraible
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }
}
