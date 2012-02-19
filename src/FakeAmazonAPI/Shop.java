/**
 * 
 */
package FakeAmazonAPI;

/**
 * @author jeremiesimon
 *
 */
public interface Shop {
	
	public String shopView();
	public String productView(Product product);
	public boolean updateProduct(Product product, int quantity);
	
}
