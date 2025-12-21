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

public class MarketProductFrame extends JFrame {

    private JPanel contentPane;
    private JTextField nameF, priceF, stockF, producerF, starsF, expireF;
    private JComboBox<String> combo;
    private Seller currentSeller;
    private SellerFrame parentFrame;

    public MarketProductFrame(Seller seller, SellerFrame parent) {
        this.currentSeller = seller;
        this.parentFrame = parent;

        setTitle("Add Market Product");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 350, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        int y = 20;
        int gap = 35;
        
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, y, 80, 14); contentPane.add(lblName);
        nameF = new JTextField();
        nameF.setBounds(100, y-3, 180, 20); contentPane.add(nameF); y+=gap;

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(20, y, 80, 14); contentPane.add(lblPrice);
        priceF = new JTextField();
        priceF.setBounds(100, y-3, 180, 20); contentPane.add(priceF); y+=gap;

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setBounds(20, y, 80, 14); contentPane.add(lblStock);
        stockF = new JTextField();
        stockF.setBounds(100, y-3, 180, 20); contentPane.add(stockF); y+=gap;

        JLabel lblProducer = new JLabel("Producer:");
        lblProducer.setBounds(20, y, 80, 14); contentPane.add(lblProducer);
        producerF = new JTextField();
        producerF.setBounds(100, y-3, 180, 20); contentPane.add(producerF); y+=gap;
        
        JLabel lblStars = new JLabel("Stars:");
        lblStars.setBounds(20, y, 80, 14); contentPane.add(lblStars);
        starsF = new JTextField();
        starsF.setBounds(100, y-3, 180, 20); contentPane.add(starsF); y+=gap;

        JLabel lblType = new JLabel("Type:");
        lblType.setBounds(20, y, 80, 14); contentPane.add(lblType);
        
        combo = new JComboBox<String>();
        combo.setModel(new DefaultComboBoxModel<>(new String[] {"Food", "Beverage", "Medicine", "Furniture"}));
        combo.setBounds(100, y-3, 180, 22); contentPane.add(combo); y+=gap;

        JLabel lblExpire = new JLabel("Exp. Date:");
        lblExpire.setBounds(20, y, 80, 14); contentPane.add(lblExpire);
        expireF = new JTextField();
        expireF.setBounds(100, y-3, 180, 20); contentPane.add(expireF); y+=gap;

        JButton btnAdd = new JButton("ADD PRODUCT");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });
        btnAdd.setBounds(80, y+10, 150, 30);
        contentPane.add(btnAdd);
    }

    private void addProduct() {
            String name = nameF.getText();
            double price = Double.parseDouble(priceF.getText());
            int stock = Integer.parseInt(stockF.getText());
            String producer = producerF.getText();
            double stars = Double.parseDouble(starsF.getText());
            
            String type = (String) combo.getSelectedItem();
            String expireDate = expireF.getText();

            MarketProduct newP = new MarketProduct(currentSeller.getId(), name, price, stock, producer, stars, type, expireDate);
            
            if (ECommerceSys.addProduct(newP)) {
                parentFrame.refreshProductList();
                dispose();
            }}}
        
    
