package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import MainAndSys.ECommerceSys;

import javax.swing.DefaultComboBoxModel; 
import ecommerce.*;

public class SellerFrame extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> combo;
    private JTextArea disp;
    private Seller currentSeller;

    public SellerFrame(Seller seller) {
        this.currentSeller = seller;
        
        setTitle("Seller Dashboard - " + seller.getUsername());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSelect = new JLabel("Select Product Type to Add:");
        lblSelect.setBounds(30, 30, 200, 14);
        contentPane.add(lblSelect);

        combo = new JComboBox<String>();
        combo.setModel(new DefaultComboBoxModel<>(new String[] { "Tech Product", "Clothing Product", "Market Product" }));
        combo.setBounds(30, 55, 200, 22);
        contentPane.add(combo);

        JButton btnOpenAdd = new JButton("OPEN ADD FORM");
        btnOpenAdd.setBounds(30, 90, 200, 30);
        btnOpenAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSelectedFrame();
            }
        });
        contentPane.add(btnOpenAdd);

        JButton displayButton = new JButton("REFRESH / DISPLAY ALL");
        displayButton.setBounds(30, 150, 200, 30);
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                disp.setText(ECommerceSys.displayAllProducts());
            }
        });
        contentPane.add(displayButton);
        
        JButton logoutButton = new JButton("LOGOUT");
        logoutButton.setBounds(30, 380, 200, 30);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame().setVisible(true);
            }
        });
        contentPane.add(logoutButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(260, 20, 400, 420);
        contentPane.add(scrollPane);

        disp = new JTextArea();
        disp.setEditable(false);
        scrollPane.setViewportView(disp);
        
        disp.setText(ECommerceSys.displayAllProducts());
    }

    private void openSelectedFrame() {
        String selection = (String) combo.getSelectedItem();
        
        if ("Tech Product".equals(selection)) {
            TechProductFrame tf = new TechProductFrame(currentSeller, this);
            tf.setVisible(true);
        } else if ("Clothing Product".equals(selection)) {
            ClothingProductFrame cf = new ClothingProductFrame(currentSeller, this);
            cf.setVisible(true);
        } else if ("Market Product".equals(selection)) {
            MarketProductFrame mf = new MarketProductFrame(currentSeller, this);
            mf.setVisible(true);
        }
    }
    
    public void refreshProductList() {
        disp.setText(ECommerceSys.displayAllProducts());
    }
}