package Stacks;

/**
 *
 * @author John Verwolf
 */
public class StacksMainClass {

    public StacksMainClass() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        {
            Patient p10 = new Patient("Bob10", 10);
            Patient p9 = new Patient("Bob9", 9);
            Patient p8 = new Patient("Bob8", 8);
            Patient p7 = new Patient("Bo7", 7);
            Patient p6 = new Patient("Bob6", 6);
            Patient p5 = new Patient("Bob5", 5);
            Patient p4 = new Patient("Bob4", 4);
            Patient p3 = new Patient("Bob3", 3);
            Patient p2 = new Patient("Bob2", 2);
            Patient p1 = new Patient("Bob2", 1);
            Patient p0 = new Patient("Bob0", 0);
            
            ArrayStack<Patient> pStack = new ArrayStack<>();
            
            pStack.push(p6);
            pStack.push(p2);
            pStack.push(p3);
            pStack.push(p4);
            pStack.push(p10);
            pStack.push(p8);
            pStack.push(p5);
            pStack.push(p9);
            pStack.push(p6);
            pStack.push(p7);
            pStack.push(p0);
            pStack.push(p6);
            pStack.push(p4);
            pStack.push(p10);
            pStack.push(p0);
            pStack.push(p5);
            
            CareFacility CF = new CareFacility("Test lab", pStack, null, null);
            
            CF.addPatient(p1);//first in, last out
            CF.addPatient(p2);
            CF.addPatient(p3);
            CF.addPatient(p4);
            CF.addPatient(p5);
            CF.addPatient(p6);
            CF.addPatient(p10);
            CF.addPatient(p3);
            CF.addPatient(p2);
            CF.addPatient(p1);
            CF.addPatient(p0);
            CF.addPatient(p10);//last in, first out

            try {
                while(CF.patientStack.peek().getName() != null){                
                    System.out.println(CF.patientStack.pop().getName());
                }
            } catch (EmptyCollectionException e) {
                System.out.println(e);
            }
            
        
    

        
    


            
            
            
            
            

        }
    }

}
