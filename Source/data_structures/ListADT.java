package data_structures;

import data_structures.EmptyCollectionException;
import java.util.Iterator;

/**
 * @author John Verwolf
 * 
 * @param <T> generic type
 */
public interface ListADT<T> {

    /**
     * Add an element at the beginning of a list
     */
    public void addFirst();

    /**
     * Add an element at the end of a list
     */
    public void addLast();

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws data_structures.EmptyCollectionException
     */
    public T removeFirst() throws EmptyCollectionException;

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws data_structures.EmptyCollectionException
     */
    public T removeLast() throws EmptyCollectionException;

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     */
    //public T remove(T element) throws EmptyCollectionException, ElementNotFoundException;
    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    public T first();

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    public T last();

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    public int size();

     /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString();
}
