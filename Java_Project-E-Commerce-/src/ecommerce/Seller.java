package ecommerce;

public class Seller extends User{
	
	
	
	public Seller( String username, String password) {
		super(username, password);
	}
	public String toString() {
		return "Seller"+super.toString();
	}
}

