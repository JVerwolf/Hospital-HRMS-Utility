package Queues_List;

/**
 *
 * @author John Verwolf
 * 
 * @Param T generic element to be stored in List 
 */
public interface ListADT<T> {

    /**
     * Remove First element from list
     *
     * @return First element from list
     */
    public T removeFirst();

    /**
     * Remove last element from list
     *
     * @return last element from list
     */
    public T removeLast();

    /**
     * Returns data at first node in list
     *
     * @return data at first node in list
     */
    public T first();

    /**
     * Returns last at first node in list
     *
     * @return last at first node in list
     */
    public T last();

    /**
     * Check to see if the queue is empty
     *
     * @return T if empty, F if not empty
     */
    public Boolean isEmpty();

    /**
     * Adds and element at the head of the list
     *
     * @param element element to be added
     *
     */
    public void addFirst(T element);

    /**
     * Adds and element at the tail of the list
     *
     * @param element element to be added
     *
     */
    public void addLast(T element);
}
