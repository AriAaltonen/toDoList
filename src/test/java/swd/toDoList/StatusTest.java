package swd.toDoList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd.toDoList.bean.Status;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StatusTest {
	
	  @Test
	  public void testGetStatusId() {
		  Status status = new Status((long) 4, "B");
		  assertThat(status.getStatusId()).isEqualTo(4);
	  }
	  
	  @Test
	  public void testSetStatusId() {
		  Status status = new Status((long) 4, "B");
		  status.setStatusId(5);
		  assertThat(status.getStatusId()).isEqualTo(5);
	  }
	  
	  @Test
	  public void testGetStatusName() {
		  Status status = new Status((long) 4, "B");
		  assertThat(status.getStatusName()).isEqualTo("B");
	  }
	  
	  @Test
	  public void testSetStatusName() {
		  Status status = new Status((long) 4, "B");
		  status.setStatusName("C");
		  assertThat(status.getStatusName()).isEqualTo("C");
	  }
}
