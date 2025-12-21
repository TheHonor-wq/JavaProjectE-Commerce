package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import ecommerce.*;

public class RegisterFrame extends JFrame {

    private JPanel contentPane;
    private JTextField userF;
    private JTextField passF;
    private JTextField addressF;
    private JComboBox<String> combo;
    private JLabel AddressF; 

    public RegisterFrame() {
        setTitle("Register New User");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(30, 30, 80, 14);
        contentPane.add(lblUser);

        userF = new JTextField();
        userF.setBounds(110, 27, 150, 20);
        contentPane.add(userF);
        userF.setColumns(10);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(30, 70, 80, 14);
        contentPane.add(lblPass);

        passF = new JTextField();
        passF.setBounds(110, 67, 150, 20);
        contentPane.add(passF);

        JLabel lblType = new JLabel("Type:");
        lblType.setBounds(30, 110, 80, 14);
        contentPane.add(lblType);

        combo = new JComboBox<String>();
        combo.setModel(new DefaultComboBoxModel<>(new String[] {"Seller", "Customer"}));
        combo.setBounds(110, 107, 150, 22);
        contentPane.add(combo);
        
        AddressF = new JLabel("Address:");
        AddressF.setBounds(30, 150, 80, 14);
        contentPane.add(AddressF);
        
        addressF = new JTextField();
        addressF.setBounds(110, 147, 150, 20);
        contentPane.add(addressF);

        
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleAddressVisibility();
            }
        });
        
        
        toggleAddressVisibility();

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        btnRegister.setBounds(40, 200, 100, 30);
        contentPane.add(btnRegister);
        
        JButton btnLogin = new JButton("Back to Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame login = new LoginFrame();
                login.setVisible(true);
                dispose();
            }
        });
        btnLogin.setBounds(160, 200, 120, 30);
        contentPane.add(btnLogin);
    }

    private void toggleAddressVisibility() {
        String type = (String) combo.getSelectedItem();
        boolean isCustomer = "Customer".equals(type);
        
        AddressF.setVisible(isCustomer);
        addressF.setVisible(isCustomer);
    }

    private void registerUser() {
        String u = userF.getText();
        String p = passF.getText();
        String type = (String) combo.getSelectedItem();
        
        User newUser = null;
        
        if ("Seller".equals(type)) {
            newUser = new Seller(u, p);
        } else {
            String addr = addressF.getText();
            newUser = new Customer(u, p, addr);
        }

        if (ECommerceSys.addUser(newUser)) {
            LoginFrame login = new LoginFrame();
            login.setVisible(true);
            dispose();
        }
    }
}