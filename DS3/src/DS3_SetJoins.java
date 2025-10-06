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
         int[] array1 = new int[set1.size()];
         for(int i=0; i<set1.size();i++) {
             array1[i]=iterator1.next();

         }
         System.out.println(Arrays.toString(array1));
         System.out.print("Set B: ");
         Iterator<Integer> iterator2 = set2.iterator();
         int[] array2 = new int[set2.size()];
         for(int i=0; i<set2.size();i++) {
             array2[i]=iterator2.next();

         }
         System.out.println(Arrays.toString(array2));

         ArrayList<Integer> union = new ArrayList<>();
         ArrayList<Integer> overlap = new ArrayList<>();
         ArrayList<Integer> A = new ArrayList<>();
         ArrayList<Integer> B = new ArrayList<>();
         for (int i = 0; i < array1.length; i++) {
             union.add(array1[i]);
             if ()
         }
         for (int i = 0; i < array2.length; i++) {
             if(!union.contains(array2[i]))union.add(array2[i]);
             else overlap.add(array2[i]);
         }
         Collections.sort(union);
         System.out.println("\nUnion: "+union);
         System.out.println("Intersection: "+overlap);
         System.out.println("A - B (Elements in A not in B): ");


     }


}
