/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linked_Queues;

import Stacks.EmptyCollectionException;
import java.util.Iterator;

/**
 *
 * @author John Verwolf
 */
public class LinkedList<T> implements ListADT<T>, Iterable<T> {

    protected int count;
    protected LinearNode<T> head, tail;

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        count = 0;
        head = tail = null;
    }

    @Override
    public void addFirst() {
        addFirst(null);
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            head = new LinearNode<>(element);
            tail = head;
        } else {
            LinearNode<T> temp = head;              //hold the head Node from garbage collection by assigning temp pointer to it
            head = new LinearNode<>(element);       //head points to new node
            head.setNext(temp);                     //set the new node's next value to temp (previous head node)
        }
        count++;
    }

    @Override
    public void addLast() {
        addLast(null);
    }

    public void addLast(T element) {
        if (isEmpty()) {
            head = new LinearNode<>(element);
            tail = head;
        } else {
            tail.setNext(new LinearNode<>(element));        //attach new node to end of last node in list
            tail = tail.getNext();                          //update tail to point to new node
        }
        count++;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Error in removeFirst()");
        }
        LinearNode<T> temp = head;
        head = head.getNext();
        count--;
        return temp.getElement();
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        LinearNode<T> probe = head;
        LinearNode<T> returnNode = null;
        switch (count) {
            case 0:
                throw new EmptyCollectionException("Error in removeLast()");
            case 1:
                head = tail = null;
                return probe.getElement();
            default:
                //traverse list until probe refers to second last element
                while (probe.getNext().getNext() == null) {
                    probe = probe.getNext();
                }
                returnNode = tail;          //set pointer to tail node that is going to be removed
                tail = probe;               //update tail point to second last node
                probe.setNext(null);        //chop tail node off of the list
        }
        return returnNode.getElement();
    }

    /**
     * Removes the first instance of the specified element from this list and
     * returns a reference to it. Throws an EmptyListException if the list is
     * empty. Throws a NoSuchElementException if the specified element is not
     * found in the list.
     *
     * @param targetElement the element to be removed from the list
     * @return a reference to the removed element
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    //@Override
    public T remove(T targetElement) throws EmptyCollectionException,
            ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List");
        }
        boolean found = false;
        LinearNode<T> previous = null;
        LinearNode<T> current = head;
        while (current != null && !found) {
            if (targetElement.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        if (!found) {
            throw new ElementNotFoundException("List");
        }
        if (size() == 1) {
            head = tail = null;
        } else if (current.equals(head)) {
            head = current.getNext();
        } else if (current.equals(tail)) {
            tail = previous;
            tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }
        count--;
        return current.getElement();
    }

    /**
     * Check if list is empty
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Return the length of the list
     *
     * @return the length of the list
     */
    @Override
    public int size() {
        return count;
    }

    @Override
    public T first() {
        return head.getElement();
    }

    @Override
    public T last() {
        return tail.getElement();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}