package ecommerce;

public class MarketProduct extends Product{
	
	private String type;  //food,beverage,medicine,furniture
	private String expireDate;

	
	
	public MarketProduct( int seller_id,String name, double price, int stock, String producer, double stars, String type,
			String expireDate) {
		super(seller_id,name, price, stock, producer, stars);
		this.type = type;
		this.expireDate = expireDate;
		String normalized =type.toLowerCase();
		switch(normalized)
		{
		case "food":
			setShippingWeight(200); //200 gs
			break;
		case "beverage":
			setShippingWeight(100); //100 g
			break;
		case "medicine":
			setShippingWeight(50); //50g
			break;
		case "furniture":
			setShippingWeight(20000); //20 kg
			break;
		default:
			setShippingWeight(0);
			break;
			
		}


		
	
		
	}


	

	@Override
	public double calculateTax() {
		String normalized=type.toLowerCase();
		switch(normalized)
		{
		case "food":
		case "beverage":return(0); //no taxes on food&beverages
		case "medicine": return(0.2); //20% tax on medicines
		case "furniture": return(0.3); //30% tax on furnitures
		default: return(0);
		}
		
		
	}

	@Override
	public String toString() {
		return "\nMarketProduct \nid="+id + "\nname=" + name
				+ "\nprice=" + price + "\nstock="+stock + "\nproducer=" + producer + "\nstars=" + stars
				+ "\nshippingWeight=" + shippingWeight+"\ntype=" + type + "\nexpireDate=" + expireDate;
	}
	
	
	
	

}
