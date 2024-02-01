package my.project.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.project.model.Book;
import my.project.model.BookDetail;
import my.project.util.HibernateUtil;

public class DemoOneToOneAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
//			Book book=new Book("Harry Potter", "J.K Rowling", 510);
//			BookDetail bookDetail=new BookDetail("BloomBerry", "UK");
//			book.setBookDetail(bookDetail);
//			bookDetail.setBook(book);
//			
//			session.persist(book);
			
			Book bookbean = session.get(Book.class, 1000);
			if(bookbean!=null) {
				System.out.println(bookbean.getId()+"\t"+bookbean.getBookname()+"\t"+bookbean.getAuthor()+"\t"+bookbean.getPrice());
				BookDetail bd=bookbean.getBookDetail();
				System.out.println(bd.getPublisher()+"\t"+bd.getPublisheraddress());
			}else {
				System.out.println("no result");
			}
			
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();;
			// TODO: handle exception
		}
		
		
		
		HibernateUtil.closeSessionFactory();

	}

}
