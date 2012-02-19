package FakeAmazonAPI;

public class Product {

	private String ID; 
	private Price price; 	

	
	public Product(String ID, Price price){
		this.ID = ID; 
		this.price = price; 
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Price getPrice() {
		return price;
	}

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
		Product p = new Product ("A", new VolumePrice(20.0, 2, 35.0));
		System.out.println(p);
	}
	
	

	
}
