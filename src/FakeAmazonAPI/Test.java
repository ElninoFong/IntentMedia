package FakeAmazonAPI;

import java.util.HashMap;

public class Test {

	/**
	 * @param args
	 */

	
	public static void main(String []args){
		
		GroceryShop shop = new GroceryShop("super grocery");
		Terminal terminal = Terminal.getInstance(shop);
		Customer c = new Customer (shop, terminal);
		
		System.out.println(c.viewCart());
		System.out.println(c.viewShop());
		System.out.println(c.viewProduct("A"));
		
		c.buy("A",3);
		System.out.println(c.viewCart());

		
		/*System.out.println(terminal.viewShop()); 
		
		System.out.println("\n\n");
		
		String out; 
		out = terminal.viewProduct("A");
		System.out.println(out);
		out = terminal.viewProduct("B");
		System.out.println(out);
		out = terminal.viewProduct("E");
		System.out.println(out);
		
		HashMap <String, Integer> tt = new HashMap <String,Integer> ();
		tt.put("A", 0);
		
		if ((tt.containsKey("A"))){
			int q = 3; 
			q+=tt.get("A"); 
			tt.put("A", q);
		}
		System.out.println(tt.get("A"));
		
		System.out.println(tt.containsKey("B"));
		*/
		
	}

}
