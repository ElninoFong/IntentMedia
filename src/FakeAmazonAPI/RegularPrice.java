/**
 * 
 */
package FakeAmazonAPI;

/**
 * @author jeremiesimon
 *
 */
public class RegularPrice extends Price{

	private int quantity = 0;
	private double unitPrice;
	private boolean hasVolumePromotion = false;
		
	public RegularPrice(double unitPrice) {
		super(unitPrice);
	}
	
	@Override
	void increaseQuantity(int q) {
		this.quantity+=q;
	}

	@Override
	double totalPrice() {
		return quantity * unitPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean isHasVolumePromotion() {
		return hasVolumePromotion;
	}

	public void setHasVolumePromotion(boolean hasVolumePromotion) {
		this.hasVolumePromotion = hasVolumePromotion;
	}

	@Override
	public String toString(){
		String out = "";
		out+="Unit Price: "+unitPrice;
		return out;
	}

	@Override
	public String viewTotalPrice(){
		String out = "";
		out+="Price: "+totalPrice();
		return out;
	}

	
}
