package data_structures;

/**
 * This exception is thrown when a collection element is called for that does
 * not exist.
 *
 * @author  John Verwolf
 */
public class EmptyCollectionException extends Exception {

    /**
     * Creates a new instance of <code>EmptyCollectionException</code> without
     * detail message.
     */
    public EmptyCollectionException() {
        super("The collection is empty");
    }

    /**
     * Constructs an instance of <code>EmptyCollectionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message. Should be the name of the stack in which
     *            it is used, or the name of the method in which it was called.
     */
    public EmptyCollectionException(String msg) {
        super("The collection is empty: " + msg);
    }
}
