import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DS3_Bank {
    public static void main(String[] args){
        DS3_Map<String,Double> accounts = new DS3_Map<>();

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

        ArrayList<String[]> list = new ArrayList<>();
        for (String s : a) {
            list.add(s.split(" "));
        }






        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0].equals("OPEN")){
                System.out.println("OPEN "+list.get(i)[1]);
                if (accounts.containsKey(list.get(i)[1])) System.out.println("\tAccount "+list.get(i)[1]+" already exists");
                else{
                    accounts.put(list.get(i)[1], 0.0);
                    System.out.println("\tAccount "+list.get(i)[1]+" opened with balance 0.0");
                }
            }

            else if (list.get(i)[0].equals("CLOSE")){
                System.out.println("CLOSE "+list.get(i)[1]);
                if (!accounts.containsKey(list.get(i)[1])) System.out.println("\tAccount not found for closing "+list.get(i)[1]);
                else{

                    accounts.remove(list.get(i)[1]);
                    System.out.println("\tAccount "+list.get(i)[1]+" closed");
                }
            }

            else if (list.get(i)[0].equals("DEPOSIT")){
                System.out.println("DEPOSIT "+list.get(i)[1]+" "+list.get(i)[2]);
                if (!accounts.containsKey(list.get(i)[1]))System.out.println("\tAccount not found for deposit into "+list.get(i)[1]);
                else {
                    double tempVal = accounts.get(list.get(i)[1]);
                    double newVal = tempVal+Double.parseDouble(list.get(i)[2]);
                    accounts.put(list.get(i)[1], newVal);
                    System.out.printf("\tDeposited %.1f into %s, new balance %.1f\n", Double.parseDouble(list.get(i)[2]),list.get(i)[1],newVal);
                }
            }

            else if (list.get(i)[0].equals("WITHDRAW")){
                System.out.println("WITHDRAW "+list.get(i)[1]+" "+list.get(i)[2]);
                if (!accounts.containsKey(list.get(i)[1]))System.out.println("\tAccount not found for withdrawal from "+list.get(i)[1]);
                else {
                    if (accounts.get(list.get(i)[1])-Double.parseDouble(list.get(i)[2])<0) System.out.println("\tInsufficient funds for withdrawal from "+list.get(i)[1]);
                    else {
                        Double tempVal = accounts.get(list.get(i)[1]);
                        Double newVal = tempVal- Double.parseDouble(list.get(i)[2]);
                        accounts.put(list.get(i)[1],newVal);
                        System.out.printf("\tWithdrew %.1f from %s, new balance %.1f\n",Double.parseDouble(list.get(i)[2]),list.get(i)[1],newVal);
                    }
                }
            }
        }
    }
}
/*

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                System.out.print(list.get(i)[j]+", ");
            }
            System.out.println();
        }
 */