package il.ac.shenkar.samples.model;

public class ShoppingCartLine {
	private Product c1;
	private int amount=0;
	
	/**
	 * ShoppingCartLine Constructor
	 * @param c1
	 * @param amount
	 */
	public ShoppingCartLine(Product c1, int amount) {
		super();
		this.c1 = c1;
		this.amount = amount;
	}
	
	public String getProductName()
	{
		return c1.getName();
	}
	
	public double lineTotalPrice()
	{
		return amount*(c1.getPrice());
	}
	
	public int getAmount()
	{
		return this.amount;
	}
	
	
	

}
