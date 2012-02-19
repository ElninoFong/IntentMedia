/**
 * 
 */
package FakeAmazonAPI;

/**
 * This is an abstract class of price.
 * Each product has a price object that will act differently. 
 * There are only 2 types of prices for now: RegularPrice and VolumePrice, but
 * we can easily imagine other types of price like promotion and so on. 
 * <br>@author jeremiesimon <\br>
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
	abstract double totalPrice (int quantity);
	abstract String viewTotalPrice(int quantity);

}
