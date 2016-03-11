package Stacks;

/**
 * The purpose of this class is to test the CareFacility class behaviorally.
 *
 * @author John Verwolf
 */
public class StacksMainClass {

    public StacksMainClass() {
    }

    /**
     * The purpose of this class is to test the CareFacility class behaviorally.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {

        /**
         * Here, new instance of the CareFacility class is instantiated. A stack
         * of Patient objects and a stack of Bed objects are passed, and the
         * assignBed() method is called.
         * <p>
         * A loop then prints out the list of the Patient objects in the
         * CareFacility instance, displaying their properties 'priority' and
         * 'bed'.
         * <p>
         * The expected output is a of patients sorted from lowest to highest
         * 'priority', with all the bed objects assigned to those with the
         * highest priority.
         */
        CareFacility CF = new CareFacility("Test lab", stackOfPatients(), stackOfBeds(), null);
        {

            //this method assigns beds to patients
            CF.assignBed();

            /**
             * Get a copy of the patientStack instance variable of CF
             * CareFacility object.
             */
            ArrayStack<Patient> tempPatientStack = CF.getCopyPatientStack();

            /**
             * This loop prints out the list of the Patient objects in the
             * CareFacility instance CF, displaying their properties 'priority'
             * and 'bed'.
             */
            try {
                while (!tempPatientStack.isEmpty()) {       //loop while there are still elements in the patientStack
                    Patient p = tempPatientStack.pop();     //pop a patient, assign to temp variable

                    String bed = "NO BED";                  //instantiate bed variable to default value "NO BED"

                    if (p.getBed() != null) {               //If the current patient (in the temp variable) has a bed...
                        bed = p.getBed().getName();         //change bed variable to the name of the bed
                    }

                    String name = p.getName();              //instantiate name varaible to hold name of patient

                    System.out.println(name + "\t" + bed);  //print out properties of current patient in temp vraible
                }
            } catch (EmptyCollectionException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Generate and return a stack of 10 patients.
     *
     * @return a stack of 10 patients.
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
        Patient p1 = new Patient("Bob1", 1);
        Patient p0 = new Patient("Bob0", 0);

        ArrayStack<Patient> pStack = new ArrayStack<>();   

        for (Patient e : new Patient[]{p2, p1, p3, p8, p5, p9, p7, p6, p4, p10, p0}) {
            pStack.push(e);
        }

        return pStack.copy();
    }

    /**
     * Generate and return a stack of beds with 4 beds.
     *
     * @return a stack of beds with 4 beds.
     */
    private static ArrayStack<Bed> stackOfBeds() {
        Bed b1 = new Bed("Bed1", "1");
        Bed b2 = new Bed("Bed2", "1");
        Bed b3 = new Bed("Bed3", "1");
        Bed b4 = new Bed("Bed4", "1");

        ArrayStack<Bed> bStack = new ArrayStack<>();
        
        for (Bed e : new Bed[]{b1, b2, b3, b4}) {
            bStack.push(e);
        }       
        return bStack.copy();
    }
}
