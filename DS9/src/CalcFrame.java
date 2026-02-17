import javax.swing.*;

public class CalcFrame extends JFrame {
    private JTextField lbl_operand1 = new JTextField();
    private JLabel lbl_Operation = new JLabel();
    private JLabel lbl_operand2 = new JLabel();

    private JButton btn_1 = new JButton("1");
    private JButton btn_2 = new JButton("2");
    private JButton btn_3 = new JButton("3");
    private JButton btn_4 = new JButton("4");
    private JButton btn_5 = new JButton("5");
    private JButton btn_6 = new JButton("6");
    private JButton btn_7 = new JButton("7");
    private JButton btn_8 = new JButton("8");
    private JButton btn_9 = new JButton("9");
    private JButton btn_0 = new JButton("0");
    private JButton btn_add = new JButton("+");
    private JButton btn_subtract = new JButton("-");
    private JButton btn_multiply = new JButton("*");
    private JButton btn_divide = new JButton("/");
    private JButton btn_equal = new JButton("=");
    private JButton btn_point = new JButton(".");
    private JButton btn_sign = new JButton("-/+");
    private JButton btn_clear = new JButton("C");

    public CalcFrame(){
        super("Calculator");
        setSize(330,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        lbl_operand2.setBounds(20,20,200,20);
        lbl_operand2.setHorizontalAlignment(JLabel.RIGHT);
        add(lbl_operand2);

        lbl_Operation.setBounds(200,40,20,20);
        lbl_Operation.setHorizontalAlignment(JLabel.RIGHT);
        add(lbl_Operation);

        lbl_operand1.setBounds(20 ,60, 200, 20);
        add(lbl_operand1);
        lbl_operand1.setHorizontalAlignment(JLabel.RIGHT);
        lbl_operand1.setEditable(false);

        btn_1.setBounds(20,100,60,60);
        add(btn_1);
        btn_1.addActionListener(e -> clicked1());
        btn_2.setBounds(90,100,60,60);
        btn_2.addActionListener(e -> clicked2());
        add(btn_2);
        btn_3.setBounds(160,100,60,60);
        btn_3.addActionListener(e -> clicked3());
        add(btn_3);
        btn_clear.setBounds(230, 100, 60,60);
        btn_clear.addActionListener(e -> clickedClear());
        add(btn_clear);

        btn_4.setBounds(20,170,60,60);
        btn_4.addActionListener(e -> clicked4());
        add(btn_4);
        btn_5.setBounds(90,170,60,60);
        btn_5.addActionListener(e -> clicked5());
        add(btn_5);
        btn_6.setBounds(160,170,60,60);
        btn_6.addActionListener(e -> clicked6());
        add(btn_6);
        btn_add.setBounds(230, 170, 60,60);
        btn_add.addActionListener(e -> clickedAdd());
        add(btn_add);

        btn_7.setBounds(20,240,60,60);
        btn_7.addActionListener(e -> clicked7());
        add(btn_7);
        btn_8.setBounds(90,240,60,60);
        btn_8.addActionListener(e -> clicked8());
        add(btn_8);
        btn_9.setBounds(160,240,60,60);
        btn_9.addActionListener(e -> clicked9());
        add(btn_9);
        btn_subtract.setBounds(230, 240, 60, 60);
        btn_subtract.addActionListener( e-> clickedSubtract());
        add(btn_subtract);

        btn_sign.setBounds(20,310,60,60);
        btn_sign.addActionListener(e -> clickedSign());
        add(btn_sign);
        btn_0.setBounds(90,310,60,60);
        btn_0.addActionListener(e -> clicked0());
        add(btn_0);
        btn_point.setBounds(160,310,60,60);
        btn_point.addActionListener(e -> clickedPoint());
        add(btn_point);
        btn_multiply.setBounds(230, 310, 60,60);
        btn_multiply.addActionListener(e -> clickedMultiply());
        add(btn_multiply);

        btn_equal.setBounds(20,380, 200, 60);
        btn_equal.addActionListener(e -> clickedEquals());
        add(btn_equal);
        btn_divide.setBounds(230, 380, 60, 60);
        btn_divide.addActionListener(e -> clickedDivide());
        add(btn_divide);

        setVisible(true);
    }

    private void clickedDivide() {
        if (lbl_operand1.getText().equals(".")||lbl_operand1.getText().equals("-")) return;
        if (!lbl_Operation.getText().equals("/")) lbl_Operation.setText("/");
        if (!lbl_operand2.getText().equals("")&&!lbl_operand1.getText().equals("")){
            double v1 = Double.parseDouble(lbl_operand1.getText());
            double v2 = Double.parseDouble(lbl_operand2.getText());

            lbl_operand2.setText(""+((v2/v1)));
            lbl_Operation.setText("/");
            lbl_operand1.setText("");
        } else if (!lbl_operand1.getText().equals("")) {
            lbl_operand2.setText(lbl_operand1.getText());
            lbl_Operation.setText("/");
            lbl_operand1.setText("");
        }
    }

    private void clickedMultiply() {
        if (lbl_operand1.getText().equals(".")||lbl_operand1.getText().equals("-")) return;
        if (!lbl_Operation.getText().equals("*")) lbl_Operation.setText("*");
        if (!lbl_operand2.getText().equals("")&&!lbl_operand1.getText().equals("")){
            double v1 = Double.parseDouble(lbl_operand1.getText());
            double v2 = Double.parseDouble(lbl_operand2.getText());

            lbl_operand2.setText(""+(v1*v2));
            lbl_Operation.setText("*");
            lbl_operand1.setText("");
        } else if (!lbl_operand1.getText().equals("")) {
            lbl_operand2.setText(lbl_operand1.getText());
            lbl_Operation.setText("*");
            lbl_operand1.setText("");
        }
    }

    private void clickedSubtract() {
        if (lbl_operand1.getText().equals(".")||lbl_operand1.getText().equals("-")) return;
        if (!lbl_Operation.getText().equals("-")) lbl_Operation.setText("-");
        if (!lbl_operand2.getText().equals("")&&!lbl_operand1.getText().equals("")){
            double v1 = Double.parseDouble(lbl_operand1.getText());
            double v2 = Double.parseDouble(lbl_operand2.getText());

            lbl_operand2.setText(""+((v2-v1)));
            lbl_Operation.setText("-");
            lbl_operand1.setText("");
        } else if (!lbl_operand1.getText().equals("")) {
            lbl_operand2.setText(lbl_operand1.getText());
            lbl_Operation.setText("-");
            lbl_operand1.setText("");
        }
    }

    private void clickedAdd() {
        if (lbl_operand1.getText().equals(".")||lbl_operand1.getText().equals("-")) return;
        if (!lbl_Operation.getText().equals("+")) lbl_Operation.setText("+");
        if (!lbl_operand2.getText().equals("")&&!lbl_operand1.getText().equals("")){
            double v1 = Double.parseDouble(lbl_operand1.getText());
            double v2 = Double.parseDouble(lbl_operand2.getText());

            lbl_operand2.setText(""+(v1+v2));
            lbl_Operation.setText("+");
            lbl_operand1.setText("");
        } else if (!lbl_operand1.getText().equals("")) {
            lbl_operand2.setText(lbl_operand1.getText());
            lbl_Operation.setText("+");
            lbl_operand1.setText("");
        }
    }

    private void clickedClear() {
        lbl_operand1.setText("");
        lbl_operand2.setText("");
        lbl_Operation.setText("");
    }

    private void clickedEquals() {
        if (lbl_operand2.getText().equals(".")||lbl_operand2.getText().equals("-")) return;
        if (!lbl_operand2.getText().equals("")&&!lbl_operand1.getText().equals("")){
            double v1 = Double.parseDouble(lbl_operand1.getText());
            double v2 = Double.parseDouble(lbl_operand2.getText());

            if (lbl_Operation.getText().equals("+")) {
                lbl_operand1.setText("" + (v1 + v2));
                lbl_Operation.setText("");
                lbl_operand2.setText("");
            }
            else if (lbl_Operation.getText().equals("-")) {
                lbl_operand1.setText("" + (v2 - v1));
                lbl_Operation.setText("");
                lbl_operand2.setText("");
            }
            else if (lbl_Operation.getText().equals("/")) {
                lbl_operand1.setText("" + (v2 / v1));
                lbl_Operation.setText("");
                lbl_operand2.setText("");
            }
            else if (lbl_Operation.getText().equals("*")) {
                lbl_operand1.setText("" + (v1 * v2));
                lbl_Operation.setText("");
                lbl_operand2.setText("");
            }
        }
    }

    private void clickedPoint() {
        if (!lbl_operand1.getText().contains("."))
            lbl_operand1.setText(lbl_operand1.getText()+".");
    }

    private void clickedSign() {
        if (lbl_operand1.getText().charAt(0)=='-'){
            lbl_operand1.setText(lbl_operand1.getText().substring(1));
        }else {
            lbl_operand1.setText("-" + lbl_operand1.getText());
        }
    }

    private void clicked0() {
        if (!lbl_operand1.getText().isEmpty()&&lbl_operand2.getText().isEmpty()){
            lbl_operand1.setText("0");
        }
        else lbl_operand1.setText(lbl_operand1.getText()+"0");
    }

    private void clicked9() {
        if (!lbl_operand1.getText().isEmpty()&&lbl_operand2.getText().isEmpty()){
            lbl_operand1.setText("9");
        }
        else lbl_operand1.setText(lbl_operand1.getText()+"9");
    }

    private void clicked8() {
        if (!lbl_operand1.getText().isEmpty()&&lbl_operand2.getText().isEmpty()){
            lbl_operand1.setText("8");
        }
        else lbl_operand1.setText(lbl_operand1.getText()+"8");
    }

    private void clicked7() {
        if (!lbl_operand1.getText().isEmpty()&&lbl_operand2.getText().isEmpty()){
            lbl_operand1.setText("7");
        }
        else lbl_operand1.setText(lbl_operand1.getText()+"7");
    }

    private void clicked6() {
        if (!lbl_operand1.getText().isEmpty()&&lbl_operand2.getText().isEmpty()){
            lbl_operand1.setText("6");
        }
        else lbl_operand1.setText(lbl_operand1.getText()+"6");
    }

    private void clicked5() {
        if (!lbl_operand1.getText().isEmpty()&&lbl_operand2.getText().isEmpty()){
            lbl_operand1.setText("5");
        }
        else lbl_operand1.setText(lbl_operand1.getText()+"5");
    }

    private void clicked4() {
        if (!lbl_operand1.getText().isEmpty()&&lbl_operand2.getText().isEmpty()){
            lbl_operand1.setText("4");
        }
        else lbl_operand1.setText(lbl_operand1.getText()+"4");
    }

    private void clicked3() {
        if (!lbl_operand1.getText().isEmpty()&&lbl_operand2.getText().isEmpty()){
            lbl_operand1.setText("3");
        }
        else lbl_operand1.setText(lbl_operand1.getText()+"3");
    }

    private void clicked2() {
        if (!lbl_operand1.getText().isEmpty()&&lbl_operand2.getText().isEmpty()){
            lbl_operand1.setText("2");
        }
        else lbl_operand1.setText(lbl_operand1.getText()+"2");
    }

    private void clicked1() {
        if (!lbl_operand1.getText().isEmpty()&&lbl_operand2.getText().isEmpty()){
            lbl_operand1.setText("1");
        }
        else lbl_operand1.setText(lbl_operand1.getText()+"1");
    }
}
