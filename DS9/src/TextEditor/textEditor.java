package TextEditor;

import javax.swing.*;
import java.util.ArrayList;

public class textEditor extends JFrame {
    private JMenuBar bar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenu edit = new JMenu("Edit");
    private JTabbedPane tabs = new JTabbedPane();
    private ArrayList<JPanel> JpanelTabs = new ArrayList<>();

    public textEditor(){
        super("Text Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,500);
        setLayout(null);

        setJMenuBar(bar);
        bar.setDoubleBuffered(true);
        bar.add(file);
        bar.add(edit);
        file.add("Create");
        file.add("Open");
        file.add("Save As");
        file.add("Save");
        file.add("Exit");
        edit.add("Font");
        edit.add("Replace");
        edit.add("Word Count");
        JpanelTabs.add(new JPanel());
        JpanelTabs.get(0).add(new JTextField());
        JpanelTabs.get(0).setName("First");
        JpanelTabs.add(new JPanel());
        JpanelTabs.get(1).setBounds(10,10,10,10);
        JpanelTabs.get(1).setName("First");

        for (JPanel jpanelTab : JpanelTabs) {
            tabs.addTab(jpanelTab.getName(), jpanelTab);
        }
        tabs.setBounds(5,10,975,425);
        add(tabs);

        setVisible(true);
    }
}
