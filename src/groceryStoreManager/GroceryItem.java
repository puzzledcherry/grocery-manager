/**
 * @author skyla tran
 * section: css 143b
 * program: grocery store manager
 * description: This program simulates a grcoery store management system, 
 * with the abilities to stock items in an inventory, process orders and 
 * update the inventory to reflect that, along with add items to the restock list and
 * display both restocking and inventory items. 
 * class: Grocery Item; the parent off inventory items. Is used
 * to create categories (dairy, produce, meat) for item creation.
 */

//packages and imports
package groceryStoreManager;

public abstract class GroceryItem implements Comparable <Object>
{
	//instance variables
	private String name;
	private int quantity;
	private double price;
	
	//noargs constructor
	public GroceryItem ()
	{
		
	}
	
	/**
	 * @param name
	 * @param quantity
	 * @param price 
	 */
	public GroceryItem (String name, int quantity, double price)
	{
		setName(name);
		setQuantity (quantity);
		setPrice (price);
	}
	
	/**
	 * @param name
	 * @return void
	 */
	public void setName (String name)
	{
		this.name = name;
	}
	
	/**
	 * @param quantity
	 * @return void
	 */
	public void setQuantity (int quantity)
	{
		//bounding checking, quantity is valid
		if (quantity >= 0)
		{
			this.quantity = quantity;
		}
	}

	/**
	 * @param price
	 * @return void
	 */
	public void setPrice (double price)
	{
		//bounds checking, price is valid
		if (price >= 0)
		{
			this.price = price;
		}
	}
	
	/**
	 * @return string
	 */
	public String getName()
	{
		//deepcopy then return
		String nameRet = this.name;
		return nameRet;
	}
	
	/**
	 * @return int
	 */
	public int getQuantity()
	{
		int quantityRet = this.quantity;
		return quantityRet;
	}
	
	/**
	 * @return double
	 */
	public double getPrice()
	{
		double priceRet = this.price;
		return priceRet;
	}
	
	/**
	 * @return String
	 * @Override
	 */
	public String toString()
	{
		String retVal = ("name: " + getName() + " price: $" 
						+ getPrice() + " quantity: " + getQuantity());
		return retVal;
	}
	
	/**
	 * @param o
	 * @return int
	 * @Override
	 */
	public int compareTo (Object o)
	{
		//checking if valid class
		if (!(o instanceof GroceryItem))
		{
			System.out.println ("object not an instance of GroceryItem!");
			return -100;
		}
		
		//casting, comparing by name
		GroceryItem other = (GroceryItem) o;
		return (this.name.compareTo(other.name));
	}
}
