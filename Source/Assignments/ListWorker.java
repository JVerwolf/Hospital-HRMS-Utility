/*
 *
 */
package Assignments;

class List {

    Object data;
    List next;

    public List(Object data, List next) {
        this.data = data;
        this.next = next;
    }
}

/**
 *
 * @author John Verwolf
 */
public class ListWorker {

    List head;

    Object head(List L) {
        if (L == null) {
            return L;
        }
        return L.data;
    }

    List tail(List L) {
        if (L == null) {
            return L;
        }
        return L.next;
    }

    public void reverse(List L) {
        //New list that will be built from reversed passed TempListWorker
        List ReversedList = new List(null, null);           
        //New list that will be built from reversed passed TempListWorker
        List ReversedListProbe = ReversedList;              
        //Probe to use as a tool to find the end of the list
        List probe = L;                            

        while (L.next != null) {
            while (probe.next.next != null) { 
                probe = probe.next;
            }
            ReversedListProbe.data = probe.next.data;    //copy data to new list
            ReversedListProbe.next = new List(null, null);//add node to new list
            ReversedListProbe = ReversedListProbe.next;
            probe.next = null;                    //delete last node from master
            probe = L;                   //Reset probe
        }        
        ReversedListProbe.data = L.data; //copy data to new list
        head = ReversedList;
    }
}
