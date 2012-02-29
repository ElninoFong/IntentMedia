/**
 * 
 */
package FakeAmazonAPI;

/**
 * VolumePrice extends Price. This class is describing a price that is defined by it's unit price
 * and by some promotion. eg: unit price = 3, and the price for 4 items is 10. 
 * <p>@author jeremiesimon<\p>
 *
 */
public class VolumePrice extends Price {

	private int volumePromotion; 
	private double volumePrice;
	private boolean hasVolumePromotion = true;
	

	public VolumePrice(double unitPrice, int volumePromotion, double volumePrice){
		super(unitPrice);
		this.volumePromotion = volumePromotion; 
		this.volumePrice = volumePrice;
	}
	
	@Override
	void increaseQuantity(int q) {
		this.quantity +=q; 
	}

	@Override
	double totalPrice(int quantity) {
		setQuantity(quantity);
		double totalPrice =  (quantity / volumePromotion) * volumePrice;
		totalPrice += (quantity%volumePromotion) * unitPrice;
		return totalPrice;
	}
	
	/**
	 * 
	 */
	public int getQuantity() {
		return quantity;
	}
	
	public int getVolumePromotion(){
		return volumePromotion;
	}
	
	public double getVolumePrice(){
		return volumePrice;
	}

	/**
	 * 
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

 
	public boolean isHasVolumePromotion() {
		return hasVolumePromotion;
	}

	/**
	 * 
	 * @param hasVolumePromotion
	 */
	public void setHasVolumePromotion(boolean hasVolumePromotion) {
		this.hasVolumePromotion = hasVolumePromotion;
	}

	@Override	
	public String viewTotalPrice(int quantity){
		String out = "";
		out+="Price: "+totalPrice(quantity);
		return out;
	}

	@Override
	public String toString(){
		String out = "";
		out+="Unit Price: "+unitPrice+" Promotion: "+volumePromotion+" for "+volumePrice;
		return out;
	}
	
	
	public static void main(String[]args){
		
		Price price = new VolumePrice(20.0, 2, 35.0);
		price.setQuantity(3);
		System.out.println(price);
		
	}


}
