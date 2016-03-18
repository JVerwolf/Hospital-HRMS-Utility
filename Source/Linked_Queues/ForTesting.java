/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linked_Queues;

import Stacks.EmptyCollectionException;

/**
 *
 * @author C0432660 John Verwolf
 */
public class ForTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LinkedQueue<String> L = new LinkedQueue<>();
        L.enqueue("One");
        L.enqueue("Two");
        L.enqueue("Three");
        L.enqueue("Four");
        L.enqueue("Five");
        L.enqueue("Six");
        L.enqueue("Seven");
        L.enqueue("Eight");

        LinkedQueue<String> P = L.copy();

        try {
            System.out.println(L.dequeue());
            System.out.println(L.dequeue());
            System.out.println(L.dequeue());
            System.out.println(L.dequeue());
            System.out.println(L.dequeue());
            System.out.println(L.dequeue());
            System.out.println(L.dequeue());

            System.out.println(L.first());

        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }

        try {
            System.out.println("\n\n" + P.dequeue());
            System.out.println(P.dequeue());
            System.out.println(P.dequeue());
            System.out.println(P.dequeue());
            System.out.println(P.dequeue());
            System.out.println(P.dequeue());
            System.out.println(P.dequeue());

            System.out.println(P.first());

        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }
}
//
//        LinkedList<String> L = new LinkedList<>();
//        L.addFirst("1 One");
//        L.addFirst("2 Two");
//        L.addFirst("3 Three");
//        L.addFirst("Four");
//        L.addFirst("5 Five");
//        L.addFirst("6 Six");
//        L.addFirst("7 Seven");
//        L.addFirst("8 Eight");
//
//        LinkedList<String> P = L.copy();
//
//        try {
//            System.out.println(L.removeLast());
//            System.out.println(L.removeLast());
//            System.out.println(L.removeLast());
//            System.out.println(L.removeLast());
//            System.out.println(L.removeLast());
//            System.out.println(L.removeLast());
//            System.out.println(L.removeLast());
//
//            System.out.println(L.first());
//            System.out.println(L.last());
//
//        } catch (EmptyCollectionException e) {
//            System.out.println(e);
//        }
//
//        try {
//            System.out.println("\n" + P.removeLast());
//            System.out.println(P.removeLast());
//            System.out.println(P.removeLast());
//            System.out.println(P.removeLast());
//            System.out.println(P.removeLast());
//            System.out.println(P.removeLast());
//            System.out.println(P.removeLast());
//
//            System.out.println(P.first());
//            System.out.println(P.last());
//
//        } catch (EmptyCollectionException e) {
//            System.out.println(e);
//        }
//    }
//}

