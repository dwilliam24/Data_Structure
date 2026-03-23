package TextEditor;

import javax.swing.*;

class ReplaceFrame extends JFrame {
    public ReplaceFrame(JTextArea target) {
        super("Replace All");
        setSize(350, 220);
        setLayout(null);
        setLocationRelativeTo(null);
        JTextField find = new JTextField();
        find.setBounds(120, 20, 180, 25);
        add(find);
        JTextField repl = new JTextField();
        repl.setBounds(120, 60, 180, 25);
        add(repl);
        JLabel l1 = new JLabel("Find: ");
        l1.setBounds(20, 20, 100, 25);
        add(l1);
        JLabel l2 = new JLabel("Replace: ");
        l2.setBounds(20, 60, 100, 25);
        add(l2);
        JButton rBtn = new JButton("Replace");
        rBtn.setBounds(40, 120, 110, 30);
        rBtn.addActionListener(e -> {
            target.setText(target.getText().replace(find.getText(), repl.getText()));
            dispose();
        });
        add(rBtn);
        JButton cBtn = new JButton("Cancel");
        cBtn.setBounds(170, 120, 110, 30);
        cBtn.addActionListener(e -> dispose());
        add(cBtn);
        setVisible(true);
    }
}