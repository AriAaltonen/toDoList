package swd.toDoList;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd.toDoList.bean.Status;
import swd.toDoList.dao.StatusRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StatusRepositoryTest {
	@Autowired
	private StatusRepository repository;
	
	  @Test
	    public void findByStatusIdShouldReturnStatus() {
		  Status status = new Status((long) 3, "A");
		  	repository.save(status);
	        Status status2 = (Status) repository.findByStatusId(3);
	        assertThat(status2.getStatusName()).isEqualTo("A");
	    }
	    
	    @Test
	    public void createNewStatus() {
	    	Status status = new Status((long) 4, "B");
	    	repository.save(status);
	    	assertThat(status.getStatusId()).isNotNull();
	    }    
	    
	    @Test
	    public void editStatus() {
	    	Status status = new Status((long)5 ,"C");
	    	repository.save(status);
	    	Status status2 = repository.findByStatusId(5);
	    	status2 = new Status((long) 5, "D");
	    	repository.save(status2);
	    	assertThat(repository.findByStatusId(5).getStatusName()).isEqualTo("D");
	    }
	    
	    @Test
	    public void deleteStatus() {
	    	Status status = new Status((long) 6, "E");
	    	repository.save(status);
	    	repository.delete(status);
	    	assertThat(repository.findByStatusName("E")).isEmpty();
	    }
}