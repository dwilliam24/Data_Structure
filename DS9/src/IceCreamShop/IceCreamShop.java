package IceCreamShop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class IceCreamShop extends JFrame {
    private DefaultTableModel model;
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
    private JCheckBox chocolateSyrup = new JCheckBox("Chocolate Syrup (.75)");
    private JCheckBox carmelSyrup = new JCheckBox("Carmel Syrup (.75)");
    private JCheckBox mAndMs = new JCheckBox("M&M's (1.00)");
    private JCheckBox oreos = new JCheckBox("Oreos (1.00)");
    private JCheckBox peanutButterCup = new JCheckBox("Peanut Butter Cup (1.25)");
    private JCheckBox chocolateChip = new JCheckBox("Chocolate Chip (1.00)");
    private JCheckBox sprinkles = new JCheckBox("Sprinkles (.75)");

    private JLabel container = new JLabel("Container:");
    private JLabel flavor = new JLabel("Flavor:");
    private JLabel scoops = new JLabel("# of Scoops:");
    private JLabel toppings = new JLabel("Toppings:");
    private JLabel orderTableHead = new JLabel("Orders:");

    private JButton add = new JButton("Add");
    private JButton save = new JButton("Save");
    private JButton delete = new JButton("Delete");

    private ArrayList<IceCream> orders = new ArrayList<>();

    private ArrayList<String> toppingsSelected = new ArrayList<>();

    private JLabel subTotalName = new JLabel("Sub Total:");
    private JTextField subTotal = new JTextField();

    private JLabel taxName = new JLabel("Tax:");
    private JTextField tax = new JTextField();

    private JLabel totalName = new JLabel("Total:");
    private JTextField total = new JTextField();
    private int containerSelected = 0;
    private double totalCost =0;
    public IceCreamShop() {
        super("Ice Cream Shop");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        orderTableHead.setBounds(250, 15, 100, 15);
        add(orderTableHead);
        heading.add("Container");
        heading.add("Flavor");
        heading.add("# of scoops");
        heading.add("Toppings");
        heading.add("Cost");
        model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable ( int row, int column){
            return false;
        }
        };
        for (String col : heading) {
            model.addColumn(col);
        }
        orderTable = new JTable(model);
        scrollTable = new JScrollPane(orderTable);
        scrollTable.setBounds(40,35,500,250);
        orderTable.setRowSelectionAllowed(true);
        orderTable.getTableHeader().setReorderingAllowed(false);
        orderTable.getTableHeader().setResizingAllowed(false);

        container.setBounds(50,300,100,15);
        add(container);
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

        flavor.setBounds(250, 300,180,20);
        add(flavor);
        String[] flavors = {"Vanilla","Cookies and Cream", "Chocolate" ,"Butter Pecan", "Strawberry", "Chocolate Chip Cookie Dough", "Coffee", "Cinnamon"};
        flavorDrop = new JComboBox(flavors);
        flavorDrop.setSelectedIndex(0);
        flavorDrop.setBounds(250, 320,180,20);
        add(flavorDrop);

        scoops.setBounds(470,300,100,20);
        add(scoops);
        String[] num = {"1 (3.00)","2 (5.50)","3 (7.00)"};
        amountScoops = new JComboBox(num);
        amountScoops.setSelectedIndex(0);
        amountScoops.setBounds(470,320,100,20);
        add(amountScoops);

        toppings.setBounds(50,400,130,15);
        add(toppings);
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

        add.setBounds(230,500,80,30);
        add(add);
        save.setBounds(230,500,80,30);
        add(save);
        save.setVisible(false);
        delete.setBounds(320,500,80,30);
        add(delete);

        subTotalName.setBounds(470,400,80,20);
        add(subTotalName);
        subTotal.setEditable(false);
        subTotal.setText(String.format("%.2f",totalCost));
        subTotal.setBounds(470,420,80,20);
        add(subTotal);
        taxName.setBounds(470,440,80,20);
        add(taxName);
        tax.setBounds(470,460,80,20);
        tax.setEditable(false);
        tax.setText(String.format("%.2f",totalCost*0.0825));
        add(tax);
        totalName.setBounds(470,480,80,20);
        add(totalName);
        total.setBounds(470,500,80,20);
        total.setEditable(false);
        total.setText(String.format("%.2f",totalCost+(totalCost*0.0825)));
        add(total);


        bowl.addActionListener(e->bowlClicked());
        waffleBowl.addActionListener(e -> waffleBowlClicked());
        waffleCone.addActionListener(e -> waffleConeClicked());
        chocoWaffleCone.addActionListener(e -> chocoWaffleConeClicked());
        chocolateSyrup.addActionListener(e -> chocolateSyrupClicked());
        carmelSyrup.addActionListener(e -> caramelSyrupClicked());
        mAndMs.addActionListener(e -> mAndMsClicked());
        oreos.addActionListener(e -> oreosClicked());
        peanutButterCup.addActionListener(e -> peanutButterCupClicked());
        chocolateChip.addActionListener(e -> chocolateChipClicked());
        sprinkles.addActionListener(e -> sprinklesClicked());
        add.addActionListener(e-> addClicked());
        delete.addActionListener(e->deleteClicked());
        save.addActionListener(e-> saveClicked());
        orderTable.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent evt) {
            int row = orderTable.rowAtPoint(evt.getPoint());
            if (row != -1) {
                    bowl.setSelected(true);
                    flavorDrop.setSelectedIndex(0);
                    amountScoops.setSelectedIndex(0);
                    chocolateSyrup.setSelected(false);
                    carmelSyrup.setSelected(false);
                    mAndMs.setSelected(false);
                    oreos.setSelected(false);
                    peanutButterCup.setSelected(false);
                    chocolateChip.setSelected(false);
                    sprinkles.setSelected(false);
                    rowClicked(row);
                }
            }
        });
        setVisible(true);
        bowl.setSelected(true);
        delete.setEnabled(false);
    }

    private void saveClicked() {
        orders.remove(orderTable.getSelectedRow());
        if (bowl.isSelected()) totalCost+=.5;
        else if (waffleBowl.isSelected()) totalCost+=2;
        else if (waffleCone.isSelected()) totalCost+=2;
        else if (chocoWaffleCone.isSelected()) totalCost+=3.5;

        if (amountScoops.getSelectedIndex()==0){
            totalCost+=3;
        }
        else if (amountScoops.getSelectedIndex()==1){
            totalCost+=5.5;
        }
        else if (amountScoops.getSelectedIndex()==2){
            totalCost+=7;
        }
        orders.add(new IceCream((String) flavorDrop.getSelectedItem(), containerSelected,amountScoops.getSelectedIndex(),toppingsSelected,totalCost));
        totalCost=0;
        add.setVisible(true);
        save.setVisible(false);
        update();
        totalCost=0;
        update();

        bowl.setSelected(true);
        flavorDrop.setSelectedIndex(0);
        amountScoops.setSelectedIndex(0);
        chocolateSyrup.setSelected(false);
        carmelSyrup.setSelected(false);
        mAndMs.setSelected(false);
        oreos.setSelected(false);
        peanutButterCup.setSelected(false);
        chocolateChip.setSelected(false);
        sprinkles.setSelected(false);
        delete.setEnabled(false);
    }

    private void deleteClicked() {
        orders.remove(orderTable.getSelectedRow());
        update();
        totalCost=0;

        bowl.setSelected(true);
        flavorDrop.setSelectedIndex(0);
        amountScoops.setSelectedIndex(0);
        chocolateSyrup.setSelected(false);
        carmelSyrup.setSelected(false);
        mAndMs.setSelected(false);
        oreos.setSelected(false);
        peanutButterCup.setSelected(false);
        chocolateChip.setSelected(false);
        sprinkles.setSelected(false);
        delete.setEnabled(false);
        add.setVisible(true);
        save.setVisible(false);
    }

    private void addClicked() {
        if (bowl.isSelected()) totalCost+=0.5;
        else if (waffleBowl.isSelected()) totalCost+=2;
        else if (waffleCone.isSelected()) totalCost+=2;
        else if (chocoWaffleCone.isSelected()) totalCost+=3.5;

        if (amountScoops.getSelectedIndex()==0){
            totalCost+=3;
        }
        else if (amountScoops.getSelectedIndex()==1){
            totalCost+=5.5;
        }
        else if (amountScoops.getSelectedIndex()==2){
            totalCost+=7;
        }
        orders.add(new IceCream((String) flavorDrop.getSelectedItem(), containerSelected,amountScoops.getSelectedIndex(),toppingsSelected,totalCost));
        totalCost=0;
        update();

        bowl.setSelected(true);
        flavorDrop.setSelectedIndex(0);
        amountScoops.setSelectedIndex(0);
        chocolateSyrup.setSelected(false);
        carmelSyrup.setSelected(false);
        mAndMs.setSelected(false);
        oreos.setSelected(false);
        peanutButterCup.setSelected(false);
        chocolateChip.setSelected(false);
        sprinkles.setSelected(false);
    }
    private void update(){
        model.setRowCount(0);
        for (int a =0; a<orders.size(); a++){
            String container ="";
            if (orders.get(a).getContainer()==0){
                container="Bowl";
            }
            else if (orders.get(a).getContainer()==1){
                container="Waffle Bowl";
            }
            else if (orders.get(a).getContainer()==2){
                container="Waffle Cone";
            }
            else if (orders.get(a).getContainer()==3){
                container="Chocolate Waffle Cone";
            }
            String toppings ="";
            for (int x = 0; x <orders.get(a).getToppings().size(); x++){
                toppings+=orders.get(a).getToppings().get(x)+" ";
            }
            model.addRow(new Object[]{container, orders.get(a).getFlavor(), orders.get(a).getScoops()+1, toppings,orders.get(a).getTotal()});
        }
        double cost=0;
        for (int a =0; a<orders.size(); a++){
            cost+=orders.get(a).getTotal();
        }
        double taxnum = cost*0.0825;
        subTotal.setText(String.format("%.2f",cost));
        tax.setText(String.format("%.2f", taxnum));
        total.setText(String.format("%.2f",cost+taxnum));
    }

    private void sprinklesClicked() {
        if (sprinkles.isSelected()){
            toppingsSelected.add("Sprinkles");
            totalCost+=0.75;
        }
        if (!sprinkles.isSelected())
            toppingsSelected.remove("Sprinkles");
    }

    private void chocolateChipClicked() {
        if (chocolateChip.isSelected()){
            toppingsSelected.add("Chocolate Chip");
            totalCost+=1;
        }
        if (!chocolateChip.isSelected())
            toppingsSelected.remove("Chocolate Chip");
    }

    private void peanutButterCupClicked() {
        if (peanutButterCup.isSelected()) {
            toppingsSelected.add("Peanut Butter Cup");
            totalCost+=1.25;
        }
        if (!peanutButterCup.isSelected())
            toppingsSelected.remove("Peanut Butter Cup");
    }

    private void oreosClicked() {
        if (oreos.isSelected()) {
            toppingsSelected.add("Oreos");
            totalCost+=1;
        }
        if (!oreos.isSelected())
            toppingsSelected.remove("Oreos");
    }

    private void mAndMsClicked() {
        if (mAndMs.isSelected()) {
            toppingsSelected.add("M&Ms");
            totalCost+=1;
        }
        if (!mAndMs.isSelected())
            toppingsSelected.remove("M&Ms");
    }

    private void caramelSyrupClicked() {
        if (carmelSyrup.isSelected()) {
            toppingsSelected.add("Caramel Syrup");
            totalCost+=0.75;
        }
        if (!carmelSyrup.isSelected())
            toppingsSelected.remove("Caramel Syrup");
    }

    private void chocolateSyrupClicked() {
        if (chocolateSyrup.isSelected()) {
            toppingsSelected.add("Chocolate Syrup");
            totalCost+=0.75;
        }
        if (!chocolateSyrup.isSelected())
            toppingsSelected.remove("Chocolate Syrup");
    }

    private void chocoWaffleConeClicked() {
        containerSelected =3;
    }

    private void waffleConeClicked() {
        containerSelected=2;
    }

    private void waffleBowlClicked() {
        containerSelected=1;
    }

    private void bowlClicked() {
        containerSelected=0;
    }
    private void rowClicked(int row){
        bowl.setSelected(true);
        flavorDrop.setSelectedIndex(0);
        amountScoops.setSelectedIndex(0);
        chocolateSyrup.setSelected(false);
        carmelSyrup.setSelected(false);
        mAndMs.setSelected(false);
        oreos.setSelected(false);
        peanutButterCup.setSelected(false);
        chocolateChip.setSelected(false);
        sprinkles.setSelected(false);

        if (orders.get(row).getFlavor().equals("Cookies and Cream")) flavorDrop.setSelectedIndex(1);
        else if (orders.get(row).getFlavor().equals("Vanilla")) flavorDrop.setSelectedIndex(0);
        else if (orders.get(row).getFlavor().equals("Chocolate")) flavorDrop.setSelectedIndex(2);
        else if (orders.get(row).getFlavor().equals("Butter Pecan")) flavorDrop.setSelectedIndex(3);
        else if (orders.get(row).getFlavor().equals("Strawberry")) flavorDrop.setSelectedIndex(4);
        else if (orders.get(row).getFlavor().equals("Chocolate Chip Cookie Dough")) flavorDrop.setSelectedIndex(5);
        else if (orders.get(row).getFlavor().equals("Coffee")) flavorDrop.setSelectedIndex(6);
        else if (orders.get(row).getFlavor().equals("Cinnamon")) flavorDrop.setSelectedIndex(7);

        if (orders.get(row).getContainer()==0){
            bowl.setSelected(true);
        }
        else if (orders.get(row).getContainer()==1){
            waffleBowl.setSelected(true);
        } else if (orders.get(row).getContainer()==2){
            waffleCone.setSelected(true);
        } else if (orders.get(row).getContainer()==3){
            chocoWaffleCone.setSelected(true);
        }

        amountScoops.setSelectedIndex(orders.get(row).getScoops());

        if (orders.get(row).getToppings().contains("Caramel Syrup"))
            carmelSyrup.setSelected(true);
        if (orders.get(row).getToppings().contains("Chocolate Syrup"))
            chocolateSyrup.setSelected(true);
        if (orders.get(row).getToppings().contains("Chocolate Chip"))
            chocolateChip.setSelected(true);
        if (orders.get(row).getToppings().contains("M&Ms"))
            mAndMs.setSelected(true);
        if (orders.get(row).getToppings().contains("Oreos"))
            oreos.setSelected(true);
        if (orders.get(row).getToppings().contains("Peanut Butter Cup"))
            peanutButterCup.setSelected(true);
        if (orders.get(row).getToppings().contains("Sprinkles"))
            sprinkles.setSelected(true);
        add.setVisible(false);
        save.setVisible(true);
        delete.setEnabled(true);
    }
}
