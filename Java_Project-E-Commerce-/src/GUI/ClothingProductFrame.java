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

public class ClothingProductFrame extends JFrame {

    private JPanel contentPane;
    private JTextField nameF, priceF, stockF, producerF, starF;
    private JTextField typeF, genderF, materialF, seasonF, colorF;
    private Seller currentSeller;
    private SellerFrame parentFrame;

    public ClothingProductFrame(Seller seller, SellerFrame parent) {
        this.currentSeller = seller;
        this.parentFrame = parent;

        setTitle("Add Clothing Product");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 350, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        int y = 20;
        int gap = 30;
        
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
        starF = new JTextField();
        starF.setBounds(100, y-3, 180, 20); contentPane.add(starF); y+=gap;

        
        JLabel lblType = new JLabel("Type:");
        lblType.setBounds(20, y, 80, 14); contentPane.add(lblType);
        typeF = new JTextField(); 
        typeF.setBounds(100, y-3, 180, 20); contentPane.add(typeF); y+=gap;

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(20, y, 80, 14); contentPane.add(lblGender);
        genderF = new JTextField();
        genderF.setBounds(100, y-3, 180, 20); contentPane.add(genderF); y+=gap;

        JLabel lblMaterial = new JLabel("Material:");
        lblMaterial.setBounds(20, y, 80, 14); contentPane.add(lblMaterial);
        materialF = new JTextField();
        materialF.setBounds(100, y-3, 180, 20); contentPane.add(materialF); y+=gap;
        
        JLabel lblSeason = new JLabel("Season:");
        lblSeason.setBounds(20, y, 80, 14); contentPane.add(lblSeason);
        seasonF = new JTextField();
        seasonF.setBounds(100, y-3, 180, 20); contentPane.add(seasonF); y+=gap;
        
        JLabel lblColor = new JLabel("Color:");
        lblColor.setBounds(20, y, 80, 14); contentPane.add(lblColor);
        colorF = new JTextField();
        colorF.setBounds(100, y-3, 180, 20); contentPane.add(colorF); y+=gap;

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
            double stars = Double.parseDouble(starF.getText());
            
            String type = typeF.getText();
            String gender = genderF.getText();
            String material = materialF.getText();
            String season = seasonF.getText();
            String color = colorF.getText();

            ClothingProduct newP = new ClothingProduct(currentSeller.getId(), name, price, stock, producer, stars, type, gender, material, season, color);
            
            if (ECommerceSys.addProduct(newP)) {
                dispose();
            } 
        
    }
}