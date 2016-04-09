/*
 *
 */
package SearchAndSort;

import data_structures.ArrayStack;
import data_structures.EmptyCollectionException;
import java.util.Collections;

/**
 *
 * @author John Verwolf
 */
public class SortUtilities {

    /**
     * Class not to be instantiated
     */
    private SortUtilities() {
    }

    public static <T extends Comparable> ArrayStack<T> insertionSort(ArrayStack<T> inputStack) {
        ArrayStack<T> tempStack = inputStack.copy();   //pass a copy of the stack so that the original stack is not mutated        
        insSort(tempStack);
        return tempStack;
    }

    /**
     * recursive insertion sort method
     *
     * @param <T>   Type that extends Comparable
     * @param stack ArrayStack collection
     */
    private static <T extends Comparable> void insSort(ArrayStack<T> stack) {
        try {
            if (stack == null) {                //base case: null input
                return;
            } else if (stack.isEmpty()) {       //base case: when stack is empty 
                return;
            }
            T element = stack.pop();          //Peel every element off of stack and store in call-stack
            insSort(stack);                //recursive call
            insert(stack, element);           //sort top element of call stack back into stack.
        } catch (EmptyCollectionException e) {
            System.out.println("Something went wrong in Carefacility.sort(s):\t" + e);
        }
    }

    /**
     * This method works with insSort to recursively insert an element into a
     * stack with highest priority value at the bottom
     *
     * @param <T>     Type that extends Comparable
     * @param stack   ArrayStack collection
     * @param element Element to be inserted
     */
    private static <T extends Comparable> void insert(ArrayStack<T> stack, T element) {
        try {
            if (stack.isEmpty()) {      //if the stack is empty
                stack.push(element);    //push patient on stack
                return;
            }
            if (stack.peek().compareTo(element) < 0) {  //check if priority of top element on stack is lower
                T temp = stack.pop();                   //pop top element and store in a temp variable
                insert(stack, element);                 //recursive call. (Do it all again with one less element on the call-stack).
                stack.push(temp);                       //put topElement back on to stack as recursion unwinds
            } else {                                    //insert patient when priority is not larger than the top stack element
                stack.push(element);                    //insert patient in proper place on stack
            }
        } catch (EmptyCollectionException e) {
            System.out.println("Something went wrong in Carefacility.insert(s,p):\t" + e);
        }
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
    public static <T extends Comparable> ArrayStack<T> selectionSort(ArrayStack<T> inputStack) {
        T[] sortArray = makeArray(inputStack.copy());   //pass a copy of the stack so that the original stack is not mutated

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
     * makes an array out of a copy of the stack. The top of the stack goes into
     * the beginning of the array.
     * <p>
     * Protected for use elsewhere in this package.
     *
     * @param <T>        A type that implements Comparable
     * @param inputStack An ArrayStack of Comparable Objects
     * @return Array of elements from the original stack
     */
    protected static <T extends Comparable> T[] makeArray(ArrayStack<T> inputStack) {
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
