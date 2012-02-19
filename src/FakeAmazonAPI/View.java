package FakeAmazonAPI;

import java.util.Scanner;

/**
 * This is a temporary view. I had no time to do a GUI. 
 * So for now the client can only interact with the program through that class by typing some commands. 
 * <p>@author jeremiesimon<\p>
 *
 */

public class View {

	public static void main(String[]args){
	
		GroceryShop shop = new GroceryShop("super grocery");
		Terminal terminal = Terminal.getInstance(shop);
		Customer c = new Customer (terminal);
		Scanner in = new Scanner (System.in);
	
		System.out.println("Set of commands:\n" +
				"viewShop : this will show you all the the products from the store\n" +
				"viewProduct productID: this will only give you information about the productID you provided\n" +
				"buy productID quantity: this will make you buy the quantity you input of the given product\n" +
				"scan productIDs: this is to buy several items at the time (eg: scan ABAADC)\n"+
				"remove productID quantity: this will remove the quantity of the product you gave from your cart\n" +
				"viewCart: this will show you all the products you have in your cart\n" +
				"checkout: this will confirm the transaction. When doing this, you cannot undo.");
		
		boolean isCheckout = false;
		while(!isCheckout){
			String command = in.nextLine();	
			
			if (command.toLowerCase().startsWith("viewshop")){
				System.out.println(c.viewShop());
			}
			else if (command.toLowerCase().startsWith("viewproduct")){
				String [] line = command.split(" ");
				String productID = ""; 
				try{
				productID = line[1];
				System.out.println(c.viewProduct(productID));
				}
				catch (ArrayIndexOutOfBoundsException e){
					   System.out.println("You shoud provide the id of the prodcut");
				}
				
			}
			else if (command.startsWith("buy")){
				String [] line = command.split(" ");
				String productID = ""; 
				int quantity; 
				try{
				productID = line[1];
				quantity = Integer.valueOf(line[2]);
				c.buy(productID, quantity);
				}
				catch (ArrayIndexOutOfBoundsException e){
					   System.out.println("You shoud provide the id of the prodcut and the quantity");
				}
				catch(NumberFormatException e){
					System.out.println("You should provide the productID and then the quantity");
				}	
			}
			
			else if(command.startsWith("scan")){ 
				String [] line = command.split(" ");
				String productID = ""; 
				try{
				productID = line[1];
				c.scan(productID);
				}
				catch (ArrayIndexOutOfBoundsException e){
					   System.out.println("You shoud provide the id of the prodcut and the quantity");
				}
			}
			else if (command.startsWith("remove")){
				String [] line = command.split(" ");
				String productID = ""; 
				int quantity; 
				try{
				productID = line[1];
				quantity = Integer.valueOf(line[2]);
				System.out.println(c.remove(productID, quantity));
				}
				catch (ArrayIndexOutOfBoundsException e){
					   System.out.println("You shoud provide the id of the prodcut and the quantity");
				}
				catch(NumberFormatException e){
					System.out.println("You should provide the productID and then the quantity");
				}
				
			}
			else if (command.toLowerCase().startsWith("viewcart")){
				System.out.println(c.viewCart());
			}
			else if (command.toLowerCase().startsWith("checkout")){
				System.out.println(c.checkout());
				isCheckout = true;
			}
			else{
				System.out.println("this command is not valid");
			}
			
		}
	
	}
	
}
