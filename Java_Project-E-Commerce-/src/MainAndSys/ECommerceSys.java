package MainAndSys;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import ecommerce.*;

public class ECommerceSys {
	public static HashSet<User> users = new HashSet<>();
	public static TreeSet<Product> products = new TreeSet<>();
	public static TreeSet<Order> orders = new TreeSet<>();
	
	public static final String USER_FILE = "user.txt";
	public static final String PRODUCT_FILE = "product.txt";
	
	
	public static boolean searchUserID(int id) {//if exist return true
		for(User user : users) {
			if(user.getId()==id)
				return true;
		}
		return false;
	}
	
	public static Product searchProductById(int id) {
		for(Product pro : products) {
			if(pro.getId()==id) {
				return pro;
			}
		}
		return null;
	}
	
	public static boolean addUser(User user) {
		if(users.contains(user)) 
		{
			System.out.println("User is already exist");
			return false;
		}
		users.add(user);
		return true;
	}
	
	public static boolean addToOrder(OrderItem oitem,Order order) {
		Product product = ECommerceSys.searchProductById(oitem.getProductID());
		int stock = product.getStock();
		int quantity = oitem.getQuantity();
		if(stock >= quantity) {
			product.setStock(stock-quantity);
		}
		else {
			System.out.println("Since there is not that much product in stock, you will get how many stock is there");
			oitem.setQuantity(stock);
			product.setStock(0);
			
		}
		return order.addItem(oitem);
	}
	
	public static boolean addProduct(Product product) {
		if(products.contains(product)) {
			System.out.println("Already exists![addProduct()]");
			return false;
		}
		return products.add(product);
	}
	public static boolean removeProduct(Product product){//seller icin
		return products.remove(product);
	}
	
	public static String listProduct(String product_name) {//list the string matches
		String out = "";
		for(Product  pro : products) {
			
			if(pro.getName().matches(product_name)) {
				out += pro  + "\n";
			}
		}
		return out;
	}
	
	public static String displayAllProducts() {
		String out = "";
		for(Product pro : products) {
			out += pro + "\n";	
		}
		return out;
	}
	public static String displayAllOrders() {
		
		String out = "\n All orders :\n------------\n";
		for(Order order : orders) {
				out+= order;
		}
		return out;
	}
	
	public static void readUserFile() {
		File file = new File(USER_FILE);
		try {
			Scanner sc = new Scanner(file);
			String[] line;
			while(sc.hasNext())
			{
				line = sc.nextLine().split(";"); //user type (line[0]), username line[1], password line[2], +address (if customer) line[3]
				if(line[0].equalsIgnoreCase("Customer"))
				{
					Customer c = new Customer(line[1],line[2],line[3]);
					users.add(c);
				}
				else 
				{
					Seller s = new Seller(line[1],line[2]);
					users.add(s);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void readProductFile() {
		File file = new File(PRODUCT_FILE);
		try {
			Scanner sc = new Scanner(file);
			String[] d;
			while(sc.hasNext())
			{
				d=sc.nextLine().split(";");
				if (d[0].equals("Tech")) {
			        ECommerceSys.addProduct(new TechProduct(Integer.parseInt(d[1]), d[2], Double.parseDouble(d[3]), 
			            Integer.parseInt(d[4]), d[5], Double.parseDouble(d[6]), d[7], Integer.parseInt(d[8]), Boolean.parseBoolean(d[9])));
			    } else if (d[0].equals("Market")) {
			        ECommerceSys.addProduct(new MarketProduct(Integer.parseInt(d[1]), d[2], Double.parseDouble(d[3]), 
			            Integer.parseInt(d[4]), d[5], Double.parseDouble(d[6]), d[7], d[8]));
			    } else if (d[0].equals("Clothing")) {
			        ECommerceSys.addProduct(new ClothingProduct(Integer.parseInt(d[1]), d[2], Double.parseDouble(d[3]), 
			            Integer.parseInt(d[4]), d[5], Double.parseDouble(d[6]), d[7], d[8], d[9], d[10], d[11]));
			    }
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
