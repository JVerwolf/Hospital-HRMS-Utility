/*
 *
 */
package data_structures;

import io_utils.DataStructure;
import java.io.Serializable;

/**
 *
 * @author John Verwolf
 * @param <T> Type of element stored in the list
 */
public class LinkedQueue<T> implements QueueADT<T>, DataStructure<T>, Serializable {

    LinkedList<T> list;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        list = new LinkedList<>();
    }

    /*
     * private constructor to be used with the copy method. Builds a new linked
     * list copy. Although the list is new, the elements inside the list are not
     * deep copied and remain as references to the original data elements
     */
    private LinkedQueue(LinkedList<T> list) {
        this.list = list.copy();
    }

    /**
     * Adds the specified element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    @Override
    public void enqueue(T element) {
        list.addLast(element);
    }

    /**
     * Removes the element at the front of this queue and returns a reference to
     * it. Throws an EmptyCollectionException if the queue is empty.
     *
     * @return the element at the front of this queue
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        return list.removeFirst();
    }

    /**
     * gets element at specified index without removing it
     *
     * @param n index
     * @return element
     * @throws EmptyCollectionException
     */
    public T get(int n) throws EmptyCollectionException {
        return list.get(n);
    }

    /**
     * removes and returns element at specified index
     *
     * @param n index
     * @return element
     * @throws EmptyCollectionException
     */
    public T removeAt(int n) throws EmptyCollectionException {
        return list.removeAt(n);
    }

    /**
     * Check to see if the queue is empty
     *
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Show the first element in the queue without removing it
     *
     * @return the first element in the queue
     */
    @Override
    public T first() {
        return list.first();
    }

    /**
     * Show the last element in the queue without removing it
     *
     * @return the last element in the queue
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns a copy of the linked queue data structure. Although the list is
     * new, the elements inside the list are not deep copied and remain as
     * references to the original data elements
     *
     * @return copy of the linked queue instance
     */
    public LinkedQueue<T> copy() {
        return new LinkedQueue<>(list);
    }

}
