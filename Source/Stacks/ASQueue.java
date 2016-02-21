package Stacks;

/**
 * This Queue structure recursively traverses an ArrayStack to push an element
 * to the
 * bottom of the stack
 *
 * @author John Verwolf
 * @param <T> Data Type T
 */
public class ASQueue<T> extends ArrayStack<T> {

    private ArrayStack<T> stack = new ArrayStack<>();

    /**
     * This method is pushes elements to the bottom of the ArrayStack, thus
     * imitating a queue. Here, the call-stack is used as the second stack in
     * which to temporarily store elements in the ArrayStack as they are peeled
     * off recursively. thus, the bottom of the stack is where data goes in, and
     * the top is where it comes out. As such, all the methods of the original
     * ArrayStack class can still be used.
     *
     * @param element Element to be pushed to the bottom of the stack
     */
    @Override
    public void push(T element) {

        try {
            if (!stack.isEmpty()) {
                T topElement = stack.pop();//pop top element off of the stack
                this.push(element); //recursive call
                stack.push(topElement); //put topElement back on to stack as recursion unwinds
            } else {
                stack.push(element); //put element at the bottom of the stack
            }

        } catch (EmptyCollectionException e) {
            System.out.println("Something went wrong in the queue ADT:\t" + e); 
        }

    }
}
