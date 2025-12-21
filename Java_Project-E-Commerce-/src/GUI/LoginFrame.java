package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MainAndSys.ECommerceSys;
import ecommerce.Customer;
import ecommerce.Seller;
import ecommerce.User;

public class LoginFrame extends JFrame {

    private JPanel contentPane;
    private JTextField user;
    private JTextField pass;

    public LoginFrame() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 607, 533);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        JLabel warning = new JLabel("");
        warning.setForeground(Color.RED);
        warning.setBounds(162, 286, 290, 40);
        contentPane.add(warning);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(190, 199, 80, 14);
        contentPane.add(lblUser);

        user = new JTextField();
        user.setBounds(292, 197, 150, 17);
        contentPane.add(user);
        user.setColumns(10);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(190, 240, 80, 14);
        contentPane.add(lblPass);

        pass = new JPasswordField();
        ((JPasswordField) pass).setEchoChar('●');
        pass.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        			String username = user.getText();
                    String password = pass.getText();
                    boolean found = false;

                    for (User user : ECommerceSys.users) {
                        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                            found = true;
                            dispose(); 
                            if (user instanceof Seller) {
                                SellerFrame sf = new SellerFrame((Seller) user);
                                sf.setVisible(true);
                            } else if (user instanceof Customer) {
                                CustomerFrame cf = new CustomerFrame((Customer) user);
                                cf.setVisible(true);
                            }
                            break;
                        }
                    }
                    warning.setText("username and password didn't match!");
        		}
        	}
        });
        pass.setBounds(292, 237, 150, 20);
        contentPane.add(pass);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = user.getText();
                String password = pass.getText();
                boolean found = false;

                for (User user : ECommerceSys.users) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        found = true;
                        dispose(); 
                        if (user instanceof Seller) {
                            SellerFrame sf = new SellerFrame((Seller) user);
                            sf.setVisible(true);
                        } else if (user instanceof Customer) {
                            CustomerFrame cf = new CustomerFrame((Customer) user);
                            cf.setVisible(true);
                        }
                        break;
                    }
                }
                warning.setText("username and password didn't match!");
              
            }
        });
        btnLogin.setBounds(200, 338, 100, 30);
        contentPane.add(btnLogin);

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterFrame rf = new RegisterFrame();
                rf.setVisible(true);
                dispose();
            }
        });
        btnRegister.setBounds(320, 338, 100, 30);
        contentPane.add(btnRegister);
        
        JLabel lblNewLabel = new JLabel("Welcome to GetGood!");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 21));
        lblNewLabel.setBounds(190, 51, 398, 88);
        contentPane.add(lblNewLabel);
        
        JTextArea txtrIfYouHave = new JTextArea();
        txtrIfYouHave.setBackground(Color.LIGHT_GRAY);
        txtrIfYouHave.setLineWrap(true);
        txtrIfYouHave.setText("If you have an account you can login , if not just register and create a new account :)");
        txtrIfYouHave.setBounds(162, 123, 280, 70);
        contentPane.add(txtrIfYouHave);
        
        
    }
}