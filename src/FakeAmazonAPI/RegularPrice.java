/**
 * 
 */
package FakeAmazonAPI;

/**
 * Extends Price. 
 * Regular Price is a class for type of product that does not offer promotion 
 * no matter how much quantity the customer is buying. The price is only defined by the 
 * unit price. 
 * 
 * <p>@author jeremiesimon<\p>
 *
 */
public class RegularPrice extends Price{

	private int quantity = 0;
		
	public RegularPrice(double unitPrice) {
		super(unitPrice);
	}
	
	@Override
	void increaseQuantity(int q) {
		this.quantity+=q;
	}

	@Override
	double totalPrice(int quantity) {
		setQuantity(quantity);
		return quantity * unitPrice;
	}
	
	public double getUnitPrice(){
		return unitPrice; 
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString(){
		String out = "";
		out+="Unit Price: "+unitPrice;
		return out;
	}

	@Override
	public String viewTotalPrice(int quantity){
		String out = "";
		out+="Price: "+totalPrice(quantity);
		return out;
	}

	public static void main(String[]args){
		
		RegularPrice price = new RegularPrice(0.1);
		price.getUnitPrice();
		System.out.println(price.totalPrice(3));		
	}

}
