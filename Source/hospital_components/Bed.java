package hospital_components;

import java.io.Serializable;

/**
 * This class is used to represent a Bed object in a care facility or hospital.
 * The location and name of the bed are contained.
 *
 * @author John Verwolf
 */
public class Bed implements Serializable {

    private String location;
    private String name;
    boolean usable;
    Patient patient;

    /**
     * Initializes this Bed object's name and location to a specified name and
     * location
     *
     * @param name     The specified name for the bed
     * @param location the specified location where this bed is located
     */
    public Bed(String name, String location, boolean available, Patient patient) {
        this.location = location;
        this.name = name;
        this.usable = available;
        this.patient = patient;
    }

    /**
     * sets location
     *
     * @param location location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * get location
     *
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * get patient in bed
     *
     * @return patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * assigns patient to bed
     *
     * @param patient patient to be assigned to bed
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * returns availability
     *
     * @return True if usable, false if not usable.
     */
    public boolean getUsable() {
        return usable;
    }

    /**
     * sets availability
     *
     * @param availability True if usable, false if not usable.
     */
    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    /**
     * @return this bed object's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set this bed object's name
     *
     * @param name bed object's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a String representation of this Bed object with the name followed
     * by a space followed by location.
     *
     * @return a String representation of this Bed object with the name followed
     *         by a space followed by location.
     */
    @Override
    public String toString() {
        return "Bed: " + "location=" + location + ", name=" + name;
    }

}
