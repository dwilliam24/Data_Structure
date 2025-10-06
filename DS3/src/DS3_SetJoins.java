import java.io.File;
import java.util.*;

public class DS3_SetJoins {
     public static void main(String[] args) {
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
         DS3_Set<Integer> set1 = new DS3_Set();
         DS3_Set<Integer> set2 = new DS3_Set();
         String[] p = a.get(0).split(" ");
         for (int i = 0; i < p.length; i++) {
             set1.add(Integer.parseInt(p[i]));
         }
         String[] f = a.get(1).split(" ");
         for (int i = 0; i < f.length; i++) {
             set2.add(Integer.parseInt(f[i]));
         }
         System.out.print("Set A: ");
         Iterator<Integer> iterator1 = set1.iterator();
         ArrayList<Integer> array1 = new ArrayList<>();
         for(int i=0; i<set1.size();i++) {
             array1.add(iterator1.next());

         }
         System.out.println(array1);
         System.out.print("Set B: ");
         Iterator<Integer> iterator2 = set2.iterator();
         ArrayList<Integer> array2 = new ArrayList<>();
         for(int i=0; i<set2.size();i++) {
             array2.add(iterator2.next());

         }
         System.out.println(array2);

         ArrayList<Integer> union = new ArrayList<>();
         ArrayList<Integer> overlap = new ArrayList<>();
         ArrayList<Integer> A = new ArrayList<>();
         ArrayList<Integer> B = new ArrayList<>();
         for (int i = 0; i < array1.size(); i++) {
             union.add(array1.get(i));
         }
         for (int i = 0; i < array2.size(); i++) {
             if(!union.contains(array2.get(i)))union.add(array2.get(i));
             else overlap.add(array2.get(i));
         }
         for (int i = 0; i < array1.size(); i++) {
             if (!array2.contains(array1.get(i))) A.add(array1.get(i));
         }
         for (int i = 0; i < array2.size(); i++) {
             if(!array1.contains(array2.get(i))) B.add(array2.get(i));
         }

         Collections.sort(union);
         System.out.println("\nUnion: "+union);
         System.out.println("Intersection: "+overlap);
         System.out.println("A - B (Elements in A not in B): "+A);
         System.out.println("B - A (Elements in B not in A): "+ B);

     }


}
