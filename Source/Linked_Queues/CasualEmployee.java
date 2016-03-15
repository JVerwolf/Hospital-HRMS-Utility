package Linked_Queues;

import ADT.HourlyEmployee;

/**
 *
 * @author John Verwolf
 */
public class CasualEmployee extends HourlyEmployee {

    private boolean availability;

    public CasualEmployee() {
        super();
        this.availability = false;
    }

    public CasualEmployee(String name, boolean availability) {
        super();
        super.setName(name);
        this.availability = availability;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "CasualEmployee{" + "availability=" + availability + '}';
    }
 
}
