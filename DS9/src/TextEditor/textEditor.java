package TextEditor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class textEditor extends JFrame {
    private JMenuBar bar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenuItem create = new JMenuItem("Create");
    private JMenuItem open = new JMenuItem("Open");
    private JMenuItem saveAs = new JMenuItem("Save As");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem close = new JMenuItem("Close");
    private JMenu edit = new JMenu("Edit");
    private JMenuItem font = new JMenuItem("Font");
    private JMenuItem replace = new JMenuItem("Replace");
    private JMenuItem wordCount = new JMenuItem("Word Count");
    private JTabbedPane tabs = new JTabbedPane();
    private ArrayList<JTextArea> text = new ArrayList<>();

    public textEditor(){
        super("Text Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,500);
        setLayout(null);
        setJMenuBar(bar);
        bar.setDoubleBuffered(true);
        bar.add(file);
        bar.add(edit);
        file.add(create);
        file.add(open);
        file.add(saveAs);
        file.add(save);
        file.add(exit);
        file.add(close);
        edit.add(font);
        edit.add(replace);
        edit.add(wordCount);
        tabs.setBounds(5,10,975,425);
        add(tabs);







        open.addActionListener(e-> openCLicked());
        create.addActionListener(e-> createClicked());
        setVisible(true);
    }

    private void openCLicked() {
        JFileChooser fileOpen = new JFileChooser("C:\\Users\\k2306075\\OneDrive - Katy Independent School District\\GitHub\\Data_Structure\\DS9\\src\\TextEditor\\Saves");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileOpen.setFileFilter(filter);
        int result = fileOpen.showOpenDialog(null);
        if (result==JFileChooser.APPROVE_OPTION){
            File selectedFile = fileOpen.getSelectedFile();
            ArrayList<String> textRaw =  getFile(selectedFile);

            String temp ="";
            for (int x=0; x<textRaw.size(); x++){
                temp+=textRaw.get(x)+"\n";
            }

            JTextArea b = new JTextArea();
            b.setBounds(100,100,500,1000);
            b.setLineWrap(true);
            b.setText(temp);
            JScrollPane c = new JScrollPane(b);
            c.setName(selectedFile.getName());
            c.setBounds(100,100,500,1000);
            tabs.add(c,CENTER_ALIGNMENT);
            text.add(b);
        }
    }

    private void createClicked() {
        JTextArea b = new JTextArea();
        b.setBounds(100,100,500,1000);
        b.setLineWrap(true);
        JScrollPane c = new JScrollPane(b);
        c.setName("Untitled");
        c.setBounds(100,100,500,1000);
        tabs.add(c,CENTER_ALIGNMENT);
        text.add(b);
    }

    private ArrayList<String> getFile(File filePath){
        try{
            Scanner scanner = new Scanner(filePath);
            ArrayList<String> list = new ArrayList<>();

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
