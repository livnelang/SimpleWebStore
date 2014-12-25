package il.ac.shenkar.samples.model;

import il.ac.shenkar.samples.model.MySQLProductsDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//import javax.persistence.Query;







import java.util.Map;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 * Created by Livne Lang
 */
public class MySQLProductsDAO //implements ICouponsDAO
{

	
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private static MySQLProductsDAO instance;
    private Map<Integer,Product> products = new HashMap<Integer,Product>();
    
    /**
     * Singleton Implementation
     * @return instance
     */
    public static MySQLProductsDAO getInstance()
    {
        if(instance==null)
        {
            instance = new MySQLProductsDAO();
        }
        return instance;
    }

    private MySQLProductsDAO() {

    }

    /**
     * Hibernate getCoupons
     */
    public Collection<Product> getProducts() throws ProductException 
    {
    			ArrayList<Product> coupon_array = new ArrayList<Product>();
    			//creating factory for getting sessions
    			SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
   
    			//creating a new session for getting all products
    			Session anotherSession = factory.openSession();
    			anotherSession.beginTransaction();
    			List products = anotherSession.createQuery("from Product").list();
    			System.out.println("There are " + products.size() + " product(s)");
    			Iterator i = products.iterator();
    			while(i.hasNext()) 
    			{
    				//System.out.println(i.next());
    				coupon_array.add((Product) i.next());
    			}
    			anotherSession.close();	
    			
    			if(this.products.isEmpty()) 
    			{
    				for(Product p : coupon_array)
    				{
    	    			this.products.put(p.getId(), p);
    				}		
    			}
    			return coupon_array;
    }
    
    /**
     * returns the specific product from our inventory
     * @param id
     * @return Product if exists 
     */
    public Product getProduct(int id)
    {
    	return products.get(id);
    }
    
    
    /**
     * Hibernate addCoupon(Coupon ob)
     */
    
//    public boolean addCoupon(Coupon ob) throws CouponException
//    {
//    		//creating factory for getting sessions
//    		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
//    		//creating a new session for getting all products
//    		Session anotherSession = factory.openSession();
//    		anotherSession.beginTransaction();
//        try
//        {
//        	anotherSession.save(ob);
//        	anotherSession.getTransaction().commit();
//        	anotherSession.close();
//            
//        }
//        catch(HibernateException e)
//        {
//        	
//            e.printStackTrace();
//           // throw new CouponException("problem with adding a coupon");
//            return false;
//        }
//       
//        return true;
//    }
//    
    /**
     * Hibernate getCoupon(int id)
     */
//    public Coupon getCoupon(int id) throws CouponException
//    {
//    	Coupon c1=null;
//    	//creating factory for getting sessions
//		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
//		//creating a new session for getting all products
//		Session anotherSession = factory.openSession();
//		anotherSession.beginTransaction();
//        
//        try
//        {
//        	c1 = (Coupon) anotherSession.get(Coupon.class, id);
//        	    
//        }
//
//        catch(HibernateException e)
//        {
//            e.printStackTrace();
//            throw new CouponException("problem with getting a coupon"); 
//        }
//        
//        return c1;
//
//
//    }
    
    
    /**
     * Hibernate deleteCoupon(int id)
     */
//	public boolean deleteCoupon(int id) throws CouponException
//    {
//
//		int succeed = 0;
//		
//		//creating factory for getting sessions
//		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
//		//creating a new session for getting all products
//		Session anotherSession = factory.openSession();
//		anotherSession.beginTransaction();
//		Coupon c2 = null;
//		
//			try
//			{
//				//Retrieve detailed Coupon
//				c2 = (Coupon) anotherSession.get(Coupon.class, id);
//				//Add delete to session
//				anotherSession.delete(c2);
//				// Commit The Session
//				anotherSession.getTransaction().commit();
//				
//			}
//			catch (HibernateException e)
//			{
//				e.printStackTrace();
//				System.out.println(e.getMessage());
//				
//				Transaction tx = (Transaction) anotherSession.getTransaction();
//				if (((org.hibernate.Transaction) tx).isActive())
//					try {
//						tx.rollback();
//					} catch (IllegalStateException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					} catch (SystemException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//			}
//			finally
//			{
//				if (c2 == null)
//				{
//					return false;
//				}
//				if(anotherSession!=null) anotherSession.close();
//			}
//
//		// Check whether item deleted or not
//		if(succeed==1)
//		{
//			return true;
//		}
//		
//		else
//		{ 
//			return false;
//		}
//
//    }
//    
    
	/**
     * Hibernate updateCoupon(Coupon coupon)
     */
//    public boolean updateCoupon(Coupon coupon) throws CouponException
//    {
//    	//creating factory for getting sessions
//    	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
//    	//creating a new session for getting all products
//    	Session anotherSession = factory.openSession();
//    	anotherSession.beginTransaction();
//    	    
//        try
//        {
//        	anotherSession.update(coupon);
//        	anotherSession.getTransaction().commit();
//               
//        }
//    	
//        catch(Exception e)
//        {
//        	
//            e.printStackTrace();
//            return false;
//        }
//        
//        return true;
//
//    }
 
}
