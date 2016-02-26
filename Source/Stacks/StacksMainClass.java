package Stacks;

/**
 *
 * @author John Verwolf
 */
public class StacksMainClass {

    public StacksMainClass() {
    }

    /**
     * The purpose of this class is to test the CareFacility class behaviorally. 
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        {
            CareFacility CF = new CareFacility("Test lab", stackOfPatients(), stackOfBeds(), null);
            CF.assignBed();

            try {
                while (!CF.patientStack.isEmpty()) {
                    Patient p = CF.patientStack.pop();

                    String bed = "NO BED";

                    if (p.getBed() != null) {
                        bed = p.getBed().getName();
                    }

                    String name = p.getName();

                    System.out.println(name + "\t" + bed);
                }
            } catch (EmptyCollectionException e) {
                System.out.println(e);
            }

        }

    }

    /**
     * Return a stack of 10 patients
     *
     * @return a stack of 10 patients
     */
    private static ArrayStack stackOfPatients() {
        Patient p10 = new Patient("Bob10", 10);
        Patient p9 = new Patient("Bob9", 9);
        Patient p8 = new Patient("Bob8", 8);
        Patient p7 = new Patient("Bob7", 7);
        Patient p6 = new Patient("Bob6", 6);
        Patient p5 = new Patient("Bob5", 5);
        Patient p4 = new Patient("Bob4", 4);
        Patient p3 = new Patient("Bob3", 3);
        Patient p2 = new Patient("Bob2", 2);
        Patient p1 = new Patient("Bob2", 1);
        Patient p0 = new Patient("Bob0", 0);

        ArrayStack<Patient> pStack = new ArrayStack<>();

        pStack.push(p2);
        pStack.push(p1);
        pStack.push(p3);
        pStack.push(p8);
        pStack.push(p5);
        pStack.push(p9);
        pStack.push(p7);
        pStack.push(p6);
        pStack.push(p4);
        pStack.push(p10);
        pStack.push(p0);

        return pStack;
    }

    /**
     * Returns a stack of beds with 4 beds
     *
     * @return a stack of beds with 4 beds
     */
    private static ArrayStack<Bed> stackOfBeds() {
        Bed b1 = new Bed("Bed1", "1");
        Bed b2 = new Bed("Bed2", "1");
        Bed b3 = new Bed("Bed3", "1");
        Bed b4 = new Bed("Bed4", "1");

        ArrayStack<Bed> bStack = new ArrayStack<>();

        bStack.push(b1);
        bStack.push(b2);
        bStack.push(b3);
        bStack.push(b4);

        return bStack;
    }

}
