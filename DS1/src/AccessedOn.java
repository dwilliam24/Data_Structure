import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class AccessedOn {
    public static void main(String[] args){
        try{
            File fileRef = new File("C:\\Users\\k2306075\\OneDrive - Katy Independent School District\\GitHub\\Data_Structure\\DS1\\AccessedOn.txt");
            if(!fileRef.exists())
                fileRef.createNewFile();
            FileWriter fileWriter = new FileWriter(fileRef,true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            ZonedDateTime date = ZonedDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z u");

            printWriter.println(date.format(formatter));
            fileWriter.close();
            printWriter.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
            System.exit(0);
        }

    }
}
