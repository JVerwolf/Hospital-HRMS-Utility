/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linked_Queues;

/**
 *
 * @author John Verwolf
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
     */
    public T dequeue();

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
    public String toString();
}
