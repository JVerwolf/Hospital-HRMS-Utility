package SearchAndSort;

import employee_types.CasualEmployee;
import data_structures.ArrayStack;
import Stacks.Patient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

/**
 *
 * @author C0432660 John Verwolf
 */
public class WriteFile<T> {

    private DataStructure<T> fileObject;

    public WriteFile(DataStructure<T> FILEOBJECT) {
        this.fileObject = FILEOBJECT;
    }

    public void writeTo(String fileName) {
        String dirName = "saves";
        String filePath = dirName + "/" + fileName + ".ser";
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
