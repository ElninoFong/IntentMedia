/**
 * 
 */
package FakeAmazonAPI;

/**
 * @author jeremiesimon
 *
 */
public abstract class Price {
	
	protected double unitPrice;
	protected int quantity = 0;

	public Price(double unitPrice){
		
		this.unitPrice = unitPrice; 
		this.quantity = 0; 
	}

	abstract void increaseQuantity (int q);
	abstract void setQuantity(int quantity);
	abstract int getQuantity();
	abstract double totalPrice ();
	abstract String viewTotalPrice();

}
