package groceryStoreManager;

public class GroceryException extends Exception
{
	//serialization number
	private static final long serialVersionUID = -5273749533835653865L;

	public GroceryException()
	{
		super();
	}
	
	public GroceryException(String msg)
	{
		super(msg);
	}
}
