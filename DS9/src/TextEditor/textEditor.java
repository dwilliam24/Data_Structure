package TextEditor;

import javax.swing.*;
import java.util.ArrayList;

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
    private ArrayList<JPanel> JpanelTabs = new ArrayList<>();
    private ArrayList<JTextField> text = new ArrayList<>();

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
        JpanelTabs.add(new JPanel());

        for (int a=0; a<text.size(); a++){

            JpanelTabs.get(a).add(text.get(a));
            text.get(a).setBounds(10,101,10,10);
            JpanelTabs.get(a).setName(text.get(a).getName());

        }


        JpanelTabs.add(new JPanel());
        JpanelTabs.get(1).setBounds(10,10,10,10);
        JpanelTabs.get(1).setName("First");

        for (JPanel jpanelTab : JpanelTabs) {
            tabs.addTab(jpanelTab.getName(), jpanelTab);
        }
        tabs.setBounds(5,10,975,425);
        add(tabs);



        create.addActionListener(e-> createClicked());
        setVisible(true);
    }

    private void createClicked() {

    }
}
