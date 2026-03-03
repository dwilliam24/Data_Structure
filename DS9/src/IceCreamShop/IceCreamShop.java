package IceCreamShop;

import javax.swing.*;
import java.util.ArrayList;

public class IceCreamShop extends JFrame {
    private JTable orderTable;
    private JScrollPane scrollTable;
    private ArrayList<String> heading = new ArrayList<>();
    private ButtonGroup group = new ButtonGroup();
    private JRadioButton bowl = new JRadioButton("Bowl (0.50)");
    private JRadioButton waffleBowl = new JRadioButton("Waffle Bowl (2.00)");
    private JRadioButton waffleCone = new JRadioButton("Waffle Cone (2.00)");
    private JRadioButton chocoWaffleCone = new JRadioButton("Chocolate Waffle Cone (3.50)");


    public IceCreamShop(){
        super("Ice Cream Shop");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        heading.add("Container");
        heading.add("Flavor");
        heading.add("# of scoops");
        heading.add("Toppings");
        heading.add("Cost");
        orderTable = new JTable(new String[0][5],heading.toArray());
        scrollTable = new JScrollPane(orderTable);
        scrollTable.setBounds(40,35,500,250);
        group.add(bowl);
        group.add(waffleBowl);
        group.add(waffleCone);
        group.add(chocoWaffleCone);
        bowl.setBounds(50,300,100,15);
        waffleBowl.setBounds(50,320,140,15);
        waffleCone.setBounds(50,340,140,15);
        chocoWaffleCone.setBounds(50,360,190,15);
        add(bowl);
        add(waffleBowl);
        add(waffleCone);
        add(chocoWaffleCone);
        add(scrollTable);
        setVisible(true);
    }
}
