package data_structures;

/**
 *
 * @author John Verwolf
 */
public class ElementNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ElementNotFoundException</code> without
     * detail message.
     */
    public ElementNotFoundException() {
        super("The element was not found: ");
    }

    /**
     * Constructs an instance of <code>ElementNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ElementNotFoundException(String msg) {
        super("The element was not found: " + msg);
    }
}
