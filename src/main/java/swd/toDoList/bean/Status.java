package swd.toDoList.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Status {
	@Id
	private long id;
	private String statusName;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "statusName")
	private List<Status> statuses;
	
	public Status () {
		
	}
	
	public Status (long id, String statusName) {
		this.id = id;
		this.statusName = statusName;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public List<Status> getStatuses(){
		return statuses;
	}
	
	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}
	
}
