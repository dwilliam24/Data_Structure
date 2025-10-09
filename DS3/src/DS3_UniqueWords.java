import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DS3_UniqueWords {
    public static void main(String[] args){
        System.out.println("Enter the file name: ");
        Scanner scanner = new Scanner(System.in);
        File name = new File(scanner.nextLine());
        ArrayList<String> a = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(name);
            while (fileScanner.hasNextLine()) {

                a.add(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> word = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            String[] temp = a.get(i).split(" ");
            for (int j = 0; j < temp.length; j++) {
                word.add(temp[j]);
            }
        }

        for (int i = 0; i < word.size(); i++) {
            word.set(i,word.get(i).toLowerCase());
            for (int j = 0; j < word.get(i).length(); j++) {
                if (".,-!_–?~’;:\"()".contains(word.get(i).charAt(j)+""))
                {
                    String t = "";
                    if (j==0) t= word.get(i).substring(j+1);
                    else if (j==word.get(i).length()-1) t=word.get(i).substring(0,j);
                    else if (word.get(i).charAt(j))
                    else t = word.get(i).substring(0,j)+word.get(i).substring(j+1);
                    word.set(i,t);
                }
            }
        }
        DS3_Set set = new DS3_Set<>();
        for (int i = 0; i < word.size(); i++) {
            if(!word.get(i).isBlank())set.add(word.get(i));
        }
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            System.out.println(iterator.next());
        }
    }
}
