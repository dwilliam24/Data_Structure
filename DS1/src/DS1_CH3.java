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
        String[][] full = new String[Integer.parseInt(String.valueOf(nums.get(0).charAt(2)))][Integer.parseInt(String.valueOf(nums.get(0).charAt(0)))];
        nums.remove(0);
        int[] last = new int[full.length];


        for (int x = 0; x < full.length; x++) {
            full[x] = nums.get(x).split(" ");
        }

        for (int y = 0; y < full.length; y++) {
            int a = 0;
            for (int x = 0; x < full[0].length; x++) {
                a += Integer.parseInt(full[y][x]);
            }
            last[y] = a;
        }
        return last;
    }

    public static int[] columnSums(String fileName) {
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
        int[] last = new int[full[0].length];


        for (int x = 0; x < full.length; x++) {
            full[x] = nums.get(x).split(" ");
        }

        for (int x = 0; x < full[0].length; x++) {
            int a = 0;
            for (int y = 0; y < full.length; y++) {
                a += Integer.parseInt(full[y][x]);
            }
            last[x] = a;
        }
        return last;
    }

}