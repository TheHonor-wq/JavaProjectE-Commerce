package ecommerce;

public class OrderItem {
	
	
    private int product_id;
    private int quantity;
    
  


    public OrderItem(int product_id, int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
     
    }

    public int getProductID() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }
    public double getLineItemWeight() 
    {
        // Uses the Product's weight and multiplies it by the quantity
    	Product product  = ECommerceSys.searchProductById(product_id);
    	if(product==null) {
    		System.out.println("Error in 'getLineItemWeight()' [cant found the product]");
    		return 0;
    	}
    	
        return product.getShippingWeight() * this.quantity;
    }
    public double getLineItemSubtotal()  //calculating the taxIncluded price for the product and how many of it's purchased.
    {
    	Product product  = ECommerceSys.searchProductById(product_id);
    	if(product==null) {
    		System.out.println("Error in 'getLineItemSubtotal()' [cant found the product]");
    		return 0;
    	}
      double taxRate= product.calculateTax();
      double basePrice=product.getPrice();
      double finalPrice=basePrice*(1+taxRate);
      return(finalPrice*this.quantity);
    }
	@Override
	public String toString() 
	{
		return "\nProduct Id="+product_id+"quantity=" + quantity;
	}
    
    

}
