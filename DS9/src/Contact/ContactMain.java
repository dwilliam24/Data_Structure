package Contact;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ContactMain{
    public static void main(String[] args){
        ContactFrame frame = new  ContactFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                frame.saveContactsMeth();
                System.exit(0);
            }
        });
    }
}
