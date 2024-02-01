package my.project.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import my.project.model.HouseBean;
import my.project.util.HibernateUtil;

public class DemoHQLAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			String hql="from HouseBean where houseid=:hid AND housename=:hname";
			Query<HouseBean> query = session.createQuery(hql,HouseBean.class);
			query.setParameter("hid", 1001);
			query.setParameter("hname", "Great House");
			
			HouseBean rBean = query.uniqueResult();
			if(rBean!=null) {
				System.out.println(rBean.getHouseid()+"\t"+rBean.getHousename());
			}else {
				System.out.println("no result");
			}
		
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
