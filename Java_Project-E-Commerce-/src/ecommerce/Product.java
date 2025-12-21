package ecommerce;

import java.util.Objects;

public abstract class Product implements ProductInterface, Comparable<Product>{
	protected int id;//visibility ??
	protected String name;
	protected double price;
	protected int stock;
	protected String producer;
	protected double stars;
	protected double shippingWeight;
	protected int seller_id;

	
	static private int product_count = 0;
	
	public Product(int seller_id, String name, double price, int stock, String producer, double stars) {
		super();//why not implicit
		this.id = product_count;
		this.seller_id = seller_id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.producer = producer;
		this.stars = stars;
		product_count++;
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
		return 0;//?
	}

	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id;
	}


	@Override
	public String toString() {
		return "\nProduct \nid=" + id + "\n name=" + name + "\nprice=" + price + "\nstock=" + stock + "\nproducer="
				+ producer + "\nstars=" + stars;
	}
	@Override
    public int compareTo(Product other) {
        // List according to IDs
        return Integer.compare(this.id, other.id);
    }
	

}
