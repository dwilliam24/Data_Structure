import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DS1_CH2
{
    public static int vowelNames(String fileName)
    {
        ArrayList<String> names= new ArrayList<>();
        try {
            File fileRef = new File(fileName);
            Scanner scanner = new Scanner(fileRef);
            while (scanner.hasNextLine()){
                names.add(scanner.nextLine());
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
            System.exit(0);
        }
        int e=0;
        for (String x: names)
        {
            if ("AEIOUaeiou".contains(" "+x.charAt(0))) {
                e++;
            }
        }
        return e;
    }
}