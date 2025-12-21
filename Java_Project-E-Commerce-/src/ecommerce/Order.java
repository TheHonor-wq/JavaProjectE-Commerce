package ecommerce;

import java.util.ArrayList;
import java.util.Objects;

public class Order implements Comparable<Order>{
	private int id;//protected
	private int customer_id;
	private ArrayList<OrderItem> items = new ArrayList<>();
	private double totalShippingFee;
	
	
	static private int order_count = 0;
	
	public Order(int customer_id) {
		super();
		this.id = order_count;
		this.customer_id = customer_id;		
		order_count++;
	}


	public int getId() {
		return id;
	}
	public int getCustomerId() {
		return customer_id;
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
	public boolean addItem(OrderItem orderItem) {
		return items.add(orderItem);
	}
	


	public void setCustomer(int customer_id) {
		this.customer_id = customer_id;
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
		for(int i=0;i<items.size();i++)//(item : items)
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
		Order other = (Order) obj;
		return id == other.id;
	}


	@Override
	public String toString() {
		String output="\nOrder:";
		for(OrderItem item:this.items) //for each loop for iterating through this ArrayList.
		{
			output+=item.toString();
		}
		output+="\n\nTotal Shipping Fee: ";
		output+=calculateTotalShippingFee();
		output+=" TL";
		output+="\n\nFINAL ORDER TOTAL: ";
		output+=calculateOrderTotal();
		output+=" TL";
		return output;
	}
	
	
	@Override
    public int compareTo(Order other) {
        // According to ids
        return Integer.compare(this.id, other.id);
    }

}
















