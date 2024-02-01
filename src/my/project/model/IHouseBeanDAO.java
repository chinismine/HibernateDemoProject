package my.project.model;

import java.util.List;

public interface IHouseBeanDAO {
	public void selectById(int id);
	public void selectById2(int id);
	public List<HouseBean> selectAll();
	public HouseBean insert(HouseBean bean);
	public HouseBean insert2(HouseBean bean);
	public HouseBean update(int houseid,String housename);
	public boolean deleteById(int id);
	
}
