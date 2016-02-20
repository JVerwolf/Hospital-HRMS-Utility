package Stacks;

import ADT.Company;
import ADT.HourlyEmployee;

/**
 *
 * @author John Verwolf
 */
public class CareFacility extends Company {

    private java.lang.String facilityName;
    private ArrayStack<Patient> patientStack;
    private ArrayStack<Bed> bedStack;
    private HourlyEmployee[] hourlyEmployee;

    /**
     * Initializes this Care Facility object's name and array of employees,
     * array of beds and array of patients to null
     */
    public CareFacility() {
        facilityName = null;
        hourlyEmployee = null;
        bedStack = null;
        patientStack = null;
    }

    /**
     * Initializes this Care Facility object's name and array of employees array
     * of beds and array of patients from a specified name and array of
     * employees, array of beds and array of patients
     *
     * @param facilityName
     * @param patientStack
     * @param bedStack
     * @param hourlyEmployee
     */
    public CareFacility(String facilityName, ArrayStack<Patient> patientStack, ArrayStack<Bed> bedStack, HourlyEmployee[] hourlyEmployee) {
        this.facilityName = facilityName;
        this.patientStack = patientStack;
        this.bedStack = bedStack;
        this.hourlyEmployee = hourlyEmployee;
    }

    /**
     * Initializes this Care Facility object's name and array of employees from
     * specified name and array of employees The array of beds and array of
     * patients will be set to null
     *
     * @param facilityName
     * @param hourlyEmployee
     */
    public CareFacility(String facilityName, HourlyEmployee[] hourlyEmployee) {
        this.facilityName = facilityName;
        this.hourlyEmployee = hourlyEmployee;
        bedStack = null;
        patientStack = null;
    }
    
    /**
     * Assign registered patients to existing beds
     */
    public void assignBed(){
        throw new UnsupportedOperationException();//TODO:code method
    }
    

}
