package swd.toDoList.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Status {
	@Id
	private long statusId;
	private String statusName;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "status")
	private List<Listitem> listitems;
	
	public Status () {
		
	}
	
	public Status (long statusId, String statusName) {
		this.statusId = statusId;
		this.statusName = statusName;
	}
	
	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public List<Listitem> getListitems(){
		return listitems;
	}
	
	public void setStatuses(List<Listitem>listitems) {
		this.listitems = listitems;
	}
	
}
