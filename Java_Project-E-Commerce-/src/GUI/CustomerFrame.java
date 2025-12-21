package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; // Added for cart implementation
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MainAndSys.*;
import ecommerce.*;

public class CustomerFrame extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> combo;
    private JTextArea disp;
    private JButton closeButton;
    private JTextField quantity;
    private Customer currentCustomer;
    
    // Implementation: Local cart to hold items before buying
    private ArrayList<OrderItem> cart = new ArrayList<>();

    public CustomerFrame(Customer customer) {
        this.currentCustomer = customer;
        
        setTitle("Customer Panel - " + customer.getUsername());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 550); // Increased height slightly for new buttons
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel idLabel = new JLabel("Select Product ID:");
        idLabel.setBounds(24, 15, 120, 14);
        contentPane.add(idLabel);
        
        combo = new JComboBox<String>();
        combo.setBounds(140, 11, 100, 22);

        for (Product p : ECommerceSys.products) {
            combo.addItem(String.valueOf(p.getId()));
        }
        
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displaySelectedProduct();
            }
        });
        contentPane.add(combo);
        
        disp = new JTextArea();
        disp.setLineWrap(true); 
        disp.setWrapStyleWord(true); 
        disp.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(disp);
        scrollPane.setBounds(25, 52, 430, 250); 
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);
        
        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(25, 320, 60, 14);
        contentPane.add(lblQuantity);
        
        quantity = new JTextField();
        quantity.setBounds(90, 317, 50, 20);
        contentPane.add(quantity);
        quantity.setColumns(10);
        
        // Implementation: ADD TO CART Button
        JButton btnAddCart = new JButton("ADD TO CART");
        btnAddCart.setBounds(155, 316, 120, 23);
        btnAddCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedIDStr = (String) combo.getSelectedItem();
                String qtyStr = quantity.getText();
                
                if (selectedIDStr != null && !qtyStr.isEmpty()) {
                    int pid = Integer.parseInt(selectedIDStr);
                    int qty = Integer.parseInt(qtyStr);
                    
                    // Add items to the local cart list
                    cart.add(new OrderItem(pid, qty));
                    disp.setText("Product " + pid + " (Qty: " + qty + ") added to cart!\nItems in cart: " + cart.size());
                }
            }
        });
        contentPane.add(btnAddCart);

        //placing an order
        JButton btnPlaceOrder = new JButton("PLACE ORDER");
        btnPlaceOrder.setBounds(285, 316, 130, 23);
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cart.isEmpty()) {
                    disp.setText("Your cart is empty! Add items first.");
                    return;
                }

                // Create a single Order for the whole cart
                Order newOrder = new Order(currentCustomer.getId());

                // Process each item: update stock and add to the finalized order
                for (OrderItem item : cart) {
                    ECommerceSys.addToOrder(item, newOrder);
                }

                // Add order to system history
                ECommerceSys.orders.add(newOrder);
                
                // Clear cart and show receipt
                disp.setText("Order Success!\n" + newOrder.toString());
                cart.clear(); 
            }
        });
        contentPane.add(btnPlaceOrder);

        //view previous orders
        JButton btnHistory = new JButton("VIEW HISTORY");
        btnHistory.setBounds(25, 380, 125, 23);
        btnHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCustomerOrders();
            }
        });
        contentPane.add(btnHistory);
        
        closeButton = new JButton("LOGOUT");
        closeButton.setBounds(160, 440, 100, 23);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new LoginFrame().setVisible(true);
            }
        });
        contentPane.add(closeButton);

        if (combo.getItemCount() > 0) {
            combo.setSelectedIndex(0);
            displaySelectedProduct();
        }
    }

    // Displays the selected product details
    private void displaySelectedProduct() {
        String selectedIDStr = (String) combo.getSelectedItem();
        if(selectedIDStr != null) {
            int id = Integer.parseInt(selectedIDStr);
            Product found = ECommerceSys.searchProductById(id);
            if(found != null) {
                String info = found.toString();
                info += "\n\n--- Financials ---";
                info += "\nTax Rate: " + (found.calculateTax() * 100) + "%";
                info += "\nShipping Weight: " + found.getShippingWeight() + "g";
                disp.setText(info);
            }
        }
    }

    // Implementation: Formats and displays all orders belonging to this customer
    private void displayCustomerOrders() {
        StringBuilder sb = new StringBuilder("--- Your Order History ---\n");
        boolean hasOrders = false;

        for (Order o : ECommerceSys.orders) {
            if (o.getCustomerId() == currentCustomer.getId()) {
                hasOrders = true;
                sb.append(o.toString()).append("\n--------------------------\n");
            }
        }

        if (!hasOrders) {
            disp.setText("You have no past orders.");
        } else {
            disp.setText(sb.toString());
        }
    }
}