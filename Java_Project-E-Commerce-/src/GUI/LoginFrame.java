package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import ecommerce.*;

public class LoginFrame extends JFrame {

    private JPanel contentPane;
    private JTextField user;
    private JTextField pass;

    public LoginFrame() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(40, 30, 80, 14);
        contentPane.add(lblUser);

        user = new JTextField();
        user.setBounds(120, 27, 150, 20);
        contentPane.add(user);
        user.setColumns(10);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(40, 70, 80, 14);
        contentPane.add(lblPass);

        pass = new JTextField();
        pass.setBounds(120, 67, 150, 20);
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

              
            }
        });
        btnLogin.setBounds(50, 110, 100, 30);
        contentPane.add(btnLogin);

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterFrame rf = new RegisterFrame();
                rf.setVisible(true);
                dispose();
            }
        });
        btnRegister.setBounds(170, 110, 100, 30);
        contentPane.add(btnRegister);
    }
}