package my.project.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.project.model.Department;
import my.project.util.HibernateUtil;

public class DemoDepartmentAction3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Department dp=new Department();
			dp.setDepid(20);
			dp.setDeptname("Finance2");
			session.persist(dp);
			
			session.getTransaction().commit();
			System.out.println("Transaction commit.");
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction rollback.");
			e.printStackTrace();
		}
		
		HibernateUtil.closeSessionFactory();

	}

}
