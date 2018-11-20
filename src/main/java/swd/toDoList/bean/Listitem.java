package swd.toDoList.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Listitem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String toDoListitem;
	
	public Listitem () {
		
	}
	
	public Listitem (long id, String toDoListitem) {
		this.id = id;
		this.toDoListitem = toDoListitem;
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

	@Override
	public String toString() {
			return "Listitem [id=" + id + ", toDoListitem=" + toDoListitem + "]";
	}
}