package Contact;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class ContactFrame extends JFrame{
    private JLabel contacts = new JLabel("Contacts:");
    private String file = "C:\\Users\\k2306075\\OneDrive - Katy Independent School District\\GitHub\\Data_Structure\\DS9\\Contacts.txt";

    private JScrollPane scrollPane;
    private JLabel firstName = new JLabel("First Name:");
    private JTextField frameFirstName = new JTextField();

    private JLabel lastName = new JLabel("Last Name:");
    private JTextField frameLastName = new JTextField();

    private JLabel phoneNumber = new JLabel("Phone Number:");
    private JTextField framePhoneNumber = new JTextField();

    private JLabel address = new JLabel("Address:");
    private JTextField frameAddress = new JTextField();

    private JButton save = new JButton();
    private JButton clear = new JButton();

    private JButton saveContacts = new JButton();
    private JButton deleteContacts = new JButton();
    private ArrayList<Person> contactArray = new ArrayList<>();

    private JList<Person> contactsList = new JList<>(contactArray.toArray(new Person[0]));

    ContactFrame() {
        super("Contact List");
        setLayout(null);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contacts.setBounds(20, 20, 100, 20);
        add(contacts);

        scrollPane = new JScrollPane(contactsList);
        scrollPane.setBounds(20, 40, 120, 200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        contactsList.addListSelectionListener(e -> SelectionClick());
        firstName.setBounds(170, 20, 80, 30);
        add(firstName);
        frameFirstName.setBounds(170, 45, 180, 20);
        add(frameFirstName);

        lastName.setBounds(170, 60, 80, 30);
        add(lastName);
        frameLastName.setBounds(170, 85, 180, 20);
        add(frameLastName);

        phoneNumber.setBounds(170, 100, 100, 30);
        add(phoneNumber);
        framePhoneNumber.setBounds(170, 125, 180, 20);
        add(framePhoneNumber);

        address.setBounds(170, 140, 80, 30);
        add(address);
        frameAddress.setBounds(170, 165, 180, 20);
        add(frameAddress);

        save.setBounds(170, 200, 80, 30);
        save.setText("Save");
        save.addActionListener(e -> clickedSave());
        add(save);

        clear.setBounds(270, 200, 80, 30);
        clear.setText("New");
        clear.addActionListener(e -> clearClicked());
        add(clear);

        saveContacts.setBounds(180, 200, 150, 30);
        saveContacts.setText("Save Changes");
        saveContacts.setVisible(false);
        saveContacts.addActionListener(e -> saveChangesClicked());
        add(saveContacts);

        deleteContacts.setBounds(180, 240, 150, 30);
        deleteContacts.setText("Delete Contact");
        deleteContacts.setVisible(false);
        deleteContacts.addActionListener(e -> deleteClicked());
        add(deleteContacts);

        ArrayList<String> a = null;
        try{
            File fileRef = new File(file);
            if (!fileRef.exists())
                fileRef.createNewFile();
            Scanner scanner = new Scanner(fileRef);
            a = new ArrayList<>();

            while (scanner.hasNextLine()) {
                a.add(scanner.nextLine());
            }
            scanner.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        for (int o = 0; o<a.size(); o++){
            contactArray.add(new Person(a.get(o).split("~")[0],a.get(o).split("~")[1],a.get(o).split("~")[2],a.get(o).split("~")[3]));
        }

        framePhoneNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }
            }
        });

        setVisible(true);
    }


    private void clearClicked() {

        frameFirstName.setText("");
        frameAddress.setText("");
        frameLastName.setText("");
        framePhoneNumber.setText("");
    }

    private void deleteClicked() {
        contactArray.remove(contactsList.getSelectedIndex());
        contactsList.setListData(contactArray.toArray(new Person[0]));

        frameFirstName.setText("");
        frameAddress.setText("");
        frameLastName.setText("");
        framePhoneNumber.setText("");
        save.setVisible(true);
        clear.setVisible(true);
        saveContacts.setVisible(false);
        deleteContacts.setVisible(false);
    }

    private void saveChangesClicked() {
        Person person = new Person(frameFirstName.getText(), frameLastName.getText(), framePhoneNumber.getText(), frameAddress.getText());
        contactArray.remove(contactsList.getSelectedIndex());
        contactArray.add(person);

        contactsList.setSelectedIndex(-1);
        contactsList.clearSelection();

        contactsList.setListData(contactArray.toArray(new Person[0]));

        frameFirstName.setText("");
        frameAddress.setText("");
        frameLastName.setText("");
        framePhoneNumber.setText("");
        save.setVisible(true);
        clear.setVisible(true);
        saveContacts.setVisible(false);
        deleteContacts.setVisible(false);
    }

    private void SelectionClick() {
        if (contactsList.getSelectedIndex() != -1) {
            frameFirstName.setText(contactsList.getSelectedValue().getFirstName());
            frameLastName.setText(contactsList.getSelectedValue().getLastName());
            framePhoneNumber.setText(contactsList.getSelectedValue().getPhoneNumber());
            frameAddress.setText(contactsList.getSelectedValue().getAddress());


            save.setVisible(false);
            clear.setVisible(false);
            saveContacts.setVisible(true);
            deleteContacts.setVisible(true);
        }
    }

    private void clickedSave() {
        if (contactsList.getSelectedIndex() == -1) {
            if (frameFirstName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "First Name is blank", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (frameLastName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Last Name is blank", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Person person = new Person(frameFirstName.getText(), frameLastName.getText(), framePhoneNumber.getText(), frameAddress.getText());
            contactArray.add(person);
            Collections.sort(contactArray);
            contactsList.setListData(contactArray.toArray(new Person[0]));
            frameFirstName.setText("");
            frameAddress.setText("");
            frameLastName.setText("");
            framePhoneNumber.setText("");
        }
    }
    private void saveContactsMeth(){
        try{
            File fileRef = new File(file);
            FileWriter fileWriter = new FileWriter(fileRef,false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int a =0; a<contactArray.size(); a++){
                Person contact = contactArray.get(a);
                printWriter.println(contact.getFirstName()+"~"+contact.getLastName()+"~"+contact.getPhoneNumber()+"~"+contact.getAddress());
            }
            fileWriter.close();
            printWriter.close();
            System.out.println("Save Complete.");
            System.out.println("Good bye.\n");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}