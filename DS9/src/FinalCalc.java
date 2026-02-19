import javax.swing.*;

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
    public FinalCalc() {
        super("Final Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(300, 450);

        totalTermWeight.setBounds(20, 10, 150, 30);
        totalTermWeight.setText("Total Term Weight:");
        add(totalTermWeight);

        frameTotalTermWeight.setBounds(140, 15, 120, 25);
        add(frameTotalTermWeight);

        finalWeight.setBounds(20, 40, 150, 30);
        finalWeight.setText("Final Weight:");
        add(finalWeight);

        frameFinalWeight.setBounds(140, 45, 120, 25);
        add(frameFinalWeight);

        numberOfTerms.setBounds(20, 70, 150, 30);
        numberOfTerms.setText("Number of Terms:");
        add(numberOfTerms);

        Integer[] num = {1,2,3,4,5};
        frameNumberOfTerms = new JComboBox<>(num);
        frameNumberOfTerms.setBounds(140, 75, 120, 25);
        frameNumberOfTerms.addActionListener(e -> changeTerms());
        add(frameNumberOfTerms);

        gradeWanted.setBounds(20, 100, 150, 30);
        gradeWanted.setText("Grade Wanted:");
        add(gradeWanted);

        frameGradeWanted.setBounds(140, 105, 120, 25);
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
        add(calc);

        clear.setBounds(10, 330, 265, 20);
        clear.setText("Clear");
        add(clear);

        description.setBounds(45, 360, 265, 20);
        description.setText("Calculate Grade Required On Final");
        add(description);

        setVisible(true);
    }

    private void changeTerms() {
        for (int a=4; a>((Integer) frameNumberOfTerms.getSelectedItem()-1); a--){
            System.out.println("a");
        }
    }
}
