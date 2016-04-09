/*
 *
 */
package Assignments;

import data_structures.EmptyCollectionException;

/**
 *
 * @author John Verwolf
 */
public class TestList {

    public static void main(String[] args) {
        TempListWorker<String> L = new TempListWorker<>();

        L.addLast("1 One");
        L.addLast("2 Two");
        L.addLast("3 Three");
        L.addLast("4 Four");
        L.addLast("5 Five");
        L.addLast("6 Six");
        L.addLast("7 Seven");
        L.addLast("8 Eight");
        
        //L.reverse(L.getHead());

        try {
            System.out.println(L.removeFirst());
            System.out.println(L.removeFirst());
            System.out.println(L.removeFirst());
            System.out.println(L.removeFirst());
            System.out.println(L.removeFirst());
            System.out.println(L.removeFirst());
            System.out.println(L.removeFirst());
            System.out.println(L.removeFirst());

            

        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }
}
