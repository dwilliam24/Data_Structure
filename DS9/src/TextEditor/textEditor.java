package TextEditor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class textEditor extends JFrame {
    private JMenuBar bar = new JMenuBar();
    private JMenu file = new JMenu("File"), edit = new JMenu("Edit");
    private JMenuItem create = new JMenuItem("Create"), open = new JMenuItem("Open"),
            saveAs = new JMenuItem("Save As"), save = new JMenuItem("Save"),
            exit = new JMenuItem("Exit"), close = new JMenuItem("Close");
    private JMenuItem font = new JMenuItem("Font"), replace = new JMenuItem("Replace"),
            wordCount = new JMenuItem("Word Count");

    private JTabbedPane tabs = new JTabbedPane();
    private ArrayList<JTextArea> text = new ArrayList<>();
    private ArrayList<Boolean> saved = new ArrayList<>();
    private ArrayList<File> files = new ArrayList<>();

    private int unnamedCounter = 1;
    private final String PATH = "C:\\Users\\k2306075\\OneDrive - Katy Independent School District\\GitHub\\Data_Structure\\DS9\\src\\TextEditor\\Saves";

    public textEditor() {
        super("Text Editor");

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(1000, 500);
        setLayout(null);

        setJMenuBar(bar);
        bar.add(file);
        bar.add(edit);
        file.add(create);
        file.add(open);
        file.add(saveAs);
        file.add(save);
        file.addSeparator();
        file.add(close);
        file.add(exit);
        edit.add(font);
        edit.add(replace);
        edit.add(wordCount);

        tabs.setBounds(5, 10, 975, 425);
        add(tabs);

        create.addActionListener(e -> createClicked());
        open.addActionListener(e -> openClicked());
        save.addActionListener(e -> saveClicked());
        saveAs.addActionListener(e -> saveAsClicked());
        close.addActionListener(e -> closeClicked());
        exit.addActionListener(e -> exitClicked());
        wordCount.addActionListener(e -> wordCountClicked());

        font.addActionListener(e -> {
            int index = tabs.getSelectedIndex();
            if (index != -1) new FontFrame(text.get(index));
        });

        replace.addActionListener(e -> {
            int index = tabs.getSelectedIndex();
            if (index != -1) new ReplaceFrame(text.get(index));
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                exitClicked();
            }
        });

        openCheck();
        setVisible(true);
    }

    private void exitClicked() {
        if (saved.contains(false)) {
            Object[] options = {"Close anyway", "Cancel"};
            int choice = JOptionPane.showOptionDialog(null, "There are files that have not been saved, unsaved data will be lost. Are you sure you want to exit?", "Unsaved Changes", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
            if (choice == 0) System.exit(0);
        } else {
            System.exit(0);
        }
    }

    private void createClicked() {
        String name;
        File checkFile;

        while (true) {
            name = "Unnamed" + unnamedCounter;
            String fileName = name + ".txt";
            checkFile = new File(PATH + "\\" + fileName);

            boolean nameExistsInTabs = false;
            for (int i = 0; i < tabs.getTabCount(); i++) {
                String tabTitle = tabs.getTitleAt(i);
                if (tabTitle.endsWith("*")) tabTitle = tabTitle.substring(0, tabTitle.length() - 1);

                if (tabTitle.equalsIgnoreCase(name) || tabTitle.equalsIgnoreCase(fileName)) {
                    nameExistsInTabs = true;
                    break;
                }
            }
            if (!nameExistsInTabs && !checkFile.exists()) {
                break;
            }

            unnamedCounter++;
        }

        addTab(name, "", null, true);
    }

    private void openClicked() {
        JFileChooser chooser = new JFileChooser(PATH);
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            if (files.contains(selectedFile)) {
                int existingIndex = files.indexOf(selectedFile);

                tabs.setSelectedIndex(existingIndex);

                return;
            }

            addTab(selectedFile.getName(), "", selectedFile, true);

            int index = text.size() - 1;
            JTextArea area = text.get(index);
            String content = readFile(selectedFile, area);
            area.setText(content);

            saved.set(index, true);
            tabs.setTitleAt(index, selectedFile.getName());
        }
    }

    private void addTab(String title, String content, File fileRef, boolean isSavedInitial) {
        JTextArea area = new JTextArea(content);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        setupDocumentListener(area);

        JScrollPane scroll = new JScrollPane(area);
        tabs.addTab(title, scroll);
        text.add(area);
        files.add(fileRef);
        saved.add(isSavedInitial);
        tabs.setSelectedIndex(tabs.getTabCount() - 1);
        openCheck();
    }

    private void setupDocumentListener(JTextArea area) {
        area.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            private void changed() {
                int index = text.indexOf(area);
                if (index != -1 && saved.get(index)) {
                    saved.set(index, false);
                    String title = tabs.getTitleAt(index);
                    if (!title.endsWith("*")) tabs.setTitleAt(index, title + "*");
                }
            }
        });
    }

    private void saveClicked() {
        int index = tabs.getSelectedIndex();
        if (index == -1) return;

        String title = tabs.getTitleAt(index);
        if (title.endsWith("*")) title = title.substring(0, title.length() - 1);
        if (!title.toLowerCase().endsWith(".txt")) title += ".txt";

        File autoFile = new File(PATH + File.separator + title);
        performSave(autoFile, index, false);
    }

    private void saveAsClicked() {
        int index = tabs.getSelectedIndex();
        if (index == -1) return;

        JFileChooser chooser = new JFileChooser(PATH);
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (!file.getName().toLowerCase().endsWith(".txt")) file = new File(file.getAbsolutePath() + ".txt");
            performSave(file, index, true);
        }
    }

    private void performSave(File file, int index, boolean showPopup) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            JTextArea area = text.get(index);
            printWriter.println(area.getFont().getName() + "," + area.getFont().getSize());
            printWriter.print(area.getText());

            files.set(index, file);
            saved.set(index, true);
            tabs.setTitleAt(index, file.getName());
            if (showPopup) JOptionPane.showMessageDialog(this, "Saved.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void closeClicked() {
        int index = tabs.getSelectedIndex();
        if (index == -1) return;
        if (saved.get(index)) {
            removeTabData(index);
        } else {
            int choice = JOptionPane.showConfirmDialog(this,
                    "Unsaved data will be lost. Are you sure you want to close this file?",
                    "Confirm Close", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) removeTabData(index);
        }
        openCheck();
    }

    private void removeTabData(int index) {
        text.remove(index);
        saved.remove(index);
        files.remove(index);
        tabs.remove(index);
    }

    private void wordCountClicked() {
        int index = tabs.getSelectedIndex();
        if (index == -1) return;
        String content = text.get(index).getText().trim();
        int count;
        if (content.isEmpty()) {
            count = 0;
        } else {
            count = content.split("\\s+").length;
        }
        JOptionPane.showMessageDialog(this, "Word Count: " + count);
    }

    private String readFile(File f, JTextArea area) {
        StringBuilder text = new StringBuilder();
        try (Scanner scanner = new Scanner(f)) {
            if (scanner.hasNextLine()) {
                String header = scanner.nextLine();
                if (header.contains(",")) {
                    String[] parts = header.split(",");
                    area.setFont(new Font(parts[0], Font.PLAIN, Integer.parseInt(parts[1])));
                } else {
                    text.append(header).append("\n");
                }
            }
            while (scanner.hasNextLine()) text.append(scanner.nextLine()).append("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private void openCheck() {
        boolean active = tabs.getTabCount() > 0;
        save.setEnabled(active);
        saveAs.setEnabled(active);
        font.setEnabled(active);
        replace.setEnabled(active);
        wordCount.setEnabled(active);
    }
}