package recipeManager;

import java.io.*;

public class ReadIn
{
    private static ObjectInputStream input;
    private static Object obtainedData;

    public static Object readData(String dataName) throws ClassNotFoundException, IOException
    {
        input = new ObjectInputStream(new FileInputStream(dataName+".dat"));
        obtainedData = (Object)input.readObject();
        input.close();
        return obtainedData;
    }
}
