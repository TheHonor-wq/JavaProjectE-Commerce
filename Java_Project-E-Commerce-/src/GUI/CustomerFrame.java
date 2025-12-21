package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import ecommerce.*;

public class CustomerFrame extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> combo;
    private JTextArea disp;
    private JButton closeButton;
    private JTextField quantity;
    private Customer currentCustomer;

    /**
     * Create the frame.
     */
    public CustomerFrame(Customer customer) {
        this.currentCustomer = customer;
        
        setTitle("Customer Panel - " + customer.getUsername());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
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
        disp.setRows(5);
        disp.setBounds(25, 52, 430, 250);
        contentPane.add(disp);
        
        
        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(25, 320, 60, 14);
        contentPane.add(lblQuantity);
        
        quantity = new JTextField();
        quantity.setBounds(90, 317, 50, 20);
        contentPane.add(quantity);
        quantity.setColumns(10);
        
        JButton btnBuy = new JButton("BUY");
        btnBuy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedIDStr = (String) combo.getSelectedItem();
                String qtyStr = quantity.getText();
                
                if (selectedIDStr != null && !qtyStr.isEmpty()) {
                        int pid = Integer.parseInt(selectedIDStr);
                        int qty = Integer.parseInt(qtyStr);
                        
                        OrderItem item = new OrderItem(pid, qty);
                        Order order = new Order(currentCustomer.getId());
                        
                        
                        ECommerceSys.orders.add(order);
                        
                        
                        boolean success = ECommerceSys.addToOrder(item, order);
                        
                        if(success) {                             
                             displaySelectedProduct();
                        }
                        
                    
                }
            }
        });
        btnBuy.setBounds(160, 316, 80, 23);
        contentPane.add(btnBuy);
        
        closeButton = new JButton("LOGOUT");
        closeButton.setBounds(160, 380, 100, 23);
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
}