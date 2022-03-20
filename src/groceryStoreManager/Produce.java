/**
 * @author skyla tran
 * section: css 143b
 * program: grocery store manager
 * description: This program simulates a grcoery store management system, 
 * with the abilities to stock items in an inventory, process orders and 
 * update the inventory to reflect that, along with add items to the restock list and
 * display both restocking and inventory items.
 * class: Produce; class for creating produce grocery items with special datam
 * isOrganic. Inherits from the GroceryItem.
 */

//packages and imports
package groceryStoreManager;

public class Produce extends GroceryItem
{
	//instance variables
	private boolean isOrganic;
	
	/**
	 * @param inputLine
	 */
	public Produce (String inputLine)
	{
		//splitting string at spaces, parsing appropricate data pieces
		String[] inputSplit = inputLine.split(" ");
		String name = inputSplit [1];
		int quantity = Integer.parseInt(inputSplit[2]);
		double price = Double.parseDouble(inputSplit [3]);
		boolean isOrganic = Boolean.parseBoolean (inputSplit [4]);
		
		//setting all instance variables
		setName (name);
		setQuantity (quantity);
		setPrice (price);
		setIsOrganic (isOrganic);
	}
	
	/**
	 * @param name
	 * @param quantity
	 * @param price
	 * @param isOrganic
	 */
	public Produce (String name, int quantity, double price, boolean isOrganic)
	{
		super (name, quantity, price);
		setIsOrganic (isOrganic);
	}
	
	/**
	 * @param isOrganic
	 * @return void
	 */
	public void setIsOrganic (boolean organic)
	{
		this.isOrganic = organic;
	}
	
	/**
	 * @return boolean
	 */
	public boolean getIsOrganic ()
	{
		boolean organicRet = this.isOrganic;
		return organicRet;
	}
	
	/**
	 * @return String
	 * @Override
	 */
	public String toString()
	{
		//String currentRetVal = super.toString();
		String currentRetVal = ("organic: " + getIsOrganic());
		return currentRetVal;
		
	}

}
