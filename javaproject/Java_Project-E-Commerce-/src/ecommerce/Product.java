package ecommerce;

import java.util.Scanner;

public abstract class Product implements ProductInterface{
	int id;
	String name;
	double price;
	int stock;
	String producer;
	double stars;
	double shippingWeight;

	
	
	
	public Product(int id, String name, double price, int stock, String producer, double stars) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.producer = producer;
		this.stars = stars;
	}


	public void getInput()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter product id: ");
		id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter product name: ");
		name = sc.nextLine();
		
		
		System.out.print("Enter product price: ");
		price = sc.nextDouble();
		sc.nextLine();
		
		System.out.print("Enter stock for the product: ");
		stock = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter producer: ");
		producer = sc.nextLine();
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}
	
	


	public  void setShippingWeight(double shippingWeight)
	{
		this.shippingWeight=shippingWeight;
	}
													
	public  double getShippingWeight()
	{
		return shippingWeight;
	}
	@Override
	public double calculateTax() {
		return 0;
	}

	@Override
	public String toString() {
		return "\nProduct \nid=" + id + "\n name=" + name + "\nprice=" + price + "\nstock=" + stock + "\nproducer="
				+ producer + "\nstars=" + stars;
	}
	
	

}
