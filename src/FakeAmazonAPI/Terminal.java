/**
 * 
 */
package FakeAmazonAPI;

/**
 * A client connect to the terminal
 * to interact with the shop. Only 1 instance of the terminal 
 * can be created. This is a way to avoid a threading problem.
 * Typically, this is acting as a controller.   
 * <p>@author jeremiesimon<\p>
 */
public class Terminal {
	
	private static Terminal instance = null;
	private GroceryShop shop; 
	
	private Terminal(GroceryShop shop) {
		this.shop = shop;
		instance = this; 
	}
	public static Terminal getInstance(GroceryShop shop) {
		if(instance == null) 
			instance = new Terminal(shop);
		return instance;
	}
	
	/**
	 * @return all products of the shop
	 */
	public String viewShop(){
		String out = shop.shopView();
		return out; 
	}
	
	/**
	 * Return a description of the given product
	 * @param productID
	 * @return description of the product
	 */
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
	
	/**
	 * 
	 * @param productID
	 * @param quantity
	 * @return Product object that was bought
	 */
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
	
	public void checkout(){
		shop.checkout();
	}
	
	/**
	 * 
	 * @param product
	 * @param quantity
	 * @return true if the transaction was successful 
	 */
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
