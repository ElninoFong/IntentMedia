/**
 * 
 */
package FakeAmazonAPI;

/**
 * Interface Shop. This assumes that in the future there will/might be several shops. 
 * <p>@author jeremiesimon<\p>
 *
 */
public interface Shop {
	
	public String shopView();
	public String productView(Product product);
	public boolean updateProduct(Product product, int quantity);
	
}
