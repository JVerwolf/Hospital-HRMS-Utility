package Stacks;

/**
 *
 * @author John Verwolf
 */
public class Patient {

    private Bed bed;
    private java.lang.String name;
    private int priority;

    /**
     * Initializes this Patient object's name, priority and Bed the name for the
     * Patient is set to an empty string the priority for patient is set to 0
     * the bed object assigned to the patient is set to null
     */
    public Patient() {
        name = "";
        priority = 0;
        bed = null;
    }

    /**
     * Initializes this Patient object's name and priority. Bed is set to null.
     *
     * @param name     the specified name for the Patient
     * @param priority the specified priority for patient based on patient's
     *                 criticality The bed object assigned to the patient is set
     *                 to null
     */
    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
        bed = null;
    }

    /**
     * get this patient object's bed
     *
     * @return returns the specified patient object's bed
     */
    public Bed getBed() {
        return bed;
    }

    /**
     * Set this patient object's bed
     *
     * @param bed the specified patient object's bed
     */
    public void setBed(Bed bed) {
        this.bed = bed;
    }

    /**
     * Get this patient object's name
     *
     * @return the specified patient object's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set this patient object's name
     *
     * @param name The patient's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get this patient object's priority
     *
     * @return the specified patient object's priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * set this patient object's priority
     *
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Return a String representation of this Patient object
     *
     * @return a String representation of this Patient object
     */
    @Override
    public String toString() {
        return "Patient:" + "bed=" + bed + ", name=" + name + ", priority=" + priority;
    }

}
