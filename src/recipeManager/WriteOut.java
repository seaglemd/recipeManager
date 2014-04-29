package recipeManager;

import java.io.*;
import java.util.*;

public class WriteOut
{
    private static OutputStream file;
    private static OutputStream buffer;
    private static ObjectOutput output;

    public static void writeData(String dataName, ArrayList<Recipe> theData) throws ClassNotFoundException, IOException
    {
    	 file = new FileOutputStream(dataName+".dat");
    	 buffer = new BufferedOutputStream(file);
    	 output = new ObjectOutputStream(buffer);
    	 output.writeObject(theData);
    	 output.flush();
    	 output.close();
    }
}