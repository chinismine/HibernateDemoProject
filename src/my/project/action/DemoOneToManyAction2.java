package my.project.action;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import my.project.model.Stock;
import my.project.model.StockTransaction;
import my.project.util.HibernateUtil;

public class DemoOneToManyAction2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Stock stockBean=session.get(Stock.class, 1);
			if(stockBean!=null) {
				System.out.println(stockBean.getStockid()+"\t"+stockBean.getStockname()+"\t"+stockBean.getStockcode());
				Set<StockTransaction> stockTrans = stockBean.getStockTransactions();
				for(StockTransaction strans:stockTrans) {
					System.out.println(strans.getTradevolume()+"\t"+strans.getStockid());
					
				}
			}
			 
			
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();;
			e.printStackTrace();
			// TODO: handle exception
		}
		
		HibernateUtil.closeSessionFactory();
	}

}
