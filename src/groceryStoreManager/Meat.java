/**
 * @author skyla tran
 * section: css 143b
 * program: grocery store manager
 * description: This program simulates a grcoery store management system, 
 * with the abilities to stock items in an inventory, process orders and 
 * update the inventory to reflect that, along with add items to the restock list and
 * display both restocking and inventory items.
 * class: Meat; class for creating meat grocery items with special datam
 * isGround. Inherits from the GroceryItem. 
 */
package groceryStoreManager;

public class Meat extends GroceryItem
{
	//instance variables
	private boolean isGround;
	
	/**
	 * @param inputLine
	 */
	public Meat (String inputLine)
	{
		//splitting string at spaces, parsing appropricate data pieces
		String[] inputSplit = inputLine.split(" ");
		String name = inputSplit [1];
		int quantity = Integer.parseInt(inputSplit[2]);
		double price = Double.parseDouble(inputSplit [3]);
		boolean isGround = Boolean.parseBoolean (inputSplit [4]);
		
		setName (name);
		setQuantity (quantity);
		setPrice (price);
		setIsGround (isGround);
	}
	
	/**
	 * @param name
	 * @param quantity
	 * @param price
	 * @param isGround
	 */
	public Meat (String name, int quantity, double price, boolean isGround)
	{
		super (name, quantity, price);
		setIsGround (isGround);
	}
	
	/**
	 * @param ground
	 * @return void
	 */
	public void setIsGround (boolean ground)
	{
		this.isGround = ground;
	}
	
	/**
	 * @return boolean
	 */
	public boolean getIsGround()
	{
		boolean groundRet = this.isGround;
		return groundRet;
	}
	
	/**
	 * @return String
	 * @Override
	 */
	public String toString()
	{
		//String currentRetVal = super.toString();
		String currentRetVal = ("ground: " + getIsGround());
		return currentRetVal;
		
	}
}
