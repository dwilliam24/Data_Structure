package Contact;

import javax.swing.*;

public class ContactFrame extends JFrame {
    private JLabel contacts = new JLabel("Contacts");

    private JList contactsList = new JList<Person>();

    private JScrollPane scrollPane;
    private JLabel firstName = new JLabel("First Name:");
    private JTextField frameFirstName = new JTextField();

    private JLabel lastName = new JLabel("Last Name:");
    private JTextField frameLastName = new JTextField();

    private JLabel phoneNumber = new JLabel("Phone Number:");
    private JTextField framePhoneNumber = new JTextField();

    private JLabel address = new JLabel("Address");
    private JTextField frameAddress = new JTextField();

    private JButton save = new JButton();
    private JButton delete = new JButton();
    private JButton clear = new JButton();
    ContactFrame(){
        super("Contact List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400,400);

        scrollPane= new JScrollPane(contactsList);
        scrollPane.setBounds(20,40,120,200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        firstName.setBounds(170,20,80,30);
        add(firstName);
        frameFirstName.setBounds(170,45,180,20);
        add(frameFirstName);

        lastName.setBounds(170,60,80,30);
        add(lastName);
        frameLastName.setBounds(170,85,180,20);
        add(frameLastName);

        phoneNumber.setBounds(170, 100, 80, 30);
        add(phoneNumber);
        framePhoneNumber.setBounds(170,125,180,20);
        add(framePhoneNumber);

        address.setBounds(170, 140, 80, 30);
        add(address);
        frameAddress.setBounds(170,165,180,20);
        add(frameAddress);

        save.setBounds(170, 200, 80, 30);
        save.setText("Save");
        save.addActionListener(e -> clickedSave());
        add(save);

        delete.setBounds(270, 200, 80, 30);
        delete.setText("Delete");
        delete.setEnabled(false);
        add(delete);


        setVisible(true);
    }

    private void clickedSave() {
        Person person = new Person(firstName.getText(),lastName.getText(), phoneNumber.getText(), address.getText());
        //contactsList.add(person);
    }
}
