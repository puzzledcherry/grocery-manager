/**
 * @author skyla tran
 * section: css 143b
 * program: grocery store manager
 * description: This program simulates a grcoery store management system, 
 * with the abilities to stock items in an inventory, process orders and 
 * update the inventory to reflect that, along with add items to the restock list and
 * display both restocking and inventory items.
 * class: Grocery Manager; used to load inventory, process orders, 
 * display and sort items related to the grocery items. 
 */

//packages and imports
package groceryStoreManager;
import java.io.*;
import java.util.*;
import java.text.*;

public class GroceryManager 
{
	//instance variables
	private ArrayList <GroceryItem> inventory = new ArrayList<>();
	private HashSet <String> restockingList = new HashSet<>();
	
	private static final DecimalFormat df = new DecimalFormat ("0.00");

	/**
	 * @param filename 
	 * @return void
	 * @throws FileNotFoundException !!! DOUBLE CHECK THIS !!!
	 * reads in the inventory of dairy, produce, meats and stocks up the 
	 * inventory arrayList with appropriately classed items
	 */
	public void loadInventory(String filename) 
	{
		try
		{
			//file + scanner opening
			File stock = new File (filename);
			Scanner scanner = new Scanner (stock);
			int numDairy = scanner.nextInt();
			int numProduce = scanner.nextInt();
			int numMeat = scanner.nextInt();
			
			//stocking the dairy
			for (int i = 0; i < numDairy; i++)
			{
				scanner.next();
				this.inventory.add(new Dairy (scanner.nextLine()));
			}
			
			//stocking the produce
			for (int i = 0; i < numProduce; i++)
			{
				scanner.next();
				this.inventory.add(new Produce (scanner.nextLine()));
			}
			
			//stocking the meat
			for (int i = 0; i < numMeat; i++)
			{
				scanner.next();
				this.inventory.add(new Meat (scanner.nextLine()));
			}
			
			//closing the scanner
			scanner.close();	
		}
		catch (FileNotFoundException e)
		{
			System.out.println ("error with file, please double check file name");
		}
	}
	
	/**
	 * @param order
	 * @return void
	 * process orders stored in a groceryOrder object, adjust grocery 
	 * inventory to reflect orders being fulfilled
	 */
	public void processOrder(GroceryOrder <GroceryItem> order) throws GroceryException
	{
		//for each item in the order, find the item in inventory
		//if quantity == 0 or is not found, throw error
		for (GroceryItem orderItem: order)
		{
			try
			{
				//find the item, determine if order quantity is larger than 0, 
				//if inventory is out of stock or item is not in inventory, 
				//else complete appropriate computation 
				GroceryItem inventoryItem = findItemByName (orderItem.getName());
				if (orderItem.getQuantity() <= 0)
				{
					continue;
				}
				else if (inventoryItem.getQuantity() == 0 || inventoryItem.equals(null))
				{
					throw new GroceryException (inventoryItem.getName() + " is not in stock!");
				}
				else
				{
					//result of fulfilling order, if statement covers different cases
					//of having more than enough in inventory, having exactly enough
					//in inventory, and not having enough at all
					int leftOverInventory = inventoryItem.getQuantity() - orderItem.getQuantity();
					if (leftOverInventory < 0)
					{
						orderItem.setQuantity(inventoryItem.getQuantity());
						inventoryItem.setQuantity(0);
						restockingList.add(inventoryItem.getName());
						throw new GroceryException (inventoryItem.getName() + " is not in stock!");
					}
					else if (leftOverInventory == 0)
					{
						orderItem.setQuantity(0);
						inventoryItem.setQuantity(0);
						restockingList.add(inventoryItem.getName());
					}
					else
					{
						orderItem.setQuantity(0);
						inventoryItem.setQuantity(leftOverInventory);
					}
				}
			}
			catch (GroceryException e)
			{
				System.out.println (e.getMessage());
			}
		}
	}
	
	/**
	 * @param name
	 * @return void
	 * searches the inventory for the item by name, 
	 * returns the item if found otherwise returns null
	 */
	public GroceryItem findItemByName (String name)
	{
		//stepping through every item in inventory until found
		for (GroceryItem item: inventory)
		{
			String itemName = item.getName();
			if (name.equals(itemName))
			{
				return item;
			}
		}
		
		//not found, return null
		return null;
	}
	
	/**
	 * @return void
	 * displays what items need to be restocked
	 */
	public void displayRestockingList()
	{
		for (String itemName: restockingList)
		{
			System.out.println (itemName);
		}
	}
	
	/**
	 * @return void
	 * displays all items in the inventory in nice columns
	 */
	public void displayInventory()
	{
		for (GroceryItem item: inventory)
		{
			System.out.printf ( "%-25s %-25s %-25s %-23s %n", "name: " + item.getName(), 
					"price: $" + df.format(item.getPrice()), "quantity: " + 
			         item.getQuantity(), item.toString());
		}
	}
	
	/**
	 * @return void
	 * sort the inventory alphabetically using 
	 * bubble sort technique- compares adjacent pairs and swaps
	 * if out of order, continues this before repeated until whole
	 * list is sorted corectly
	 */
	public void sortInventoryByName()
	{
		//nested for loops to reatedly compare pairs
		int size = inventory.size();
		for (int i = 0; i < (size - 1); i++)
		{
			for (int j = 0; j < (size - i - 1); j++)
			{
				//if the pair is out of order, swap them
				if (inventory.get(j).compareTo(inventory.get(j + 1)) > 0)
				{
					Collections.swap(inventory, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * @return void
	 * sort the inventory by price using 
	 * insertion sort technique- one at a time items find their
	 * correct location building up the sorted partition of the
	 * list, repeated until sorted partition is the whole list
	 */
	public void sortInventoryByPrice()
	{
		//for every element in the list
		int size = inventory.size();
		for (int i = 1; i < size; i++)
		{
			GroceryItem key = inventory.get(i);
			int j = (i - 1);
			
			//while the element it out of order, keep moving
			//it over until correclt poition is found
			while ((j >= 0) && (inventory.get(j).getPrice() > key.getPrice()))
			{
				GroceryItem replace = inventory.get(j);
				inventory.set(j + 1, replace);
				j = j - 1;
			}
			inventory.set(j + 1, key);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
