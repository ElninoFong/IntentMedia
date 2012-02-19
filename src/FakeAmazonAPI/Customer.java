/**
 * 
 */
package FakeAmazonAPI;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author jeremiesimon
 *
 */
public class Customer {
	
	private Shop shop; 
	//private ArrayList <Product> cart = new ArrayList <Product> ();
	private HashMap <Product, Integer> cart= new HashMap <Product, Integer> ();
	private Terminal terminal; 
	
	/**
	 * 
	 * @param shop
	 * @param terminal
	 */
	public Customer(Shop shop, Terminal terminal){
		this.shop = shop; 
		this.terminal = terminal; 
	}
	
	/**
	 * 
	 * @param productID
	 * @param quantity
	 */
	public void buy(String productID, int quantity){
		//send request to terminal
		//A transaction buy cannot be sucesful if: 
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
			System.out.println("Tansaction was succesful");
			
		}
		else
			System.out.println("Transaction could not go through. " +
					"\nThere is not enough product in store to satisfy your demand.");
		
	}
	
	/**
	 * 
	 * @param productID
	 * @param quantity
	 */
	public void remvove(String productID, int quantity){
		//Check if the customer have that much items in cart
		for (Product product: cart.keySet()){
			//if product exists
			if (product.getID().compareTo(productID) == 0){
				//if the quantity is legal
				if (cart.get(product) >= quantity){
					terminal.removeProduct(product, quantity);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param productID
	 * @return
	 */
	public String viewProduct(String productID){
		String out;
		out = terminal.viewProduct(productID);
		return out; 
	}
	
	/**
	 * 
	 * @return
	 */
	public String viewShop(){
		String out;
		out = terminal.viewShop();
		return out; 
	}
	
	/**
	 * 
	 * @return
	 */
	public String viewCart(){
		String out = "";
		if (cart.isEmpty()){
			return "Your cart is empty";
		}
		for (Product product: cart.keySet()){
			out+=product+"\t"+cart.get(product)+"\n";
		}
		return out; 
	}
}
