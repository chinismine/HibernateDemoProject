package my.project.model;

import java.util.List;

import org.hibernate.Session;

public class HouseBeanService implements IHouseBeanDAO {
	
	private HouseBeanDao hDao;
	public HouseBeanService() {
		
	}
	public HouseBeanService(Session session) {
		hDao=new HouseBeanDao(session);
	}

	@Override
	public void selectById(int id) {
		hDao.selectById(id);
	}

	@Override
	public void selectById2(int id) {
		hDao.selectById2(id);
	}

	@Override
	public List<HouseBean> selectAll() {
		return hDao.selectAll();
	}

	@Override
	public HouseBean insert(HouseBean bean) {
		return hDao.insert(bean);
	}

	@Override
	public HouseBean insert2(HouseBean bean) {
		return hDao.insert2(bean);
	}

	@Override
	public HouseBean update(int houseid, String housename) {
		return hDao.update(houseid, housename);
	}

	@Override
	public boolean deleteById(int id) {
		return hDao.deleteById(id);
	}

}
