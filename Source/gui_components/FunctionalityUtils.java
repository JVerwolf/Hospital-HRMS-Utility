package gui_components;

import data_structures.ArrayStack;
import data_structures.EmptyCollectionException;
import data_structures.LinkedList;
import hospital_components.Bed;
import hospital_components.CareFacility;
import hospital_components.Patient;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author John Verwolf
 */
public class FunctionalityUtils {

    /**
     * prints a report to the report text area
     *
     * @param CF     care facility object
     * @param report report text area
     */
    public static void updateReport(CareFacility CF, JTextArea report) {
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

//    private static String[] convertBedListToArray(CareFacility CF) {
//        /**
//         * Get a copy of the patientStack instance variable of CF CareFacility
//         * object.
//         */
//        LinkedList<Bed> availableBeds = CF.getCopybedListAvailable();
//        LinkedList<Bed> unAvailableBeds = CF.getCopybedListUnAvailable();
//
//    }
    public static void updateBedDisplay(CareFacility CF, javax.swing.JList bedListA, javax.swing.JList bedListU) {
        /**
         * Get a copy of the patientStack instance variable of CF CareFacility
         * object.
         */
        LinkedList<Bed> availableBeds = CF.getCopybedListAvailable();
        LinkedList<Bed> unAvailableBeds = CF.getCopybedListUnAvailable();

        //clear list
        DefaultListModel listModelA = (DefaultListModel) bedListA.getModel();
        DefaultListModel listModelU = (DefaultListModel) bedListU.getModel();

        //Make listModels
        listModelA.removeAllElements();
        listModelU.removeAllElements();

        try {
            int count = 1;
            while (!availableBeds.isEmpty()) {
                Bed tempBed = availableBeds.removeFirst();
                listModelA.addElement(count + "  " + tempBed.getName()
                        + "  " + tempBed.getLocation()
                        + " Available");
                count++;
            }
            while (!unAvailableBeds.isEmpty()) {
                Bed tempBed = unAvailableBeds.removeFirst();
                listModelU.addElement(count + "  " + tempBed.getName()
                        + "  " + tempBed.getLocation()
                        + "  Unavailable");
                count++;
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }

    }

//    public static void updateBedDisplay(CareFacility CF, JTextArea bedDisplay) {
//
//        /**
//         * Get a copy of the patientStack instance variable of CF CareFacility
//         * object.
//         */
//        LinkedList<Bed> availableBeds = CF.getCopybedListAvailable();
//        LinkedList<Bed> unAvailableBeds = CF.getCopybedListUnAvailable();
//
//        bedDisplay.setText(null);//clear text area
//
//        bedDisplay.append("BED NAME:\tlOCATION:\t AVAILABLE:");
//        try {
//            int count = 1;
//            while (!availableBeds.isEmpty()) {
//                Bed tempBed = availableBeds.removeLast();
//                bedDisplay.append("\n" + count + "\t" + tempBed.getName()
//                        + "\t" + tempBed.getLocation()
//                        + "\tYes");
//                count++;
//            }
//            while (!unAvailableBeds.isEmpty()) {
//                Bed tempBed = unAvailableBeds.removeLast();
//                bedDisplay.append("\n" + count + "\t" + tempBed.getName()
//                        + "\t" + tempBed.getLocation()
//                        + "\tNo");
//                count++;
//            }
//        } catch (EmptyCollectionException e) {
//            System.out.println(e);
//        }
//    }
    static void modifyBeds(CareFacility cF, int nA, int nU, JTextField nameTF, JTextField locationTF, JCheckBox isAvailable) {
        String name = nameTF.getText();
        String location = locationTF.getText();
        
        try {
           
            if (nA >= 0) {
                Bed temp = cF.removeAvailableBed(nA);
                if (!name.equals("")) {
                    temp.setName(name);
                }
                if (!location.equals("")) {
                    temp.setLocation(location);
                }
                if (isAvailable.isSelected()) {
                    temp.setUsable(true);
                }else{
                    temp.setUsable(false);
                }
                cF.addBed(temp);
            } else if(nU >= 0) {
                Bed temp2 = cF.removeUnavailableBed(nU);
                if (!name.equals("")) {
                    temp2.setName(name);
                }
                if (!location.equals("")) {
                    temp2.setLocation(location);
                }
                if (isAvailable.isSelected()) {
                    temp2.setUsable(true);                    
                }else{
                    temp2.setUsable(false);
                }
                cF.addBed(temp2);
            }            
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }
}
