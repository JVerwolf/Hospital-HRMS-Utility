package io_utils;

import hospital_components.CasualEmployee;
import data_structures.ArrayStack;
import hospital_components.Patient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

/**
 *
 * @author C0432660 John Verwolf
 * @param <T> Element type
 */
public class WriteFile<T> {

    private DataStructure<T> fileObject;

    /**
     * Writes the specified data structure to a file
     *
     * @param FILEOBJECT
     */
    public WriteFile(DataStructure<T> FILEOBJECT) {
        this.fileObject = FILEOBJECT;
    }

    /**
     * takes a filepath and writes the file
     *
     * @param fileName file path
     */
    public void writeTo(String fileName) {
        String dirName = "saves";
        String filePath = dirName + "/" + fileName + ".cf";
        File f = new File(dirName);
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;
        try {
            f.mkdir(); //make a new dir called "saves" if one doesn't exist        
            fileOut = new FileOutputStream(filePath, true);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(fileObject);
        } catch (IOException i) {
            System.out.println("Failure to write file:" + i);
        } finally {
            try {
                if (objOut != null) {
                    objOut.close();
                }
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
