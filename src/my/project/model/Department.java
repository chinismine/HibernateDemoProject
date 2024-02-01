package my.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name="department")
public class Department {
	
	@Id @Column(name="DEPID") //大小寫不區分
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depid;
	
	@Column(name="DEPTNAME")
	private String deptname;
	
	
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	

}
