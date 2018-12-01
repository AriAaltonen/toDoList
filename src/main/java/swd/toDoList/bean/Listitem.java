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
	private long id;
	private String toDoListitem;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "statusId")
	private Status status;
	
	public Listitem () {
		
	}
	
	public Listitem (long id, String toDoListitem, Status status) {
		this.id = id;
		this.toDoListitem = toDoListitem;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "Listitem [statusId=" + id + ", toDoListitem=" + toDoListitem + ", status=" + status + "]";
	}
}