import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DS1_CH3 {
    public static int[] rowSums(String fileName) {
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

        int[][] array = new int[Integer.parseInt(nums.getFirst().split("X")[0])][Integer.parseInt(nums.getFirst().split("X")[1])];

        for (int y=0; y<array.length; y++){
            for (int x=0; x< array[0].length; x++){
                for (int d =1; d<nums.size(); d++)
                    array[y][x]=Integer.parseInt(nums.get(d).split(" ")[x]);
            }
        }

        int[] sum = new int[array.length];
        for (int y=0; y< array.length; y++){
            int rowSum =0;
            for (int x=0; x<array[0].length; x++) {
                array[y][x]+= rowSum;
            }
            sum[y]=rowSum;
        }
        return sum;
    }
}
