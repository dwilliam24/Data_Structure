package TextEditor;

import javax.swing.*;
import java.awt.*;

class FontFrame extends JFrame {
    public FontFrame(JTextArea target) {
        super("Font Settings");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        Font currentFont = target.getFont();
        String currentName = currentFont.getName();
        int currentSize = currentFont.getSize();

        String[] fonts = {"Arial", "Verdana", "Times New Roman", "Courier New", "Serif"};
        JComboBox<String> box = new JComboBox<>(fonts);
        box.setBounds(20, 20, 240, 30);

        box.setSelectedItem(currentName);
        add(box);

        JSpinner size = new JSpinner(new SpinnerNumberModel(currentSize, 8, 72, 1));
        size.setBounds(20, 60, 100, 30);
        add(size);

        JButton save = new JButton("Save");
        save.setBounds(20, 110, 100, 30);
        save.addActionListener(e -> {
            target.setFont(new Font((String)box.getSelectedItem(), Font.PLAIN, (int)size.getValue()));
            dispose();
        });
        add(save);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(130, 110, 100, 30);
        cancelBtn.addActionListener(e -> dispose());
        add(cancelBtn);

        setVisible(true);
    }
}