package io_utils;

import data_structures.ArrayStack;
import hospital_components.Patient;
import java.io.File;
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
     * Reads and object from a .ser file and returns the object.
     * <p>
     * Proper use example:
     * <p>
     * <code> Bedlist = (LinkedList<Bed>) new
     * ReadFile("saves/bedList.ser").getFile(); </code>
     *
     * @param filepath The filepath of the .ser file
     *
     */
    public ReadFile(String fileName) {
        String dirName = "saves";                               //name of dir
        String filePath = dirName + "/" + fileName + ".cf";    //concatonate file path                          
        if (new File(dirName).isDirectory() && new File(filePath).isFile()) { //check to make sure the dir and the save exist
            FileInputStream fileInput = null;
            ObjectInputStream in = null;
            try {
                fileInput = new FileInputStream(filePath);
                in = new ObjectInputStream(fileInput);
                fileObject = (DataStructure<T>) in.readObject();
            } catch (IOException e) {
                System.out.println("There was an IO error: " + e);
                System.exit(1);
            } catch (ClassNotFoundException e) {
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
        } else {
            System.out.println("Save file does not exist");
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
