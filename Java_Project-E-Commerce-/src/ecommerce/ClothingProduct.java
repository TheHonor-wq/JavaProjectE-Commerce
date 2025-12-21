 package ecommerce;

public class ClothingProduct extends Product{
	
	private String type,gender,material,season,color;
	
	
	
	
	public ClothingProduct(int seller_id,String name, double price, int stock, String producer, double stars, String type,
			String gender, String material, String season, String color) {
		super(seller_id,name, price, stock, producer, stars);
		this.type = type;
		this.gender = gender;
		this.material = material;
		this.season = season;
		this.color = color;
		this.shippingWeight=150; //each type of clothing is 100 gram

	}

	
	
	
	@Override
	public String toString() {
		return "\nClothingProduct \nid=" + id + "\nname=" + name + "\nprice=" + price +"\nstock=" + stock
				+ "\nproducer=" + producer + "\nstars=" + stars + "\nshippingWeight=" + shippingWeight
				+ "\ntype=" + type + "\ngender=" + gender + "\nmaterial=" + material + "\nseason=" + season
				+ "\ncolor=" + color;
	}




	@Override
	public double calculateTax() {
		return (0.20); //20% tax on all clothes
	}

	


	
	
}
