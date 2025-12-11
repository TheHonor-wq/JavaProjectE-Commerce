package ecommerce;

import java.util.ArrayList;

public class Customer extends User{
	private String address;
	private ArrayList<Order> orders = new ArrayList<>();
	
	
	
	
	public Customer(String address, ArrayList<Order> orders) {
		super();
		this.address = address;
		this.orders = orders;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order)
	{
		orders.add(order);
	}
	
	

}
