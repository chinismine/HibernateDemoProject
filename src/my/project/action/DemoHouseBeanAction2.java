package my.project.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.project.model.HouseBean;
import my.project.model.HouseBeanDao;
import my.project.util.HibernateUtil;

public class DemoHouseBeanAction2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
		session.beginTransaction();
		
		HouseBeanDao hDao=new HouseBeanDao(session);
//		hDao.selectById(1005);
//		hDao.selectById2(1005);
		System.out.println("------------------------------------");
//		List<HouseBean> lists = hDao.selectAll();
//		for(HouseBean rbean:lists) {
//			System.out.println(rbean.getHouseid()+" \t "+rbean.getHousename());
//		}	
		
//		HouseBean delBean=new HouseBean();
//		delBean.setHouseid(1001);
//		delBean.setHousename("D HOUSE");
//		session.remove(delBean);
		
//		HouseBean updBean=new HouseBean();
//		updBean.setHouseid(1003);
//		updBean.setHousename("Green House");
//		session.update(updBean);
		
		HouseBean updBean2 = session.get(HouseBean.class, 1003);
		//連線狀態取得bean，確認值不同後，重新set值也會執行update
		if(updBean2!=null) {
			updBean2.setHousename("Fashion House");
		}else {
			System.out.println("no data to update");
		}
		
		

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
