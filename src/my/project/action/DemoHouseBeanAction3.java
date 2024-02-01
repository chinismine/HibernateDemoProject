package my.project.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.project.model.HouseBean;
import my.project.model.HouseBeanDao;
import my.project.util.HibernateUtil;

public class DemoHouseBeanAction3 {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
		session.beginTransaction();
		
		HouseBeanDao hDao=new HouseBeanDao(session);
		HouseBean saveBean=new HouseBean();
		saveBean.setHousename("Beautiful House");
		
//		hDao.insert(saveBean);
//		
//		HouseBean resultBean=hDao.insert2(saveBean);
//		if(resultBean!=null) {
//			System.out.println(resultBean.getHouseid()+"\t"+resultBean.getHousename());
//		}
		
//		HouseBean updBean=hDao.update(1005, "Green Bean");
//		
//		if(updBean!=null) {
//			System.out.println(updBean.getHouseid()+"\t"+updBean.getHousename());
//		}else {
//			System.out.println("update failed");
//		}
		
		boolean delBean=hDao.deleteById(1005);
		System.out.println(delBean);
		session.getTransaction().commit();
		System.out.println("Session Commit.");
		
		}catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			System.out.println("Session Rollback.");
		}finally {
			System.out.println("Session Closed.");
		}
		
		HibernateUtil.closeSessionFactory();
	}
}
