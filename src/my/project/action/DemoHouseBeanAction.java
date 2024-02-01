package my.project.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;

import my.project.model.HouseBean;

public class DemoHouseBeanAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		
		HouseBean hbean=new HouseBean();
		hbean.setHousename("Fashion House");
		session.persist(hbean);
//		session.save(hbean);
		
		ts.commit();
		session.close();
		factory.close();
		
	}

}
