package my.project.action;

import java.util.LinkedHashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.project.model.Game;
import my.project.model.Role;
import my.project.model.Stock;
import my.project.model.StockTransaction;
import my.project.util.HibernateUtil;

public class DemoManyToManyAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Game game1=new Game("Apex");
			Game game2=new Game("WW2");
			Role role1=new Role("warrior","sword");
			Role role2=new Role("sniper","shoot");
			Role role3=new Role("zombie","bite");
			
			LinkedHashSet<Role> roles=new LinkedHashSet<Role>();
			roles.add(role1);
			roles.add(role2);
			roles.add(role3);
			
			game1.setRoles(roles);
			game2.setRoles(roles);
			
			session.persist(game2);
			
			 
			
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();;
			e.printStackTrace();
			// TODO: handle exception
		}
		
		HibernateUtil.closeSessionFactory();

	}

}
