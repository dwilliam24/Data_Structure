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
    private JComboBox flavorDrop;
    private JComboBox amountScoops;
    private JRadioButton chocolateSyrup = new JRadioButton("Chocolate Syrup (.75)");
    private JRadioButton carmelSyrup = new JRadioButton("Carmel Syrup (.75)");
    private JRadioButton mAndMs = new JRadioButton("M&M's (1.00)");
    private JRadioButton oreos = new JRadioButton("Oreos (1.00)");
    private JRadioButton peanutButterCup = new JRadioButton("Peanut Butter Cup (1.25)");
    private JRadioButton chocolateChip = new JRadioButton("Chocolate Chip (1.00)");
    private JRadioButton sprinkles = new JRadioButton("Sprinkles (.75)");

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
        bowl.setBounds(50,320,100,15);
        waffleBowl.setBounds(50,340,140,15);
        waffleCone.setBounds(50,360,140,15);
        chocoWaffleCone.setBounds(50,380,190,15);
        add(bowl);
        add(waffleBowl);
        add(waffleCone);
        add(chocoWaffleCone);
        add(scrollTable);

        String[] flavors = {"Vanilla","Cookies and Cream", "Chocolate" ,"Butter Pecan", "Strawberry", "Chocolate Chip Cookie Dough", "Coffee", "Cinnamon"};
        flavorDrop = new JComboBox(flavors);
        flavorDrop.setSelectedIndex(0);
        flavorDrop.setBounds(250, 320,100,20);
        add(flavorDrop);


        String[] num = {"1","2","3"};
        amountScoops = new JComboBox(num);
        amountScoops.setSelectedIndex(0);
        amountScoops.setBounds(400,320,100,20);
        add(amountScoops);

        carmelSyrup.setBounds(50,420,130,15);
        chocolateSyrup.setBounds(50,440,160,15);
        chocolateChip.setBounds(50,460,150,15);
        mAndMs.setBounds(50,480,130,15);
        oreos.setBounds(50,500,130,15);
        peanutButterCup.setBounds(50,520,170,15);
        sprinkles.setBounds(50,540,130,15);
        add(chocolateSyrup);
        add(carmelSyrup);
        add(chocolateChip);
        add(mAndMs);
        add(oreos);
        add(peanutButterCup);
        add(sprinkles);


        setVisible(true);
    }
}
