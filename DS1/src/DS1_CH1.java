import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DS1_CH1 {
    public static int[] sumLines(String fileName)
    {
        ArrayList<String> sum= new ArrayList<>();
        try {
            File fileRef = new File(fileName);
            Scanner scanner = new Scanner(fileRef);
            int x=0;
            while (scanner.hasNextLine()){
                sum.add(scanner.nextLine());
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
            System.exit(0);
        }


        int[] list = new int[sum.size()];
        for (int x =0; x<sum.size(); x++)
        {
            String[] a = sum.get(x).split(",");
            int p = 0;
            for (int y =0; y<a.length; y++)
            {
                p+=Integer.parseInt(a[y]);
            }
            list[x]=p;
        }
        return list;
    }

}
