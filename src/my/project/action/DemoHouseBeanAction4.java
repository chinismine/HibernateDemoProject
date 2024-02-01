package my.project.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.project.model.HouseBean;
import my.project.model.HouseBeanService;
import my.project.util.HibernateUtil;

public class DemoHouseBeanAction4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			HouseBeanService hService=new HouseBeanService(session);
			List<HouseBean> lists = hService.selectAll();
			
			Iterator<HouseBean> il=lists.iterator();
			while(il.hasNext()) {
				HouseBean rsBean=il.next();
				System.out.println(rsBean.getHouseid()+"\t"+rsBean.getHousename());
			}
			
		
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
			// TODO: handle exception
		}finally {
			session.close();
		}
		
	}

}
