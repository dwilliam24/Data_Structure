import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DS2_Printer_Queue {
    public static void main(String[] args){
        MyQueue<Job> jobs = new MyQueue<>();
        System.out.print("Enter job file name: ");
        Scanner e = new Scanner(System.in);
        File file = new File(e.nextLine());
        e.close();

        try{
            Scanner fileScanner= new Scanner(file);
            int number = 0;
            while (fileScanner.hasNextLine()) {
                number++;
                String a = fileScanner.nextLine();
                jobs.offer(new Job(number, Integer.parseInt(a.split(",")[0]),Integer.parseInt(a.split(",")[1])));
            }
            fileScanner.close();
        }
        catch (Exception o){
            o.printStackTrace();
        }

        while (!jobs.isEmpty()){
            int time =0;
            
            Job temp = jobs.poll();
            System.out.println("Time "+temp.getPrintStart()+"s: Job #"+temp.getJobNumber()+" Received ("+temp.getPages()+" pages)");
            System.out.println("Time "+temp.getBufferingStart()+"s: Job #"+temp.getJobNumber()+" Buffering Started");
            System.out.println("Time "+temp.getBufferingEnd()+"s: Job #"+temp.getJobNumber()+" Finished Buffering and Started Printing");
            System.out.println("Time "+temp.getPrintEnd()+"s: Job #"+temp.getJobNumber()+" Finished Printing\n");
        }

    }
}
