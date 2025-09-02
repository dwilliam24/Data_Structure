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
        int[] last = new int[full.length];


        for (int x = 0; x < full.length; x++) {
            full[x] = nums.get(x).split(" ");
        }

       int[][] sums = new int[full.length][full[0].length];

        for ()
    }
}
