package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MainAndSys.ECommerceSys;

import javax.swing.DefaultComboBoxModel; 
import ecommerce.*;

public class TechProductFrame extends JFrame {

    private JPanel contentPane;
    private JTextField nameF, priceF, stockF, producerF, starsF, yearF;
    private JComboBox<String> combo;
    private JCheckBox checkb;
    private Seller currentSeller;
    private SellerFrame parentFrame;

    public TechProductFrame(Seller seller, SellerFrame parent) {
        this.currentSeller = seller;
        this.parentFrame = parent;

        setTitle("Add Tech Product");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 350, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 20, 80, 14);
        contentPane.add(lblName);
        nameF = new JTextField();
        nameF.setBounds(100, 17, 180, 20);
        contentPane.add(nameF);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(20, 50, 80, 14);
        contentPane.add(lblPrice);
        priceF = new JTextField();
        priceF.setBounds(100, 47, 180, 20);
        contentPane.add(priceF);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setBounds(20, 80, 80, 14);
        contentPane.add(lblStock);
        stockF = new JTextField();
        stockF.setBounds(100, 77, 180, 20);
        contentPane.add(stockF);

        JLabel lblProducer = new JLabel("Producer:");
        lblProducer.setBounds(20, 110, 80, 14);
        contentPane.add(lblProducer);
        producerF = new JTextField();
        producerF.setBounds(100, 107, 180, 20);
        contentPane.add(producerF);
        
        JLabel lblStars = new JLabel("Stars (0-5):");
        lblStars.setBounds(20, 140, 80, 14);
        contentPane.add(lblStars);
        starsF = new JTextField();
        starsF.setBounds(100, 137, 180, 20);
        contentPane.add(starsF);

        
        JLabel lblType = new JLabel("Tech Type:");
        lblType.setBounds(20, 180, 80, 14);
        contentPane.add(lblType);
        
        
       
        combo = new JComboBox<String>();
        combo.setModel(new DefaultComboBoxModel<>(new String[] {"Phone", "Laptop", "Television", "Console"}));
        combo.setBounds(100, 177, 180, 22);
        contentPane.add(combo);

        JLabel lblYear = new JLabel("Year:");
        lblYear.setBounds(20, 210, 80, 14);
        contentPane.add(lblYear);
        yearF = new JTextField();
        yearF.setBounds(100, 207, 180, 20);
        contentPane.add(yearF);

        JLabel lblGua = new JLabel("Guarantee:");
        lblGua.setBounds(20, 240, 80, 14);
        contentPane.add(lblGua);
        checkb = new JCheckBox("Yes");
        checkb.setBounds(96, 237, 100, 23);
        contentPane.add(checkb);

        JButton btnAdd = new JButton("ADD PRODUCT");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });
        btnAdd.setBounds(80, 290, 150, 30);
        contentPane.add(btnAdd);
    }

    private void addProduct() {
            String name = nameF.getText();
            double price = Double.parseDouble(priceF.getText());
            int stock = Integer.parseInt(stockF.getText());
            String producer = producerF.getText();
            double stars = Double.parseDouble(starsF.getText());
            String type = (String) combo.getSelectedItem();
            int year = Integer.parseInt(yearF.getText());
            boolean hasGuarantee = checkb.isSelected();

            TechProduct newP = new TechProduct(currentSeller.getId(), name, price, stock, producer, stars, type, year, hasGuarantee);
            
            if (ECommerceSys.addProduct(newP)) {
                parentFrame.refreshProductList();
                dispose();
            } 
        
    }
}