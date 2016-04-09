package search_and_sort_utils;

import data_structures.ElementNotFoundException;
import data_structures.ArrayStack;
import data_structures.EmptyCollectionException;
import hospital_components.Patient;

/**
 *
 * @author John Verwolf
 */
public class SearchUtilities {

    /**
     * not to be instantiated
     */
    private SearchUtilities() {
    }

    /**
     * Searches for a patient name in an ArrayStack of Patients
     *
     * @param nameToFind The name to find
     * @param inputStack The ArrayStackStack to look in
     * @return index of the name
     * @throws ElementNotFoundException if no name is found
     */
    public static int linearSearchPatient(String nameToFind, ArrayStack<Patient> inputStack) throws ElementNotFoundException {
        Patient[] arrayForSearch = makeArray(inputStack.copy());   //pass a copy of the stack so that the original stack is not mutated               

        int locationFromTop = -1;                   //default setting remains unchanged if no match is found
        int i = 0;
        for (Patient e : arrayForSearch) {
            if (e.getName().equals(nameToFind)) {    //check for name matching input
                locationFromTop = i;
                break;
            }
            i++;
        }

        if (locationFromTop == -1) {
            throw new ElementNotFoundException();
        }
        return locationFromTop;
    }

    public static Patient binarySearch(int target, ArrayStack<Patient> inputStack) throws ElementNotFoundException {
        //TODO: call sort on stack

        Patient[] a = new Patient[inputStack.size()];//make array
        try {
            int i = 0;
            while (!inputStack.isEmpty()) {
                a[i] = inputStack.pop();
                i++;
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }

        int first = 0;
        int last = a.length - 1;
        int result = -1;                    //holds location of result,default value -1
        while (first <= last) {             // do the search
            int mid = (first + last) / 2;   // compute midpoint
            if (a[mid].getPriority() == target) {
                result = mid; // found target
                break;
            } else if (a[mid].getPriority() > target) {
                last = mid - 1; // search left half
            } else {
                first = mid + 1; // search right half
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException();
        }
        return a[result];
    }

    private static Patient[] makeArray(ArrayStack<Patient> inputStack) {
        Patient[] a = new Patient[inputStack.size()];//make array
        try {
            int i = 0;
            while (!inputStack.isEmpty()) {
                a[i] = inputStack.pop();
                i++;
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
        return a;
    }
}
