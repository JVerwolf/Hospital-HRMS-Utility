package data_structures;

import java.io.Serializable;

/**
 *
 * @author John Verwolf
 * @param <T> The Generic type
 */
public class LinearNode<T> implements Serializable {

    /**
     * The reference to the next node in the linked list
     */
    private LinearNode<T> next;

    /**
     * element stored at this node
     */
    private T element;

    /**
     * Creates an empty node.
     */
    public LinearNode() {
        this.next = null;
        this.element = null;
    }

    /**
     * Creates a node storing the specified element.
     *
     * @param elem element to be stored
     */
    public LinearNode(T elem) {
        this.next = null;
        this.element = elem;
    }

    /**
     * Returns the node that follows this one.
     *
     * @return LinearNode T reference to next node
     */
    public LinearNode<T> getNext() {
        return this.next;

    }

    /**
     * Sets the node that follows this one.
     *
     * @param node node to follow this one
     */
    public void setNext(LinearNode<T> node) {
        this.next = node;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return T element stored at this node
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Sets the element stored in this node.
     *
     * @param elem element to be stored at this node
     */
    public void setElement(T elem) {
        this.element = elem;
    }
}
