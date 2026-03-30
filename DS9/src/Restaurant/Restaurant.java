package Restaurant;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.util.ArrayList;

public class Restaurant extends JFrame {
    private JPanel appetizersPanel, entreesPanel, dessertsPanel, cartPanel;

    private JMenuBar bar = new JMenuBar();
    private JMenu menu = new JMenu("Menu");
    private JMenu checkOut = new JMenu("Checkout");
    private JMenuItem appetizersMenu = new JMenuItem("Appetizers");
    private JMenuItem entreesMenu = new JMenuItem("Entrees");
    private JMenuItem dessertsMenu = new JMenuItem("Desserts");
    private JMenuItem viewCartMenu = new JMenuItem("View Cart");

    private ArrayList<FoodItem> appetizerList = new ArrayList<>();
    private ArrayList<FoodItem> entreeList = new ArrayList<>();
    private ArrayList<FoodItem> dessertList = new ArrayList<>();

    private DefaultTableModel tableModel;
    private JTextField tipInput, subtotalField, taxField, tipAmountField, totalField;

    public Restaurant() {
        super("Restaurant");
        setSize(1100, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/mozzarellaSticks.jpg"), "Mozzarella Sticks", "Herb-breaded mozzarella with marinara.", 10.50, 0));
        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/BakedBrie.jpg"), "Baked Brie", "Molten brie with honey-walnut glaze.", 15.50, 0));
        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/FriedPickles.jpg"), "Fried Pickles", "Crispy spears with peppercorn ranch.", 9.50, 0));
        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/LoadedFries.jpg"), "Loaded Fries", "Fries with cheddar, bacon, and garlic aioli.", 12.00, 0));
        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/Nachos.jpg"), "Nachos", "Chips with queso, black beans, and lime crema.", 13.50, 0));
        appetizerList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/Pretzels.jpg"), "Pretzels", "Soft pretzels with beer-cheese dip.", 11.00, 0));

        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/cheeseBurger.jpg"), "Cheeseburger", "Beef patty with cheddar on brioche.", 14.50, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/hamburger.jpg"), "Hamburger", "The classic grilled beef burger.", 13.00, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/steak.jpg"), "Ribeye Steak", "12oz hand-cut grilled ribeye.", 28.00, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/ribs.jpg"), "BBQ Ribs", "Slow-roasted with hickory BBQ sauce.", 22.50, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/chickenAlfredo.jpg"), "Chicken Alfredo", "Creamy parmesan sauce over fettuccine.", 18.50, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/spagetti.jpg"), "Spaghetti Marinara", "Classic pasta with zesty tomato sauce.", 15.00, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/turkey.jpg"), "Roasted Turkey", "Served with savory herb stuffing.", 17.50, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/fishAndChips.jpg"), "Fish and Chips", "Beer-battered cod with golden fries.", 16.50, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/salmon.jpg"), "Grilled Salmon", "Fillet with a lemon-butter herb glaze.", 24.00, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/shrimpScampi.jpg"), "Shrimp Scampi", "Garlic butter shrimp over linguine.", 21.00, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/tacos.jpg"), "Street Tacos", "Authentic beef tacos with fresh cilantro.", 13.50, 0));
        entreeList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/sushi.jpg"), "Sushi Platter", "Fresh nigiri and rolls with wasabi.", 21.00, 0));

        dessertList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/lavaCake.jpg"), "Lava Cake", "Warm chocolate cake with molten center.", 8.50, 0));
        dessertList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/cheesecake.jpg"), "Cheesecake", "Classic NY style with graham crust.", 9.00, 0));
        dessertList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/carrotCake.jpg"), "Carrot Cake", "Spiced cake with cream cheese frosting.", 8.00, 0));
        dessertList.add(new FoodItem(new ImageIcon("src/Restaurant/Images/tiramisu.jpg"), "Tiramisu", "Espresso-soaked ladyfingers and cream.", 9.50, 0));

        setJMenuBar(bar);
        bar.add(menu);
        bar.add(checkOut);
        menu.add(appetizersMenu);
        menu.add(entreesMenu);
        menu.add(dessertsMenu);
        checkOut.add(viewCartMenu);

        appetizersPanel = createMenuPage("Appetizers", appetizerList, false);
        entreesPanel = createMenuPage("Entrees", entreeList, true);
        dessertsPanel = createMenuPage("Desserts", dessertList, false);
        cartPanel = createCartPage();

        appetizersPanel.setBounds(0, 0, 1100, 750);
        entreesPanel.setBounds(0, 0, 1100, 750);
        dessertsPanel.setBounds(0, 0, 1100, 750);
        cartPanel.setBounds(0, 0, 1100, 750);

        add(appetizersPanel);
        add(entreesPanel);
        add(dessertsPanel);
        add(cartPanel);

        showPanel(appetizersPanel);

        appetizersMenu.addActionListener(e -> showPanel(appetizersPanel));
        entreesMenu.addActionListener(e -> showPanel(entreesPanel));
        dessertsMenu.addActionListener(e -> showPanel(dessertsPanel));
        viewCartMenu.addActionListener(e -> {
            refreshCart();
            showPanel(cartPanel);
        });

        setVisible(true);
    }

    private void showPanel(JPanel panel) {
        appetizersPanel.setVisible(false);
        entreesPanel.setVisible(false);
        dessertsPanel.setVisible(false);
        cartPanel.setVisible(false);
        panel.setVisible(true);
    }

    private JPanel createMenuPage(String title, ArrayList<FoodItem> items, boolean isEntree) {
        JPanel main = new JPanel(null);

        JLabel head = new JLabel(title, SwingConstants.CENTER);
        head.setFont(new Font("Arial", Font.BOLD, 36));
        head.setBounds(0, 10, 1080, 50);
        main.add(head);

        JPanel list = new JPanel(null);
        int currentY = 0;

        for (int i = 0; i < items.size(); i++) {
            if (isEntree) {
                if (i == 0 || i == 4 || i == 7) {
                    String subText = "";
                    if (i == 0) {
                        subText = "--- From the Grill ---";
                    } else if (i == 4) {
                        subText = "--- Pasta & Poultry ---";
                    } else if (i == 7) {
                        subText = "--- Seafood & Specialties ---";
                    }
                    JLabel sub = new JLabel(subText, SwingConstants.CENTER);
                    sub.setFont(new Font("Arial", Font.BOLD, 20));
                    sub.setBounds(0, currentY, 1050, 40);
                    list.add(sub);
                    currentY += 40;
                }
            }
            JPanel row = createFoodRow(items.get(i), i % 2 == 0);
            row.setBounds(0, currentY, 1050, 150);
            list.add(row);
            currentY += 150;
        }

        list.setPreferredSize(new Dimension(1050, currentY));

        JScrollPane scroll = new JScrollPane(list);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(15, 70, 1050, 620);
        main.add(scroll);

        return main;
    }

    private JPanel createFoodRow(FoodItem item, boolean even) {
        JPanel row = new JPanel(null);
        if (even) {
            row.setBackground(new Color(245, 245, 245));
        } else {
            row.setBackground(Color.WHITE);
        }
        row.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        Image img = item.getImage().getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel picture = new JLabel(new ImageIcon(img));
        picture.setBounds(20, 15, 120, 120);
        row.add(picture);

        JLabel name = new JLabel(item.getName());
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setBounds(160, 20, 400, 30);
        row.add(name);

        JLabel desc = new JLabel(item.getDescription());
        desc.setBounds(160, 50, 450, 60);
        row.add(desc);

        JLabel price = new JLabel("$" + String.format("%.2f", item.getCost()));
        price.setFont(new Font("Arial", Font.ITALIC, 16));
        price.setBounds(160, 110, 100, 25);
        row.add(price);

        JButton minus = new JButton("-");
        JLabel qtyLabel = new JLabel("0", SwingConstants.CENTER);
        JButton plus = new JButton("+");

        minus.setBounds(700, 60, 50, 30);
        qtyLabel.setBounds(750, 60, 40, 30);
        plus.setBounds(790, 60, 50, 30);

        minus.setEnabled(false);

        plus.addActionListener(e -> {
            item.setQuantity(item.getQuantity() + 1);
            qtyLabel.setText("" + item.getQuantity());
            minus.setEnabled(true);
        });

        minus.addActionListener(e -> {
            item.setQuantity(item.getQuantity() - 1);
            qtyLabel.setText("" + item.getQuantity());
            if (item.getQuantity() == 0) minus.setEnabled(false);
        });

        row.add(minus);
        row.add(qtyLabel);
        row.add(plus);

        return row;
    }

    private JPanel createCartPage() {
        JPanel main = new JPanel(null);

        String[] cols = {"Item Name", "Quantity", "Cost", "Extended Cost"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(50, 30, 980, 400);
        main.add(scrollPane);

        JPanel receipt = new JPanel(null);
        receipt.setBorder(BorderFactory.createTitledBorder("Final Receipt"));
        receipt.setBounds(290, 450, 500, 230);

        JLabel tipLbl = new JLabel("Tip Percentage (%):");
        tipLbl.setBounds(20, 30, 150, 25);
        tipInput = new JTextField("15");
        tipInput.setBounds(200, 30, 280, 25);

        JLabel subLbl = new JLabel("Subtotal:");
        subLbl.setBounds(20, 65, 150, 25);
        subtotalField = new JTextField();
        subtotalField.setEditable(false);
        subtotalField.setBounds(200, 65, 280, 25);

        JLabel taxLbl = new JLabel("Tax (8.25%):");
        taxLbl.setBounds(20, 100, 150, 25);
        taxField = new JTextField();
        taxField.setEditable(false);
        taxField.setBounds(200, 100, 280, 25);

        JLabel tipAmtLbl = new JLabel("Tip Amount:");
        tipAmtLbl.setBounds(20, 135, 150, 25);
        tipAmountField = new JTextField();
        tipAmountField.setEditable(false);
        tipAmountField.setBounds(200, 135, 280, 25);

        JLabel totalLbl = new JLabel("TOTAL:");
        totalLbl.setBounds(20, 170, 150, 25);
        totalField = new JTextField();
        totalField.setEditable(false);
        totalField.setBounds(200, 170, 280, 25);

        tipInput.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                refreshCart();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                refreshCart();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                refreshCart();
            }
        });

        AbstractDocument doc = (AbstractDocument) tipInput.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }
        });

        receipt.add(tipLbl);
        receipt.add(tipInput);
        receipt.add(subLbl);
        receipt.add(subtotalField);
        receipt.add(taxLbl);
        receipt.add(taxField);
        receipt.add(tipAmtLbl);
        receipt.add(tipAmountField);
        receipt.add(totalLbl);
        receipt.add(totalField);

        main.add(receipt);
        return main;
    }

    private void refreshCart() {
        tableModel.setRowCount(0);
        double subtotal = 0;

        ArrayList<FoodItem> all = new ArrayList<>();
        all.addAll(appetizerList);
        all.addAll(entreeList);
        all.addAll(dessertList);

        for (FoodItem f : all) {
            if (f.getQuantity() > 0) {
                double ext = f.getQuantity() * f.getCost();
                subtotal += ext;
                tableModel.addRow(new Object[]{f.getName(), f.getQuantity(), "$" + f.getCost(), "$" + String.format("%.2f", ext)});
            }
        }

        double tax = subtotal * 0.0825;
        int tipPct = 0;
        try {
            tipPct = Math.max(0, Integer.parseInt(tipInput.getText()));
        } catch (Exception e) {
        }
        double tipAmt = subtotal * (tipPct / 100.0);
        double total = subtotal + tax + tipAmt;

        subtotalField.setText("$" + String.format("%.2f", subtotal));
        taxField.setText("$" + String.format("%.2f", tax));
        tipAmountField.setText("$" + String.format("%.2f", tipAmt));
        totalField.setText("$" + String.format("%.2f", total));
    }
}