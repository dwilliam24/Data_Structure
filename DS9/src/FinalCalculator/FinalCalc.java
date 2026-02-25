package FinalCalculator;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FinalCalc extends JFrame {
    private JLabel totalTermWeight = new JLabel();
    private JTextField frameTotalTermWeight = new JTextField();
    private JLabel finalWeight = new JLabel();
    private JTextField frameFinalWeight = new JTextField();
    private JLabel numberOfTerms = new JLabel();
    private JComboBox<Integer> frameNumberOfTerms;
    private JLabel gradeWanted = new JLabel();
    private JTextField frameGradeWanted = new JTextField();
    private JLabel term1 = new JLabel();
    private JTextField frameTerm1 = new JTextField();
    private JLabel term2 = new JLabel();
    private JTextField frameTerm2 = new JTextField();
    private JLabel term3 = new JLabel();
    private JTextField frameTerm3 = new JTextField();
    private JLabel term4 = new JLabel();
    private JTextField frameTerm4 = new JTextField();
    private JLabel term5 = new JLabel();
    private JTextField frameTerm5 = new JTextField();

    private JButton calc = new JButton();
    private JButton clear = new JButton();

    private JLabel description = new JLabel();
    private JLabel finalGrade = new JLabel();

    private int grades =0;
    public FinalCalc() {
        super("Final Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(300, 450);

        totalTermWeight.setBounds(20, 10, 150, 30);
        totalTermWeight.setText("Total Term Weight:");
        add(totalTermWeight);


        frameTotalTermWeight.setBounds(140, 15, 120, 25);
        frameTotalTermWeight.setText("85");
        add(frameTotalTermWeight);

        finalWeight.setBounds(20, 40, 150, 30);
        finalWeight.setText("Final Weight:");
        add(finalWeight);

        frameFinalWeight.setBounds(140, 45, 120, 25);
        frameFinalWeight.setText("15");
        add(frameFinalWeight);

        numberOfTerms.setBounds(20, 70, 150, 30);
        numberOfTerms.setText("Number of Terms:");
        add(numberOfTerms);

        Integer[] num = {1,2,3,4,5};
        frameNumberOfTerms = new JComboBox<>(num);
        frameNumberOfTerms.setBounds(140, 75, 120, 25);
        frameNumberOfTerms.addActionListener(e -> changeTerms());
        frameNumberOfTerms.setSelectedIndex(0);
        add(frameNumberOfTerms);

        gradeWanted.setBounds(20, 100, 150, 30);
        gradeWanted.setText("Grade Wanted:");
        add(gradeWanted);

        frameGradeWanted.setBounds(140, 105, 120, 25);
        frameGradeWanted.setText("90");
        add(frameGradeWanted);

        term1.setBounds(20, 145, 150, 30);
        term1.setText("Term 1 Grade:");
        add(term1);

        frameTerm1.setBounds(140, 150, 120, 25);
        add(frameTerm1);

        term2.setBounds(20, 175, 150, 30);
        term2.setText("Term 2 Grade:");
        add(term2);

        frameTerm2.setBounds(140, 180, 120, 25);
        add(frameTerm2);

        term3.setBounds(20, 205, 150, 30);
        term3.setText("Term 3 Grade:");
        add(term3);

        frameTerm3.setBounds(140, 210, 120, 25);
        add(frameTerm3);

        term4.setBounds(20, 235, 150, 30);
        term4.setText("Term 4 Grade:");
        add(term4);

        frameTerm4.setBounds(140, 240, 120, 25);
        add(frameTerm4);

        term5.setBounds(20, 265, 150, 30);
        term5.setText("Term 5 Grade:");
        add(term5);

        frameTerm5.setBounds(140, 270, 120, 25);
        add(frameTerm5);


        calc.setBounds(10, 300, 265, 20);
        calc.setText("Calculate");
        calc.addActionListener(e -> calcClicked());
        add(calc);

        clear.setBounds(10, 330, 265, 20);
        clear.setText("Clear");
        clear.addActionListener(e -> clearClicked());
        add(clear);

        description.setBounds(45, 360, 265, 20);
        description.setText("Calculate Grade Required On Final");
        add(description);

        finalGrade.setBounds(55,380,265,20);
        add(finalGrade);
        setVisible(true);
    }

    private void calcClicked() {
        if (frameGradeWanted.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Grade wanted is blank!", "Error", JOptionPane.ERROR_MESSAGE);
            finalGrade.setText("");
            return;
        }
        if (frameTotalTermWeight.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Term Weight is blank!", "Error", JOptionPane.ERROR_MESSAGE);
            finalGrade.setText("");
            return;
        }
        if (frameFinalWeight.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Final Weight is blank!", "Error", JOptionPane.ERROR_MESSAGE);
            finalGrade.setText("");
            return;
        }
        double wanted = Double.parseDouble(frameGradeWanted.getText());
        int termWeight = Integer.parseInt(frameTotalTermWeight.getText());
        int finalWeight = Integer.parseInt(frameFinalWeight.getText());
        if (termWeight+finalWeight!=100) {
            JOptionPane.showMessageDialog(null, "Weights do not add up to 100!", "Error", JOptionPane.ERROR_MESSAGE);
            finalGrade.setText("");
            return;
        }

        double grade =0;
        if (frameNumberOfTerms.getSelectedIndex()==0){
            if (frameTerm1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 1 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            grade = Integer.parseInt(frameTerm1.getText());
        }
        else if (frameNumberOfTerms.getSelectedIndex()==1){
            if (frameTerm1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 1 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            if (frameTerm2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 2 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            grade = Double.parseDouble(frameTerm1.getText());
            grade += Double.parseDouble(frameTerm2.getText());
        }
        else if (frameNumberOfTerms.getSelectedIndex()==2){
            if (frameTerm1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 1 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            if (frameTerm2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 2 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            if (frameTerm3.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 3 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            grade = Double.parseDouble(frameTerm1.getText());
            grade += Double.parseDouble(frameTerm2.getText());
            grade += Double.parseDouble(frameTerm3.getText());
        }
        else if (frameNumberOfTerms.getSelectedIndex()==3){
            if (frameTerm1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 1 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            if (frameTerm2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 2 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            if (frameTerm3.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 3 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            if (frameTerm4.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 4 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            grade = Double.parseDouble(frameTerm1.getText());
            grade += Double.parseDouble(frameTerm2.getText());
            grade += Double.parseDouble(frameTerm3.getText());
            grade += Double.parseDouble(frameTerm4.getText());
        }
        else if (frameNumberOfTerms.getSelectedIndex()==4){
            if (frameTerm1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 1 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            if (frameTerm2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 2 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            if (frameTerm3.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 3 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            if (frameTerm4.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 4 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            if (frameTerm5.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Term 5 is blank!", "Error", JOptionPane.ERROR_MESSAGE);
                finalGrade.setText("");
                return;
            }
            grade = Double.parseDouble(frameTerm1.getText());
            grade += Double.parseDouble(frameTerm2.getText());
            grade += Double.parseDouble(frameTerm3.getText());
            grade += Double.parseDouble(frameTerm4.getText());
            grade += Double.parseDouble(frameTerm5.getText());
        }

        double avg = grade/grades;


        double needed = (wanted-(avg*((double) termWeight /100)))/((double) finalWeight /100);
        finalGrade.setText(String.valueOf(needed));

    }

    private void clearClicked() {
        frameTerm1.setText("");
        frameTerm2.setText("");
        frameTerm3.setText("");
        frameTerm4.setText("");
        frameTerm5.setText("");
    }

    private void changeTerms() {
        if (frameNumberOfTerms.getSelectedIndex()==0){
            term1.setEnabled(true);
            frameTerm1.setEnabled(true);
            term2.setEnabled(false);
            frameTerm2.setEnabled(false);
            term3.setEnabled(false);
            frameTerm3.setEnabled(false);
            term4.setEnabled(false);
            frameTerm4.setEnabled(false);
            term5.setEnabled(false);
            frameTerm5.setEnabled(false);
            frameTerm2.setText("");
            frameTerm3.setText("");
            frameTerm4.setText("");
            frameTerm5.setText("");
            grades=1;
        }
        else if (frameNumberOfTerms.getSelectedIndex()==1){
            term1.setEnabled(true);
            frameTerm1.setEnabled(true);
            term2.setEnabled(true);
            frameTerm2.setEnabled(true);
            term3.setEnabled(false);
            frameTerm3.setEnabled(false);
            term4.setEnabled(false);
            frameTerm4.setEnabled(false);
            term5.setEnabled(false);
            frameTerm5.setEnabled(false);
            frameTerm3.setText("");
            frameTerm4.setText("");
            frameTerm5.setText("");
            grades=2;
        }
        else if (frameNumberOfTerms.getSelectedIndex()==2){
            term1.setEnabled(true);
            frameTerm1.setEnabled(true);
            term2.setEnabled(true);
            frameTerm2.setEnabled(true);
            term3.setEnabled(true);
            frameTerm3.setEnabled(true);
            term4.setEnabled(false);
            frameTerm4.setEnabled(false);
            term5.setEnabled(false);
            frameTerm5.setEnabled(false);
            frameTerm4.setText("");
            frameTerm5.setText("");
            grades=3;
        }
        else if (frameNumberOfTerms.getSelectedIndex()==3){
            term1.setEnabled(true);
            frameTerm1.setEnabled(true);
            term2.setEnabled(true);
            frameTerm2.setEnabled(true);
            term3.setEnabled(true);
            frameTerm3.setEnabled(true);
            term4.setEnabled(true);
            frameTerm4.setEnabled(true);
            term5.setEnabled(false);
            frameTerm5.setEnabled(false);
            frameTerm5.setText("");
            grades=4;
        }
        else if (frameNumberOfTerms.getSelectedIndex()==4){
            term1.setEnabled(true);
            frameTerm1.setEnabled(true);
            term2.setEnabled(true);
            frameTerm2.setEnabled(true);
            term3.setEnabled(true);
            frameTerm3.setEnabled(true);
            term4.setEnabled(true);
            frameTerm4.setEnabled(true);
            term5.setEnabled(true);
            frameTerm5.setEnabled(true);
            grades=5;
        }
        frameTotalTermWeight.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }

            }
        });
        frameGradeWanted.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }

            }
        });
        frameFinalWeight.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }

            }
        });


        frameTerm1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = frameTerm1.getText();

                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }

                if (c == '.' && text.contains(".")) {
                    e.consume();
                }
            }
        });
        frameTerm2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = frameTerm2.getText();

                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }

                if (c == '.' && text.contains(".")) {
                    e.consume();
                }
            }
        });
        frameTerm3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = frameTerm3.getText();

                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }

                if (c == '.' && text.contains(".")) {
                    e.consume();
                }
            }
        });
        frameTerm4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = frameTerm4.getText();

                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }

                if (c == '.' && text.contains(".")) {
                    e.consume();
                }
            }
        });
        frameTerm5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = frameTerm5.getText();

                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }

                if (c == '.' && text.contains(".")) {
                    e.consume();
                }
            }
        });
    }

}
