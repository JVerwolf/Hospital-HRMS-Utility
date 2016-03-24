/*
 *
 */
package Assignments;



/**
 *
 * @author John Verwolf
 */
public class TestList {

    public static void main(String[] args) {
        
       
        List L = new List("1",new List("2",new List("3",new List("4",new List("5",new List("6",null))))));
        
        ListWorker LW = new ListWorker(L);
        //LW.reverse(L); //comment this line to toggle list reversal
        LW.everyOther(L);
        
        List probe = LW.head;
        
        
        while (probe.next != null){
            System.out.println(probe.data);
            probe = probe.next;
        }
        System.out.println(probe.data);
//        
    }
}
