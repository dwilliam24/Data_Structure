import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DS1_CH4
{
    public static int largestAreaSum(String fileName)
    {
        ArrayList<String> nums = new ArrayList<>();
        try {
            File fileRef = new File(fileName);
            Scanner scanner = new Scanner(fileRef);
            while (scanner.hasNextLine()) {
                nums.add(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
            System.exit(0);
        }
        String[][] full = new String[Integer.parseInt(String.valueOf(nums.get(0).charAt(2)))][Integer.parseInt(String.valueOf(nums.get(0).charAt(0)))];
        nums.remove(0);

        for (int x = 0; x < full.length; x++) {
            full[x] = nums.get(x).split(" ");
        }

        int biggest=0;
        for (int y = 0; y < full.length; y++) {
            for (int x = 0; x < full[0].length; x++) {

                int num=Integer.parseInt(full[y][x]);
                if (x-1>=0)num+=Integer.parseInt(full[y][x-1]);
                if (x+1<full[0].length) num+=Integer.parseInt(full[y][x+1]);
                if (y-1>=0)num+=Integer.parseInt(full[y-1][x]);
                if (y+1<full.length)num+=Integer.parseInt(full[y+1][x]);
                if (num>biggest)biggest=num;
            }

        }

        return biggest;
    }
}
