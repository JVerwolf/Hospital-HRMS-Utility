package Stacks;

/**
 *
 * @author John Verwolf
 */
public class Bed {

    private String location;
    private String name;

    /**
     * Initializes this Bed object's name and location to a specified name and
     * location
     *
     * @param name     The specified name for the bed
     * @param location the specified location where this bed is located
     */
    public Bed(String name, String location) {
        this.location = location;
        this.name = name;
    }
    
//    /**
//     * Static factory method design pattern
//     * @param name
//     * @param location
//     * @return 
//     */
//    public static Bed getInstBedNameLocation(String name, String location){
//        return new Bed(name, location);
//    }
    
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
     *
     * @return a String representation of this Bed object with the name followed
     *         by a space followed by location
     */
    @Override
    public String toString() {
        return "Bed{" + "location=" + location + ", name=" + name + '}';
    }

}
