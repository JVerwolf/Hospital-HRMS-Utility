package data_structures;

import data_structures.EmptyCollectionException;

/**
 * This is a queue data structure obeying the first in first out rule
 *
 * @author John Verwolf
 * @param <T> The generic type
 */
public interface QueueADT<T> {

    /**
     * Adds an object to the rear of the queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    public void enqueue(T element);

    /**
     * Removes and returns the object at the front of this queue.
     *
     * @return the element at the front of this queue
     * @throws data_structures.EmptyCollectionException
     */
    public T dequeue() throws EmptyCollectionException;

    /**
     * Returns without removing the object at the front of this queue.
     *
     * @return the first element in this queue
     */
    public T first();

    /**
     * Returns true if this queue contains no object.
     *
     * @return true if this queue is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of object in this queue.
     *
     * @return the integer representation of the size of this queue
     */
    public int size();

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of this queue
     */
    @Override
    public String toString();
}
