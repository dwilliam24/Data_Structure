package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Restaurant extends JFrame {
    private JMenuBar bar = new JMenuBar();
    private JMenu Menu = new JMenu("Menu");
    private JMenu checkOut = new JMenu("Checkout");
    private JMenuItem appetizers = new JMenuItem("Appetizers");
    private JMenuItem entrees = new JMenuItem("Entrees");
    private JMenuItem desserts = new JMenuItem("Desserts");
    private JMenuItem viewCart = new JMenuItem("View Cart");

    private JScrollPane entreeScroll = new JScrollPane();
    private ArrayList<FoodItem> appetizerList = new ArrayList<>();
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


        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/mozzarellaSticks.jpg"),"Mozzarella Sticks", "Premium mozzarella cheese coated in a seasoned herb breading and fried until perfectly crisp. Served with a side of our signature house-made marinara sauce for the ultimate pull.", 10.50, 0));
        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/BakedBrie.jpg"),"Baked Brie", "A wheel of creamy, imported brie baked until molten and buttery. Topped with a honey-walnut glaze and served with toasted baguette slices and seasonal fruit compote.", 15.50,0));
        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/FriedPickles.jpg"), "Fried Pickles", "Tangy dill pickle spears hand-battered in our signature spicy cornmeal blend. Fried to a deep golden brown and served with a side of cool, creamy peppercorn ranch.", 9.50, 0));
        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/LoadedFries.jpg"), "Loaded Fries", "A mountain of crispy golden fries smothered in melted cheddar-jack cheese, crispy bacon bits, and fresh scallions. Finished with a heavy drizzle of house-made garlic aioli.", 12.00, 0));
        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/Nachos.jpg"), "Nachos", "Crunchy corn tortilla chips piled high and layered with warm queso, black beans, jalapeños, and fresh pico de gallo. Topped with a dollop of zesty lime crema.", 13.50, 0));
        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/Pretzels.jpg"), "Pretzels", "Two jumbo, hearth-baked soft pretzels brushed with melted butter and sprinkled with coarse sea salt. Served with a warm, beer-infused sharp cheddar dipping sauce.", 11.00, 0));
        
        Image img = appetizerList.get(0).getImage().getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel a = new JLabel(new ImageIcon(img));
        a.setBounds(100,100,100,100);
        entreeScroll.add(a);

        add(entreeScroll);
        setVisible(true);
    }
}
