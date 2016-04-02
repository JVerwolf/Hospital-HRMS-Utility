/*
 *
 */
package SearchAndSort;

import Stacks.ArrayStack;
import Stacks.EmptyCollectionException;
import java.util.Collections;

/**
 *
 * @author John Verwolf
 */
public class SelectionSort {

    /**
     * Class not to be instantiated
     */
    private SelectionSort() {
    }

    /**
     * This method sorts an ArrayStack of Comparable objects. A reference to the
     * sorted array stack is returned, and the original stack is unmodified.
     *
     * @param <T>        a type that implements Comparable
     * @param inputStack and ArrayStack of Comparable Objects
     * @return A reference to the sorted array stack is returned (the original
     *         stack is unmodified)
     */
    public static <T extends Comparable> ArrayStack<T> SortPatients(ArrayStack<T> inputStack) {
        ArrayStack<T> tempStack = inputStack.copy();
        T[] sortArray = makeArray(tempStack);   //pass a copy of the stack so that the original stack is not mutated

        int minIndex;
        for (int i = 0; i < sortArray.length - 1; i++) {
            minIndex = min(sortArray, i, sortArray.length - 1);
            if (minIndex != i) {
                swap(sortArray, i, minIndex);
            }
        }
        return makestack(sortArray);
    }

    /**
     * makes an array out of a copy of the stack
     *
     * @return Array of elements from the original stack
     */
    private static <T extends Comparable> T[] makeArray(ArrayStack<T> inputStack) {
        T[] returnArray = (T[]) (new Comparable[inputStack.size()]);
        try {
            int i = 0;
            while (!inputStack.isEmpty()) {
                returnArray[i] = inputStack.pop();
                i++;
            }
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
        return returnArray;
    }

    /**
     * Generates a stack from the passed array. Elements of highest value go on
     * the bottom of the stack.
     *
     * @param <T>         type that implements Comparable
     * @param sortedArray A sorted array (from lowest to highest) of elements of
     *                    type T
     * @return return a stack with elements of highest value on the bottom
     */
    private static <T extends Comparable> ArrayStack<T> makestack(T[] sortedArray) {
        ArrayStack<T> sortedStack = new ArrayStack<>();

        /**
         * Push the elements of the array into the stack in reverse order.
         * Elements of highest value go on the bottom of the stack.
         */
        for (int i = sortedArray.length - 1; i >= 0; i--) {
            sortedStack.push(sortedArray[i]);
        }
        return sortedStack;
    }

    /**
     * Finds the minimum element between to specified indexes of an array
     *
     * @param <T>        Type that implements Comparable
     * @param inputArray An array of elements of type Comparable
     * @param i          The starting index
     * @param i0         The ending index
     * @return The smallest index between the two specified input indices.
     */
    private static <T extends Comparable> int min(T[] inputArray, int i, int i0) {
        int smallestIndex = i;      //set default smallest index to i
        i++;                        //increment i so that we don't compare index to itself
        while (i <= i0) {           //loop through range specified by index params
            //if object in index is smaller than specified object...
            if (inputArray[i].compareTo(inputArray[smallestIndex]) < 0) {
                smallestIndex = i;  //set lowIndex to that of new smaller object
            }
            i++;
        }
        return smallestIndex;
    }

    /**
     * Swaps objects at specified index in array
     *
     * @param <T> Type that implements Comparable
     * @param a   Array of objects that implement comparable
     * @param i1  index of object to be switched
     * @param i2  second index of object to be switched
     */
    private static <T extends Comparable> void swap(T[] a, int i1, int i2) {
        T temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
}
