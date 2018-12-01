package swd.toDoList.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import swd.toDoList.bean.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Listitem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long statusId;
	private String toDoListitem;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id")
	private Status status;
	
	public Listitem () {
		
	}
	
	public Listitem (long statusId, String toDoListitem, Status status) {
		this.statusId = statusId;
		this.toDoListitem = toDoListitem;
		this.status = status;
	}
	
	public long getId() {
		return statusId;
	}

	public void setId(long statusId) {
		this.statusId = statusId;
	}

	public String getToDoListitem() {
		return toDoListitem;
	}

	public void setToDoListitem(String toDoListitem) {
		this.toDoListitem = toDoListitem;
	}
	
	public Status getStatus () {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Listitem [statusId=" + statusId + ", toDoListitem=" + toDoListitem + ", status=" + status + "]";
	}
}