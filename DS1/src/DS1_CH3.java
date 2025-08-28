import java.io.File;
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

        int size = nums.remove(0).charAt(2);
        int[] array = new int[size];

        for (int x=0; x<size; x++){
            int[] numb = Integer.parseInt(nums.get(x).split(" "));

        }


    }
}
