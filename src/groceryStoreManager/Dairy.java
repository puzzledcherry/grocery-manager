/**
 * @author skyla tran
 * section: css 143b
 * program: grocery store manager
 * description: This program simulates a grcoery store management system, 
 * with the abilities to stock items in an inventory, process orders and 
 * update the inventory to reflect that, along with add items to the restock list and
 * display both restocking and inventory items. 
 * class: Dairy; class for creating dairy grocery items with special datam 
 * refridgeration temperature. Inherits from the GroceryItem.
 */

//packages and imports
package groceryStoreManager;

public class Dairy extends GroceryItem
{
	//instance variables
	private int refrigerationTemperature;
	
	/**
	 * @param inputLine
	 */
	public Dairy (String inputLine)
	{
		//splitting string at spaces, parsing appropricate data pieces
		String[] inputSplit = inputLine.split(" ");
		String name = inputSplit [1];
		int quantity = Integer.parseInt(inputSplit[2]);
		double price = Double.parseDouble(inputSplit [3]);
		int temp = Integer.parseInt(inputSplit[4]);
		
		//setting all instance variables
		setName (name);
		setQuantity (quantity);
		setPrice (price);
		setRefrigerationTemperature (temp); 
	}
	
	/**
	 * @param name
	 * @param quantity
	 * @param price
	 * @param refrigerationTemperature
	 */
	public Dairy (String name, int quantity, double price, int refrigerationTemperature)
	{
		super (name, quantity, price);
		setRefrigerationTemperature (refrigerationTemperature);
	}
	
	/**
	 * @param temp
	 * @return void
	 */
	public void setRefrigerationTemperature (int temp)
	{
		this.refrigerationTemperature = temp;
	}
	
	/**
	 * @return int
	 */
	public int getRefrigerationTemperature()
	{
		int tempRet = this.refrigerationTemperature;
		return tempRet;
	}
	
	/**
	 * @return String
	 * @Override
	 */
	public String toString()
	{
		//String currentRetVal = super.toString();
		String currentRetVal = ("refrigeration temperature: " + getRefrigerationTemperature());
		return currentRetVal;
	}

}
