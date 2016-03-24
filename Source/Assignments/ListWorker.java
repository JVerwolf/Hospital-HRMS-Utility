package Assignments;

/**
 *
 * @author John Verwolf
 */
public class ListWorker {

    List head;

    public ListWorker(List head) {
        this.head = head;
    }

    String head(List L) {
        if (L == null) {
            return "null";
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

    public void split(List L) {
        if (L == null) {
            return;
        }
        //Probe to use as a tool to find the end of the list
        List probe = L;

        int count = 0;              //count the number of methods.
        while (probe.next != null) {
            probe = probe.next;     //traverse list.
            count++;                //increment count.
        }
        probe = L;                  //reset probe to head of original list.
        count /= 2;                 //divide the count by 2.
        while (count > 0) {         //loop while count is greater than zero.
            probe = probe.next;     //traverse list.      
            count--;                //decrement count.
        }
        probe.next = null;          //delete the other half of the list.
    }

    public void everyOther(List L) {
        //Probe to use as a tool to find the end of the list
        List probe = L;
        
        //check to see if next ellement or next.next element is null
        while (probe.next != null && probe.next.next != null) {
            probe.next = probe.next.next; //remove next node
            probe = probe.next;           //traverse 1 step
        }
        probe.next = null;                //chop of last node for exception case     
    }
}
