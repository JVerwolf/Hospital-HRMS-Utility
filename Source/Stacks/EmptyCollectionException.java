
package Stacks;

/**
 *
 * @author C0432660 John Verwolf
 */
public class EmptyCollectionException extends Exception {

    /**
     * Creates a new instance of <code>EmptyCollectionException</code> without
     * detail message.
     */
    public EmptyCollectionException()  {
        super("The collection is empty");
    }

    /**
     * Constructs an instance of <code>EmptyCollectionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message. Should be the name of the stack in which
     *            it is used.
     */
    public EmptyCollectionException(String msg) {
        super("The " + msg + " collection is empty");
    }
}
