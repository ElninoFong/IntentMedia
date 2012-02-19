/**
 * 
 */
package FakeAmazonAPI;

/**
 * @author jeremiesimon
 *
 */
public class Terminal {
	
	private static Terminal instance = null;
	private GroceryShop shop; 
	private Customer customer; 
	
	
	private Terminal(GroceryShop shop) {
		this.shop = shop;
		instance = this; 

	}
	public static Terminal getInstance(GroceryShop shop) {
		if(instance == null) 
			instance = new Terminal(shop);
		return instance;
	}
	
	public String viewShop(){
		String out = shop.shopView();
		return out; 
	}
	
	public String viewProduct(String productID){
		String out = "";
		Product p; 
		for (Product product: shop.products.keySet()){
			if (product.getID().compareTo(productID) == 0){
				p = product; 
				out = shop.productView(p);
				return out; 
			}
		}
		return "No such product in store";
	}
	
	public Product buyProduct(String productID, int quantity){
		//Need to check that: 
		//1. not enough product in store to satisfy demand
		//2. such product does exist
		Product p; 
		for (Product product: shop.products.keySet()){
			if (product.getID().compareTo(productID) == 0){
				p = product; 
				//Check if enough products in store: 
				if (shop.products.get(product) >= quantity){
					//update on the shop side
					if (shop.updateProduct(product, quantity)){
					return p; 
					}
				}
			}
		}
		return null; 
	}
	
	
	public boolean removeProduct(Product product, int quantity){
		//Assume that the customer does have this quantity of product in its cart. 
		//So the checking was made earlier
		//update on the shop side
		return shop.updateProduct(product, -quantity);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
		


	
}
