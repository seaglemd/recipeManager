package recipeManager;

import java.io.*;

public class WriteOut
{
    private static ObjectOutputStream output;

    public static void writeData(String dataName, Object theData) throws ClassNotFoundException, IOException
    {
        output = new ObjectOutputStream(new FileOutputStream(dataName+".dat"));
        output.writeObject(theData);
        output.close();
    }
}