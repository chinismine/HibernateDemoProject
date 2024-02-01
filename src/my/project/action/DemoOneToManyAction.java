package my.project.action;

import java.util.HashSet;
import java.util.LinkedHashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import my.project.model.Stock;
import my.project.model.StockTransaction;
import my.project.util.HibernateUtil;

public class DemoOneToManyAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Stock stock1=new Stock("TSMC", "2330");
			StockTransaction trans1=new StockTransaction(12000);
			StockTransaction trans2=new StockTransaction(14000);
			StockTransaction trans3=new StockTransaction(8000);
			
			trans1.setStock(stock1);
			trans2.setStock(stock1);
			trans3.setStock(stock1);
//			
			 LinkedHashSet<StockTransaction> sets = new LinkedHashSet<StockTransaction>();
			 //按順序儲存
			 
			 sets.add(trans1);
			 sets.add(trans2);
			 sets.add(trans3);
			 
			 stock1.setStockTransactions(sets);
			 
			 session.persist(stock1);
			 
			
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();;
			e.printStackTrace();
			// TODO: handle exception
		}
		
		HibernateUtil.closeSessionFactory();
	}

}
