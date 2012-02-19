package FakeAmazonAPI;

/**
 * Product class. 
 * <br>@author jeremiesimon <\br>
 */
public class Product {

	private String ID; 
	private Price price; 	

	
	public Product(String ID, Price price){
		this.ID = ID; 
		this.price = price; 
	}

	/**
	 * @return the ID of the product
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Set the ID of the product
	 * @param iD
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @param quantity number of instances of that product
	 * @return the total price for this product
	 */
	public double getTotalPrice(int quantity) {
		return  price.totalPrice(quantity);
	}
	
	public Price getPrice(){
		return price; 
	}

	/**
	 * @param price
	 */
	public void setPrice(Price price) {
		this.price = price;
	}
	
	@Override
	public String toString(){
		String out = "";
		out+= "ID: "+ID+", "+price;
		return out;
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj)
			return true;	
		if (obj == null)
			return false;
	
		if (!(obj instanceof Product))
			return false;
		
		String PID = ((Product) obj).getID();
		if (PID.compareTo(ID)==0){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.ID.hashCode(); 
	}
	
	public static void main(String[]args){
		Product p = new Product ("A", new RegularPrice(0.1));
		System.out.println(p);
		System.out.println(p.getTotalPrice(3));
	}
	
	

	
}
