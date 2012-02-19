/**
 * 
 */
package FakeAmazonAPI;

import java.util.HashMap;

/**
 * This class is a customer class. 
 * Customer can perform 6 operations. 
 * 1. A customer can view the articles of the shop. <br>
 * 2. A customer can view a specific article in the shop <br>
 * 3. A customer can buy an article <br>
 * 4. A customer can remove this article <br>
 * 5. A customer can view his cart <br>
 * 6. A customer can checkout <br>
 * <p>@author jeremiesimon<\p>
 */
public class Customer {
	
	private HashMap <Product, Integer> cart= new HashMap <Product, Integer> ();
	private Terminal terminal; 
	
	/**
	 * @param terminal
	 */
	public Customer(Terminal terminal){
		this.terminal = terminal; 
	}
	
	/**
	 * Add x product to cart
	 * @param productID This is the product
	 * @param quantity 
	 */
	public void buy(String productID, int quantity){
		//send request to terminal
		//A transaction buy cannot be succesful if: 
		//1. not enough product in store
		//2. no such product
		Product product = terminal.buyProduct(productID, quantity);
		if (product != null){
			//update cart: 
			if (!cart.containsKey(product))
				cart.put(product, quantity);
			else{
				Integer q = cart.get(product) + quantity; 
				cart.put(product, q);
			}	
			System.out.println("Tansaction was succesful, product "+productID+" added to the cart");
			
		}
		else
			System.out.println("Transaction could not go through. " +
					"\nThere is not enough product "+productID+" in store to satisfy your demand.");
		
	}
	
	public void scan(String productsID){
		String [] productID = productsID.split("");
		for (String p: productID){
			if (p.compareTo("")!=0)
				buy(p, 1);
		}
	}
	
	/**
	 * Removes x number of a product from the cart
	 * @param productID
	 * @param quantity
	 */
	public String remove(String productID, int quantity){
		//Check if the customer have that much items in cart
		for (Product product: cart.keySet()){
			//1. if product exists
			if (product.getID().compareTo(productID) == 0){
				//2. if the quantity is legal
				if (cart.get(product) >= quantity && quantity >=1){
					terminal.removeProduct(product, quantity);
					//Update cart: 
					int newQuantity = cart.get(product) - quantity;
					//if the quantity is now 0. Remove product from cart
					if (newQuantity <=0)
						cart.remove(product);
					else
						cart.put(product, newQuantity);
					return("Tansaction was succesful");
				}
				//2. Cannot remove object than you have in memory
				else{
					return("You cannot remove from your cart more objects than you currently have");
				}
			}
			//1. Cannot remove an object that you don't have
		}
		return("You cannot remove from your cart a product that you don't have");

	}
	
	/**
	 * Update the data on the store side
	 * Print a summary of the transaction
	 */
	public String checkout(){
		//1. Update on the store side
		terminal.checkout();
		//2. Print a summary of the transaction
		String out = "\n-----\nYour final bill:\n";
		out+=viewCart();
		return out;
	}
	
	/**
	 * Returns a description of the given product
	 * @param productID
	 * @return description of the given product
	 */
	public String viewProduct(String productID){
		String out = "";
		out += terminal.viewProduct(productID);
		return out; 
	}
	
	/**
	 * Return all products available in the store
	 * @return list of all products in shop
	 */
	public String viewShop(){
		String out = "";
		out = terminal.viewShop();
		return out; 
	}
	
	/**
	 * Return the current cart
	 * @return list of all products currently in cart
	 */
	public String viewCart(){
		String out = "-----\nYour Cart:\n";
		if (cart.isEmpty()){
			return "Your cart is empty";
		}
		double total = 0;
		for (Product product: cart.keySet()){
			double subtotal = subTotal(product, cart.get(product));
			total +=subtotal;
			out+=product+"\t\tQuantity: "+cart.get(product)+"\t\tPrice: "+subtotal+"\n";
		}
		out+="TOTAL: "+total+"\n";
		out+="-----\n";
		return out; 
	}
	
	private double subTotal(Product product, int quantity){
		double sub = product.getTotalPrice(quantity);
		return sub;
	}
}
