package gui_components;

import data_structures.ArrayStack;
import data_structures.EmptyCollectionException;
import data_structures.LinkedList;
import data_structures.LinkedQueue;
import hospital_components.Bed;
import hospital_components.CareFacility;
import hospital_components.CasualEmployee;
import hospital_components.FullTimeEmployee;
import hospital_components.Patient;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

    protected static void deletePatient(CareFacility cF, int nP) {
        try {
            if (nP > 0) {
                cF.removePatient(nP);
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    protected static void modifyCasualEmployees(CareFacility cF, int index, JTextField nameTF, JSpinner casualPay, JCheckBox available) {
        String name = nameTF.getText();
        double pay = (double) casualPay.getValue();
        try {
            if (index > 0) {
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

    protected static void modifyFullTimeEmployees(CareFacility cF, int index, JTextField nameTF, JSpinner jSpinnerPay) {
        String name = nameTF.getText();
        double pay = (double) jSpinnerPay.getValue();
        try {
            if (index > 0) {
                FullTimeEmployee fTE = cF.getFullTimeEmployee(index);
                if (!name.equals("")) {
                    fTE.setName(name);
                }
                fTE.setGrossPay(pay);
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    protected static void updateFullTimeDisplay(CareFacility CF, JList<String> fTEList) {
        LinkedQueue<FullTimeEmployee> fTECopy = CF.getCopyFullTimeEmployeeQueue();

        //Make listModels
        DefaultListModel listModel = (DefaultListModel) fTEList.getModel();

        //clear list
        listModel.removeAllElements();

        try {
            while (!fTECopy.isEmpty()) {
                FullTimeEmployee tempFTE = fTECopy.dequeue();

                listModel.addElement("<html><pre font face=\"verdana\">Name:&nbsp;<b>" + tempFTE.getName() + "\t</b>Salary: $<b>"
                        + tempFTE.getGrossPay()+ "</b></pre></html>");
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    protected static void deleteBed(CareFacility cF, int nW, int nIR) {
        try {
            if (nW > 0) {//if index is from the list of beds in working order
                cF.removeBedInWorkingOrder(nW);
            } else if (nIR > 0) {
                cF.removeBedInRepair(nIR);
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }

    }

    protected static void deleteCasualEmployee(CareFacility cF, int nCE) {
        try {
            if (nCE > 0) {
                cF.removeCasualEmployee(nCE);
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    protected static void deleteFullTimeEmployee(CareFacility cF, int fTE) {
        try {
            if (fTE > 0) {
                cF.removeFullTimeEmployee(fTE);
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    /**
     * This helper function works with the GUI to modify a bed at a given index
     * in the Care Facility
     *
     * @param cF          the CareFacility
     * @param nW          index in the list of Working beds
     * @param nIR         index in the list of In Repair beds
     * @param nameTF      text field holding the name
     * @param locationTF  text field holding the location
     * @param isAvailable specifies availability
     */
    protected static void modifyBeds(CareFacility cF, int nW, int nIR, JTextField nameTF, JTextField locationTF, JCheckBox isAvailable) {
        String name = nameTF.getText();
        String location = locationTF.getText();

        try {
            if (nW > 0) {
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
            } else if (nIR > 0) {
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

    /**
     * This helper function works with the GUI to modify a Patient at a given
     * index in the Care Facility
     *
     * @param cF              care facility object
     * @param pI              patient's index
     * @param nameTF          contains name value
     * @param patientPriority contains priority
     */
    protected static void modifyPatients(CareFacility cF, int pI, JTextField nameTF, JSpinner patientPriority) {
        String name = nameTF.getText();
        int priority = (int) patientPriority.getValue();
        try {
            if (pI > 0) {
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

    /**
     * This helper function works with the GUI to populate the jlists of beds
     *
     * @param cF       care facility object
     * @param bedListA list of Working beds
     * @param bedListU list of broken beds
     */
    protected static void updateBedDisplay(CareFacility cF, JList bedListA, JList bedListU) {
        /**
         * Get a copy of the patientStack instance variable of CF CareFacility
         * object.
         */
        LinkedList<Bed> workingOrder = cF.getCopybedListInWorkingOrder();
        LinkedList<Bed> inRepair = cF.getCopyBedListInRepair();

        //clear list
        DefaultListModel listModelA = (DefaultListModel) bedListA.getModel();
        DefaultListModel listModelU = (DefaultListModel) bedListU.getModel();

        //Make listModels
        listModelA.removeAllElements();
        listModelU.removeAllElements();

        try {
            while (!workingOrder.isEmpty()) {
                Bed tempBed = workingOrder.removeFirst();

                String html = "<html><pre font face=\"verdana\">Name:<b> "
                        + tempBed.getName() + "\t</b>Location: <b>"
                        + tempBed.getLocation() + "\t<font color=\"#003399\">Usable</b></font></b></pre></html>";
                listModelA.addElement(html);

            }
            while (!inRepair.isEmpty()) {
                Bed tempBed = inRepair.removeFirst();
                String html = "<html><pre font face=\"verdana\">Name:<b> "
                        + tempBed.getName() + "\t</b>Location: <b>"
                        + tempBed.getLocation() + "\t<font color=\"#800000\">In Repair</b></font></pre></html>";

                listModelU.addElement(html);

            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }

    }

    /**
     *  * This helper function works with the GUI to populate the jlists of
     * casual employees
     *
     * @param CF     care facility object
     * @param cEList jList of casual employees to populate
     */
    protected static void updateCasualDisplay(CareFacility CF, JList<String> cEList) {
        LinkedQueue<CasualEmployee> cCopy = CF.getCopyCasualEmployeeQueue();

        //Make listModels
        DefaultListModel listModel = (DefaultListModel) cEList.getModel();

        //clear list
        listModel.removeAllElements();

        try {
            while (!cCopy.isEmpty()) {
                CasualEmployee tempCE = cCopy.dequeue();

                String patient = "<font color=\"#800000\">no patient</font>";
                if (tempCE.getPatient() != null) {
                    patient = "<font color=\"#003399\">" + tempCE.getPatient().getName() + "</font>";
                }
                String available = "<font color=\"#800000\">No</font>";;
                if (tempCE.getAvailability()) {
                    available = "<font color=green>Yes</font>";
                }
                
                //to pretent getting 10+ decimal figures in double rounding
                NumberFormat formatter = new DecimalFormat("#0.00");
                System.out.println(formatter.format(4.0));
               
                String html = "<html><pre font face=\"verdana\">Name:<b>&nbsp;" + tempCE.getName() + "&nbsp;\t</b>Pay: <b>$"
                        + formatter.format(tempCE.getPayRate()) + "\t</b>/hr  Assigned To: <b>" + patient
                        + "\t</b>Available: <b>" + available + "</b></pre></html>";
                listModel.addElement(html);
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

    /**
     *  * This helper function works with the GUI to populate the jlists of
     * patients
     *
     * @param CF          care facility object
     * @param patientList jList of patients to populate
     */
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

                String bed = "<font color=\"#800000\">no bed</font>";
                if (tempP.getBed() != null) {
                    bed = "<font color=\"#006600\">" + tempP.getBed().getName() + "</font>";
                }
                String employee = "<font color=\"#800000\">no employee</font>";
                if (tempP.getCasualEmployee() != null) {
                    employee = "<font color=green>" + tempP.getCasualEmployee().getName() + "</font>";
                }

                String html = "<html><pre font face=\"verdana\">Name:&nbsp;<b>" + tempP.getName() + "\t</b>Priority:&nbsp;<b>"
                        + tempP.getPriority() + "\t</b>Bed:&nbsp;<b>" + bed
                        + "\t</b>Assigned:&nbsp;<b>" + employee + "</b></pre></html>";

                listModelA.addElement(html);

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

        report.setText(null);//clear text area
        try {
            report.append("\nFACILITY NAME: " + CF.getFacilityName());

            report.append("\n\n\nLIST OF SALARIED STAFF:");
            report.append("\n   NAME:\tSALARY:");
            LinkedQueue<FullTimeEmployee> fTECopy = CF.getCopyFullTimeEmployeeQueue();
            while (!fTECopy.isEmpty()) {
                FullTimeEmployee fTE = fTECopy.dequeue();

                String name = "";
                if (fTE.getName() != null) {
                    name = fTE.getName();
                }

                report.append("\n   " + name + "\t" + fTE.getGrossPay());
            }

            report.append("\n\n\nLIST OF CASUAL STAFF:");
            report.append("\n   NAME:\tHOURLY RATE:\tPATIENT:");
            LinkedQueue<CasualEmployee> cEQ = CF.getCopyCasualEmployeeQueue();
            while (!cEQ.isEmpty()) {
                CasualEmployee cE = cEQ.dequeue();

                String name = "";
                if (cE.getName() != null) {
                    name = cE.getName();
                }

                double pay = cE.getPayRate();

                String patient = "";
                if (cE.getPatient() != null) {
                    patient = cE.getPatient().getName();
                }

                report.append("\n   " + name + "\t" + pay + "\t" + patient);
            }

            report.append("\n\n\nLIST OF BEDS IN WORKING ORDER:");
            report.append("\n   NAME:\tLOCATION:\tPATIENT:");
            LinkedList<Bed> BedList = CF.getCopybedListInWorkingOrder();
            while (!BedList.isEmpty()) {
                Bed b = BedList.removeLast();

                String location = "";
                if (b.getLocation() != null) {
                    location = b.getLocation();
                }

                String patient = "";
                if (b.getLocation() != null) {
                    patient = b.getLocation();
                }

                String name = "";
                if (b.getName() != null) {
                    name = b.getName();
                }

                report.append("\n   " + name + "\t" + location + "\t" + patient);
            }

            report.append("\n\n\nLIST OF BEDS IN REPAIR:");
            report.append("\n   NAME:\tLOCATION:");
            LinkedList<Bed> BedList2 = CF.getCopyBedListInRepair();
            while (!BedList2.isEmpty()) {
                Bed b = BedList2.removeLast();

                String location = "";
                if (b.getLocation() != null) {
                    location = b.getLocation();
                }

                String name = "";
                if (b.getName() != null) {
                    name = b.getName();
                }

                report.append("\n   " + name + "\t" + location);
            }

            ArrayStack<Patient> tempPatientStack = CF.getCopyPatientStack();
            report.append("\n\n\nPATEINT OVERVIEW:");
            report.append("\n   PATIENT NAME:\tPATIENT \tBED:\tCASUAL EMPLOYEE:\n\t\tPRIORITY:");
            while (!tempPatientStack.isEmpty()) {               //loop while there are still elements in the patientStack
                Patient p = tempPatientStack.pop();             //pop a patient, assign to temp variable

                String bed = "No Bed";                                //instantiate bed variable to default value "NO BED"
                if (p.getBed() != null) {                       //If the current patient (in the temp variable) has a bed...
                    bed = p.getBed().getName();                 //change bed variable to the name of the bed
                }
                String CEmployee = "No Casual Employee";
                if (p.getCasualEmployee() != null) {                       //If the current patient (in the temp variable) has a bed...
                    CEmployee = p.getCasualEmployee().getName();        //change bed variable to the name of the bed
                }

                String name = p.getName();              //instantiate name varaible to hold name of patient

                report.append("\n   " + name + "\t\t" + p.getPriority() + "\t" + bed + "\t" + CEmployee);  //print out properties of current patient in temp vraible
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }
}
