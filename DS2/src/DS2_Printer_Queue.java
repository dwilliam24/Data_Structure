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
        int jobSize = jobs.size();
        int totalPages = 0;
        int time=0;
        int idle =0;
        double jobTime =0;
        while (!jobs.isEmpty()){

            Job temp = jobs.poll();

            totalPages+=temp.getPages();
            if (time<temp.getSubmissionTime())
            {
                idle += temp.getSubmissionTime()-time;
                time = temp.getSubmissionTime();
            }


            temp.setPrintStart(temp.getSubmissionTime());
            System.out.println("\nTime "+temp.getPrintStart()+"s: Job #"+temp.getJobNumber()+" Received ("+temp.getPages()+" pages)");
            temp.setBufferingStart(time);
            temp.setBufferingEnd(temp.getBufferingStart()+3);
            System.out.println("Time "+temp.getBufferingStart()+"s: Job #"+temp.getJobNumber()+" Buffering Started");
            System.out.println("Time "+temp.getBufferingEnd()+"s: Job #"+temp.getJobNumber()+" Finished Buffering and Started Printing");
            temp.setPrintEnd(temp.getBufferingEnd()+(5*temp.getPages()));
            System.out.println("Time "+temp.getPrintEnd()+"s: Job #"+temp.getJobNumber()+" Finished Printing");
            time= temp.getPrintEnd();

            jobTime+=temp.getBufferingEnd()-temp.getPrintStart();
        }
        System.out.println("\nPrinting Simulation Complete.");
        System.out.println("Total Print Jobs: "+jobSize);
        System.out.println("Total Pages: "+ totalPages);
        System.out.printf("Average Job Wait Time: %1.1fs\n",jobTime/jobSize);
        System.out.println("Idle Time: "+idle+"s");

    }
}
