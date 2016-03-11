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

        LinkedList<String> L = new LinkedList<>();
        L.addFirst("One");
        L.addFirst("Two");
        L.addFirst("Three");
        L.addFirst("Four");
        L.addLast("Five");
        L.addLast("Five");
        L.addLast("Five");
        L.addLast("Five");
        

        try {
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            System.out.println(L.removeLast());
            
            
            
            System.out.println(L.first());
            System.out.println(L.last());
            
            
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
    }

}
