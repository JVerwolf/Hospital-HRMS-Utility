/*
 *
 */
package SearchAndSort;

import Stacks.ArrayStack;
import Stacks.CareFacility;
import Stacks.EmptyCollectionException;
import Stacks.Patient;
import static java.lang.Math.min;

/**
 *
 * @author John Verwolf
 */
public class SelectionSort {

    private CareFacility CF;
    private Patient[] patientArray;

    public SelectionSort(CareFacility CF) {
        this.CF = CF;
    }

    private void Sort() {
        patientArray = makeArray();
        int minIndex = 0;
        for (int i = 0; i < patientArray.length - 1; i++) {
            minIndex = min(patientArray, i, patientArray.length-1);
            if (minIndex != i) {
                swap(patientArray, i, minIndex);
            }
        }
    }
    /**
     * makes an array out of a copy of the patient stack
     * @return 
     */
    private Patient[] makeArray() {
        ArrayStack<Patient> tempPatientStack = CF.getCopyPatientStack();
        try {
            int i = 0;
            while (!tempPatientStack.isEmpty()) {              
                patientArray[i]=tempPatientStack.pop();
                i++;
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    return patientArray;
    }

    private int min(Patient[] patientArray, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void swap(Patient[] a, int i, int minIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
