package hospital_components;

import java.io.Serializable;

/**
 *
 * @author John Verwolf
 */
public class CasualEmployee extends HourlyEmployee implements Serializable {

    /**
     * Availability
     */
    private boolean availability;

    private Patient patient;

    /**
     * Default constructor. Assigns all values to blank/0/False
     */
    public CasualEmployee() {
        super();
        this.availability = false;
        this.patient = null;
    }

    /**
     * Constructor
     *
     * @param name         Name of employee
     * @param availability Availability of employee
     */
    public CasualEmployee(String name, boolean availability) {
        super();
        super.setName(name);
        this.availability = availability;
        this.patient = null;
    }

    /**
     * construct casual employee
     *
     * @param name         name of casual employee
     * @param availability availability of casual employee
     * @param pay          hourly pay
     */
    public CasualEmployee(String name, boolean availability, double pay) {
        super();
        super.setName(name);
        super.setPayRate(pay);
        this.availability = availability;
        this.patient = null;
    }

    /**
     * constructs casual employee
     *
     * @param name
     * @param availability
     * @param assigned
     * @param pay
     */
    public CasualEmployee(String name, boolean availability, Patient assigned, double pay) {
        super();
        super.setName(name);
        super.setPayRate(pay);
        this.availability = availability;
        this.patient = assigned;
    }
    /**
     * removes the patient from the casual employee, and the casual employee from the patient
     */
    public void removePatient() {
        if (patient != null) {
            if (patient.getCasualEmployee() != null) {
                patient.setCasualEmployee(null);
            }
            patient = null;
        }
    }

    /**
     *
     * gets assigned patient
     *
     * @return assigned patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * assign a patient
     *
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * get the Availability of the Casual Employee
     *
     * @return availability
     */
    public boolean getAvailability() {
        return availability;
    }

    /**
     * returns true if employee can be assigned a patient
     *
     * @return True if employee can be assigned a patient
     */
    public boolean isAssignable() {
        return (availability && patient == null);
    }

    /**
     * set the Availability of the Casual Employee
     *
     * @param availability
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
        //if set to unavailable, remove patient from his/her care.
        if (!availability) {
            patient = null;
        }
    }

    /**
     * String representation of the object
     *
     * @return String representation of the object
     *
     */
    @Override
    public String toString() {
        return "CasualEmployee{" + "availability=" + availability + '}';
    }

}
