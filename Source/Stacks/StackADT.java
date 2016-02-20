package Stacks;

/**
 *
 * @author C0432660 John Verwolf
 * @param <T>
 */
public interface StackADT<T> {

    public T pop() throws EmptyCollectionException;

    public T peek() throws EmptyCollectionException;

    public void push(T element);

    public Boolean isEmpty();

    public int size();

    @Override
    public String toString();
}
