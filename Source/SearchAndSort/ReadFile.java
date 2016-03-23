package SearchAndSort;

import Stacks.ArrayStack;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author John Verwolf
 * @param <T> Object type to be read from file
 */
public class ReadFile<T> {

    private DataStructure<T> fileObject;

    /**
     * Reads and object from a .ser file and returns the object
     *
     * @param filepath The filepath of the .ser file
     *
     */
    public ReadFile(String filepath) {

        FileInputStream fileInput = null;
        ObjectInputStream in = null;
        try {
            fileInput = new FileInputStream(filepath);
            in = new ObjectInputStream(fileInput);
            fileObject = (DataStructure<T>) in.readObject();
        } catch (IOException e) {
            System.out.println("There was an IO error: " + e);
            System.exit(1);
        } catch (ClassNotFoundException e) {
            //fileObject = null;
            //e.printStackTrace();
            System.out.println("The file was not found: " + e);
            System.exit(1);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
                System.out.println("There was an IO error: " + e);
            }
        }
    }

    /**
     * gets the file object
     *
     * @return
     */
    public DataStructure<T> getFile() {
        return fileObject;
    }
}
