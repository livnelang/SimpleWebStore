package il.ac.shenkar.samples.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import antlr.collections.List;

public class ShoppingCart {
	private Map<String,ShoppingCartLine> lines;

	/**
	 * ShoppingCart Constructor
	 * @param lines
	 */
	public ShoppingCart() 
	{
		super();
		this.lines = new HashMap<String, ShoppingCartLine>();
	}
	
	/**
	 * Add Another purchase line
	 * @param s
	 */
	public void addShoppingCartLine(ShoppingCartLine s)
	{
		lines.put(s.getProductName(), s);
	}
	
	/**
	 * Total Purchased lines
	 * @return
	 */
	public double getTotal()
	{
		double totalprice = 0;
		ShoppingCartLine l;

		
		for (Entry<String, ShoppingCartLine> entry : lines.entrySet())
		{
			l = entry.getValue();
			totalprice+=l.lineTotalPrice();
		}
		return totalprice;
	}
	
	public Map<String,ShoppingCartLine> getLines()
	{
		return this.lines;
	}
	

}
