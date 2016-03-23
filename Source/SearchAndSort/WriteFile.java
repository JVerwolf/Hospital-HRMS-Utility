package SearchAndSort;

import Linked_Queues.CasualEmployee;
import Stacks.ArrayStack;
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

    public void writeTo(String filePath) {
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;
        try {
            fileOut = new FileOutputStream(filePath, true);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(fileObject);                       
        } catch (IOException i) {            
            System.out.println("Failure to write file:" + i);
        }finally {
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
