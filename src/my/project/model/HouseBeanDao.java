package my.project.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HouseBeanDao implements IHouseBeanDAO{
	private Session session;
	
	public HouseBeanDao(){
		
	}
	public HouseBeanDao(Session session){
		this.session=session;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void selectById(int id) {
		try {
			HouseBean resultBean=session.load(HouseBean.class, id);
			System.out.println(resultBean.getHouseid()+" \t "+resultBean.getHousename());
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("no result...");
		}
			
		
	}
	
	@Override
	public void selectById2(int id) {
		
			HouseBean resultBean=session.get(HouseBean.class, id);
			if(resultBean!=null) {
				System.out.println(resultBean.getHouseid()+" \t "+resultBean.getHousename());
			}else {
				System.out.println("no result...");
			}

	}
	
	@Override
	public List<HouseBean> selectAll() {
		Query<HouseBean> query = session.createQuery("from HouseBean",HouseBean.class);
		List<HouseBean> lists = query.list();
		return lists;
	}
	@Override
	public HouseBean insert(HouseBean bean) {
		HouseBean resultb = session.get(HouseBean.class, bean.getHouseid());
		if(resultb==null) {//代表目前還沒有，執行新增
			session.persist(bean);
			return bean;
		}
		
		return null;
	}
	@Override
	public HouseBean insert2(HouseBean bean) {
		// TODO Auto-generated method stub
		if(bean!=null) {
			session.persist(bean);
		}
		return null;
	}
	@Override
	public HouseBean update(int id, String houseName) {
		// TODO Auto-generated method stub
		HouseBean result = session.get(HouseBean.class, id);
		if(result!=null) {
			result.setHousename(houseName);
		}
		return result;
	}
	@Override
	public boolean deleteById(int id) {
		HouseBean result = session.get(HouseBean.class, id);
		if(result!=null) {
			session.remove(result);
			return true;
		}
		return false;
	}
	
}
