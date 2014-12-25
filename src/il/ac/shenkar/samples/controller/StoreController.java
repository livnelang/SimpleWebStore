package il.ac.shenkar.samples.controller;


import il.ac.shenkar.samples.model.MySQLProductsDAO;
import il.ac.shenkar.samples.model.Product;
import il.ac.shenkar.samples.model.ProductException;
import il.ac.shenkar.samples.model.MySQLProductsDAO;
import il.ac.shenkar.samples.model.ShoppingCart;
import il.ac.shenkar.samples.model.ShoppingCartLine;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.Map;

/**
 * Servlet implementation class StoreController
 */
@WebServlet("/StoreController/*")
public class StoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingCart cart;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreController() {
        super();
        cart =new ShoppingCart();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		RequestDispatcher dispatcher = null;
		
		if(path.endsWith("store"))
		{
			
			try {
				request.setAttribute("products", MySQLProductsDAO.getInstance().getProducts());
				dispatcher = getServletContext().getRequestDispatcher("/store.jsp");
				dispatcher.forward(request, response);
			}
			/*catch(InventoryException e) {
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(request,response);
			}*/ catch (ProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		if(path.endsWith("shoppingcart"))
		{
			
			String amount  = request.getParameter("quantity"); 
			String id  = request.getParameter("c_id");
			request.setAttribute("id", id);
			request.setAttribute("amount", amount);
			dispatcher = getServletContext().getRequestDispatcher("/shoppingcart.jsp");
			
			try {
				Product p = MySQLProductsDAO.getInstance().getProduct(Integer.parseInt(id));
				ShoppingCartLine s1 = new ShoppingCartLine(p, Integer.parseInt(amount));
				this.cart.addShoppingCartLine(s1);
				request.setAttribute("total_amount", cart.getTotal());
				request.setAttribute("lines", cart.getLines());
				dispatcher.forward(request, response);
				}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
