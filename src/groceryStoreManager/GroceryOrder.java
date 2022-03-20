/**
 * @author skyla tran
 * section: css 143b
 * program: grocery store manager
 * description: This program simulates a grcoery store management system, 
 * with the abilities to stock items in an inventory, process orders and 
 * update the inventory to reflect that, along with add items to the restock list and
 * display both restocking and inventory items.
 * class: GroceryOrder; works exactly like java arrayList, but only
 * allows for groceryItem instances
 */

//packages and imports
package groceryStoreManager;
import java.util.ArrayList;

public class GroceryOrder <T extends GroceryItem> extends ArrayList <GroceryItem>
{
	private static final long serialVersionUID = 4549854309766913201L;
}
