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
       

        {

            LinkedList<String> L = new LinkedList<>();
            L.addFirst("1 One");
            L.addFirst("2 Two");
            L.addFirst("3 Three");
            L.addFirst("Four");
            L.addFirst("5 Five");
            L.addFirst("6 Six");
            L.addFirst("7 Seven");
            L.addFirst("8 Eight");

            LinkedList<String> P = L.copy();

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

            try {
                System.out.println("\n" + P.removeFirst());
                System.out.println(P.removeFirst());
                System.out.println(P.removeFirst());
                System.out.println(P.removeFirst());
                System.out.println(P.removeFirst());
                System.out.println(P.removeFirst());
                System.out.println(P.removeFirst());
                System.out.println(P.removeFirst());

                

            } catch (EmptyCollectionException e) {
                System.out.println(e);
            }
        }
    }
}
