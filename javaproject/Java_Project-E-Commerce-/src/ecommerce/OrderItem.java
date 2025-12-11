package ecommerce;

public class OrderItem {
	
	
    private Product product;
    
   
    private int quantity;
    
  


    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
     
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    
   
    public double getLineItemWeight() 
    {
        // Uses the Product's weight and multiplies it by the quantity
        return this.product.getShippingWeight() * this.quantity;
    }
    
    public double getLineItemSubtotal()  //calculating the taxIncluded price for the product and how many of it's purchased.
    {
      double taxRate= product.calculateTax();
      double basePrice=product.getPrice();
      double finalPrice=basePrice*(1+taxRate);
      return(finalPrice*this.quantity);
    }

	@Override
	public String toString() 
	{
		return "\nProduct Id="+product.getId()+"\nProduct Name=" + product.getName() + "\nProduct Price(without taxes)="+product.getPrice() +"quantity=" + quantity;
	}
    
    

}
