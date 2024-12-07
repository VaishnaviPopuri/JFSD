package HQLOperatations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department 
{
	  @Id
	  private int did;
	  @Column(name="dname",length=50,nullable=false)
	  private String dname;
	  @Column(name="dlocation",nullable = false)
	  private String dlocation;
	  @Column(name="HODName",nullable = false)
	  private String HODName;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDlocation() {
		return dlocation;
	}
	public void setDlocation(String dlocation) {
		this.dlocation = dlocation;
	}
	public String getHODName() {
		return HODName;
	}
	public void setHODName(String hODName) {
		HODName = hODName;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", dlocation=" + dlocation + ", HODName=" + HODName
				+ "]";
	}
	  
	
}
