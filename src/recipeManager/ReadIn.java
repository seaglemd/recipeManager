package recipeManager;

import java.io.*;
import java.util.*;

public class ReadIn
{
	private static InputStream file;
    private static InputStream buffer;
    private static ObjectInput input;
    private static ArrayList<Recipe> obtainedData;

    public static ArrayList<Recipe> readData(String dataName) throws ClassNotFoundException, IOException
    {
        file = new FileInputStream(dataName + ".dat");
        buffer = new BufferedInputStream(file);
        input = new ObjectInputStream(buffer);
        
        ArrayList<Recipe> obtainedData = (ArrayList<Recipe>)input.readObject();
        
        input.close();
        return obtainedData;
    }
}
