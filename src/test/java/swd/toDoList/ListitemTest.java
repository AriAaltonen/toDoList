package swd.toDoList;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd.toDoList.bean.Listitem;
import swd.toDoList.bean.Status;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ListitemTest {

	  @Test
	  public void testGetId() {
		  Listitem listitem = new Listitem(6, "Abc", new Status(2, "Done"));
		  assertThat(listitem.getId()).isEqualTo(6);
	  }
	  
	  @Test
	  public void testSetId() {
		  Listitem listitem = new Listitem(6, "Abc", new Status(2, "Done"));
		  listitem.setId(7);
		  assertThat(listitem.getId()).isEqualTo(7);
	  }
	  
	  @Test
	  public void testGetToDoListitem() {
		  Listitem listitem = new Listitem(6, "Abc", new Status(2, "Done"));
		  assertThat(listitem.getToDoListitem()).isEqualTo("Abc");
	  }
	  
	  @Test
	  public void testSetToDoListitem() {
		  Listitem listitem = new Listitem(6, "Abc", new Status(2, "Done"));
		  listitem.setToDoListitem("Bcd");
		  assertThat(listitem.getToDoListitem()).isEqualTo("Bcd");
	  }
}