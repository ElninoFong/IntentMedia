/**
 * 
 */
package FakeAmazonAPI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author jeremiesimon
 */

public class GroceryShop implements Shop{

	HashMap <Product, Integer> products; 
	private ArrayList <Customer> customers = new ArrayList <Customer> (); 
	private  Terminal terminal; 
	private String fileName; 
	private String name; 
	
	public GroceryShop(String name){
		this.name = name; 
		products = new HashMap <Product, Integer> (); 		
		
		this.fileName = "price.txt";
		try{
			parser();
		}
		catch (Exception e){
			    System.err.format("IO Exception");
			  } 
	}
	
	@Override
	public String shopView() {
		String view = "";
		for (Product product: products.keySet()){
			view+=product+"\n";
		}
		return view;
	}

	@Override
	public String productView(Product product) {
		// Return the corresponding item
		String view;
		Integer q = products.get(product);
		if(q == null) {
			view = "This product is not in store";
		}else
			view = product+"\n";
		return view;
	}

	@Override
	public boolean updateProduct(Product product, int quantity) {
		 
		//check if product is in store: 
		if (products.get(product)== null){
			System.out.println("This product is not in store");
			return false;
		}
		else{
			//add case:
			//if quantity is positive it will decrease the quantity of the product
			//Remove case: 
			//if quantity is negative it will increase the quantity of the product
			if (products.get(product) >= quantity){
				Integer oldQuantity = products.get(product);
				products.put(product,oldQuantity - quantity);
				return true;
			}
			else{
				System.out.println("There is not enough quantity in stock for this demand");
			}
			return false;

		}

		
	}
	
	private void parser() throws IOException{
		 BufferedReader reader = new BufferedReader(new FileReader(fileName));
		 String line;
		    
	     while ((line =reader.readLine()) != null){
	    	 String[] words = line.split(" ");
	    	 if (words.length == 3){
		    	 String ID = words[0];
		    	 double unitPrice = Double.valueOf(words[1]);
		    	 int quantity = Integer.valueOf(words[2]);

		    	 products.put(new Product(ID, new RegularPrice(unitPrice)), quantity);

	    	 }
	    	 else if (words.length == 5){
		    	 String ID = words[0];
		    	 double unitPrice = Double.valueOf(words[1]);
		    	 int volumeQuantity = Integer.valueOf(words[2]);
		    	 double volumePrice = Double.valueOf(words[3]);
		    	 int quantity = Integer.valueOf(words[4]);
		    	 
		    	 products.put(new Product(ID, new VolumePrice(unitPrice, volumeQuantity, volumePrice)), quantity);
		    	 
	    	 }
	     }		 
	}
	
	public static void main(String[]args){
	
		GroceryShop g = new GroceryShop("grocery");
		System.out.println(g.shopView());
		System.out.println(g.productView(new Product("A", new VolumePrice(10, 3, 25))));
		//System.out.println(g.productView("B"));
		//System.out.println(g.productView("E"));
		//g.updateProduct("A", -2);
		//System.out.println(g.productView("A"));




	}

}
