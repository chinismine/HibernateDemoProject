package my.project.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.project.model.Department;
import my.project.util.HibernateUtil;

public class DemoDepartmentAction2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			
			Department dp=new Department();
			dp.setDeptname("HR");
			session.persist(dp);
			
			session.getTransaction().commit();
			System.out.println("Transaction commit.");
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction rollback.");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		HibernateUtil.closeSessionFactory();

	}

}
