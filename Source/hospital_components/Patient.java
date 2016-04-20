package hospital_components;

import java.io.Serializable;

/**
 *
 * @author John Verwolf
 */
public class Patient implements Serializable, Comparable<Patient> {

    private Bed bed;
    private CasualEmployee casualEmployee;
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
     * Compares Patient objects by order of priority
     *
     * @param p Patient object to be compared against.
     * @return -int if this patient has lower priority than passed object, +int
     *         if it has higher priority, and 0 if they are equal.
     */
    @Override
    public int compareTo(Patient p) {
        return Integer.compare(this.priority, p.getPriority());
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
     * Get the casual employee assigned to the patient
     *
     * @return the casual employee assigned to the patient
     */
    public CasualEmployee getCasualEmployee() {
        return casualEmployee;
    }
    /**
     * Sets the Casual Employee to be assigned to the patient
     *
     * @param casualEmployee the Casual Employee to be assigned to the patient
     */
    public void setCasualEmployee(CasualEmployee casualEmployee) {
        this.casualEmployee = casualEmployee;
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
     *Removes bed from patient and patient from bed
     */
    public void removeBed() {
        if (bed != null) {
            if (bed.getPatient() != null) {
                bed.setPatient(null);
            }
            bed = null;
        }
    }
    /**
     * removes casual employee from patient and patient from casual employee
     */
    public void removeCasualEmployee(){
        if (casualEmployee != null) {
            if (casualEmployee.getPatient() != null) {
                casualEmployee.setPatient(null);
            }
            casualEmployee = null;
        }
    }

    /**
     * Return a String representation of this Patient object
     *
     * @return a String representation of this Patient object
     */
    @Override
    public String toString() {
        return "Patient: " + "bed=" + bed + ", name=" + name + ", priority=" + priority;
    }

}
