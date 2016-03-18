package Linked_Queues;

import Stacks.EmptyCollectionException;

/**
 *
 * @author John Verwolf
 * @param <T> Type of element to be stored
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private int count;
    private LinearNode<T> front, rear;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        count = 0;
        front = rear = null;
    }

    /**
     * Adds the specified element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    @Override
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<>(element);
        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;
        count++;

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
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        T result = front.getElement();
        front = front.getNext();
        count--;
        if (isEmpty()) {
            rear = null;
        }
        return result;

    }

    /**
     * Check to see if the queue is empty
     *
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Show the first element in the queue without removing it
     *
     * @return the first element in the queue
     */
    @Override
    public T first() {
        return front.getElement();
    }

    /**
     * Show the last element in the queue without removing it
     *
     * @return the last element in the queue
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns a copy of the linked queue data structure. Although the list is
     * new, the elements inside the list are not deep copied and remain as
     * references to the original data elements
     */
    public LinkedQueue<T> copy() {
        return new LinkedQueue<>(front);
    }

    /*
     * private constructor to be used with the copy method. Builds a new linked
     * list copy. Although the list is new, the elements inside the list are not
     * deep copied and remain as references to the original data elements
     */
    private LinkedQueue(LinearNode<T> passedFront) {
        this.rear = this.front = new LinearNode<>();         //create new linked node that will start the list
        this.count = 1;

        LinearNode<T> probeForPassed = passedFront;

        while (probeForPassed.getNext() != null) {
            rear.setElement(probeForPassed.getElement());
            probeForPassed = probeForPassed.getNext();
            rear.setNext(new LinearNode<T>());
            rear = rear.getNext();
            count++;
        }
        rear.setElement(probeForPassed.getElement());
    }
}
