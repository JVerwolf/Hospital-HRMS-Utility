/*
 *
 */
package Assignments;

import Stacks.EmptyCollectionException;

/**
 *
 * @author John Verwolf
 */
public class TestList {

    public static void main(String[] args) {
        ListWorker<String> L = new ListWorker<>();

        L.addFirst("1 One");
        L.addFirst("2 Two");
        L.addFirst("3 Three");
        L.addFirst("4 Four");
        L.addFirst("5 Five");
        L.addFirst("6 Six");
        L.addFirst("7 Seven");
        L.addFirst("8 Eight");
        
        L.reverse(L.getHead());

        try {
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());

            

        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }
}
