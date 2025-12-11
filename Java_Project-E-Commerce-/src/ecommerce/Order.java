package ecommerce;

import java.util.ArrayList;

public class Order {
	private int id;
	private ArrayList<OrderItem> items = new ArrayList<>();
	private Customer customer;
	private double totalShippingFee;
	
	
	public Order(int id,Customer customer,ArrayList<OrderItem> items) {
		super();
		this.id = id;
		this.items = items;
		this.customer = customer;
		if(customer!=null)
		{
			customer.addOrder(this); 
		}
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<OrderItem> getItems() {
		return items;
	}


	public void setItems(ArrayList<OrderItem> items) {
		this.items = items;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public double getTotalShippingFee() {
		return totalShippingFee;
	}


	public void setTotalShippingFee(double totalShippingFee) {
		this.totalShippingFee = totalShippingFee;
	}
	
	
	public double calculateTotalShippingFee() //calculates the total weight and determines the shippingFee accordingly.
	{
		double totalWeight=0;
		for(int i=0;i<items.size();i++)
		{
			totalWeight+=items.get(i).getLineItemWeight();
		}
		double weightKg = totalWeight / 1000.0;  //for easier calculation, because totalWeight was in grams
        
        if (weightKg > 20.0) {
            this.totalShippingFee = 350.0;
        } else if (weightKg > 5.0) {
            this.totalShippingFee = 150.0;
        } else if (weightKg > 0) {
            this.totalShippingFee = 75.0;
        } else {
            this.totalShippingFee = 0.0;
        }
        return this.totalShippingFee;
		
	}
	public double calculateSubtotals()
	{
		double subtotals=0;
		for(int i=0;i<items.size();i++)
		{
			subtotals+= items.get(i).getLineItemSubtotal();
		}
		return subtotals;
	}
	public double calculateOrderTotal()
	{
		double shippingFee=calculateTotalShippingFee();
		double subtotals = calculateSubtotals();
		return(shippingFee+subtotals);
	}


	@Override
	public String toString() {
		String output="\nOrder:";
		for(OrderItem item:this.items) //for each loop for iterating through this ArrayList.
		{
			output+=items.toString();
		}
		output+="\n\nTotal Shipping Fee: ";
		output+=calculateTotalShippingFee();
		output+=" TL";
		output+="\n\nFINAL ORDER TOTAL: ";
		output+=calculateOrderTotal();
		output+=" TL";
		return output;
	}
	
	
	

}
















