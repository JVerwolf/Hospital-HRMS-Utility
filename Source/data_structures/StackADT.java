package data_structures;

import data_structures.EmptyCollectionException;

/**
 * This is an interface for a stack.
 *
 * @author John Verwolf
 * @param <T>
 */
public interface StackADT<T> {

    /**
     * Removes the element at the top of this stack and returns a reference to
     * it. Throws an EmptyCollectionException if the stack is empty.
     *
     * @return T element removed from top of stack
     * @throws EmptyCollectionException if a pop is attempted on empty stack
     */
    public T pop() throws EmptyCollectionException;

    /**
     * Returns top element in Stack, removes element from stack
     *
     * @return top element in Stack
     * @throws EmptyCollectionException
     */
    public T peek() throws EmptyCollectionException;

    /**
     * Adds the specified element to the top of this stack, expanding the
     * capacity of the stack array if necessary.
     *
     * @param element generic element to be pushed onto stack
     */
    public void push(T element);

    /**
     * Check if stack is empty
     *
     * @return true if this stack contains no elements
     */
    public Boolean isEmpty();

    /**
     * find the current size of the stack
     *
     * @return length of stack array
     */
    public int size();

    /**
     * returns string representation of the object
     *
     * @return string representation of the object
     */
    @Override
    public String toString();
}
