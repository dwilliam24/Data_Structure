package Restaurant;

import javax.swing.*;

public class Restaurant extends JFrame {
    private JMenuBar bar = new JMenuBar();
    private JMenu Menu = new JMenu("Menu");
    private JMenu checkOut = new JMenu("Checkout");
    private JMenuItem appetizers = new JMenuItem("Appetizers");
    private JMenuItem entrees = new JMenuItem("Entrees");
    private JMenuItem desserts = new JMenuItem("Desserts");
    private JMenuItem viewCart = new JMenuItem("View Cart");

    public Restaurant(){
        super("Restaurant");
        setSize(1000, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(bar);
        bar.add(Menu);
        bar.add(checkOut);
        Menu.add(appetizers);
        Menu.add(entrees);
        Menu.add(desserts);
        checkOut.add(viewCart);

        setVisible(true);
    }
}
