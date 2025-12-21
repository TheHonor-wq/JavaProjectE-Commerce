package ecommerce;

public class TechProduct extends Product{ 
	
	private String type; //phone,laptop,console,television
	private int yearOfProduction;
	private boolean guarentee; 
	//if it is a phone it is 100 g, 
	//laptop is 2000g
	//television 20000g
	//console is 3000g 
	
	

	@Override
	public double calculateTax() { //tax is 40% for the tech products
		return(0.4);
	}


	public TechProduct(int seller_id,String name, double price, int stock, String producer, double stars, String type,
			int yearOfProduction, boolean guarentee) {
		super(seller_id,name, price, stock, producer, stars);
		this.type = type;
		this.yearOfProduction = yearOfProduction;
		this.guarentee = guarentee;
		
		String normalized =type.toLowerCase();
		switch(normalized)
		{
		case "phone":
			shippingWeight=100;
			break;
		case "laptop":
			shippingWeight=2000;
			break;
		case "television":
			shippingWeight=20000;
			break;
		case "console":
			shippingWeight=3000;
			break;
		default:
			shippingWeight=0;
			break;
			
		}
	}











	public String getType() {
		return type;
	}








	public void setType(String type) {
		this.type = type;
	}








	public int getYearOfProduction() {
		return yearOfProduction;
	}








	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}



	public boolean isGuarentee() {
		return guarentee;
	}



	public void setGuarentee(boolean guarentee) {
		this.guarentee = guarentee;
	}



	@Override
	public String toString() {

	String output = "\nTechProduct \nid=" + this.id +  "\nname=" + name + "\nprice=" + price + "\nstock=" + stock + "\nproducer=" + producer
			+ "\nstars=" + stars + "\nshippingWeight=" + shippingWeight
			+"\ntype=" + type + "\nyearOfProduction=" + yearOfProduction+"\nguarentee="+guarentee;
		return output;
	}				

	


	

}
