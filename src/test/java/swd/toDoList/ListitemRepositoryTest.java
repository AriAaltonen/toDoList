package swd.toDoList;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import swd.toDoList.bean.Status;
import swd.toDoList.bean.Listitem;
import swd.toDoList.dao.ListitemRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ListitemRepositoryTest {
		@Autowired
		private ListitemRepository repository;
		
		  @Test
		    public void findByIdShouldReturnListitem() {
			  Listitem listitem = new Listitem(12, "A", new Status(2,"Done"));
			  	repository.save(listitem);
		        List<Listitem> listitems = repository.findAll();
		        assertThat(listitems).hasSize(1);
		        assertThat(listitems.get(0).getToDoListitem()).isEqualTo("A");
		    }
		    
		    @Test
		    public void createNewListitem() {
		    	Listitem listitem = new Listitem(13, "B", new Status(1,"In-progress"));
		    	repository.save(listitem);
		    	assertThat(listitem.getId()).isNotNull();
		    }   
		    
		    @Test
		    public void editListitem() {
		    	Listitem listitem = repository.findByToDoListitem("B");
		    	listitem = new Listitem(13, "Bc", new Status(1,"In-progress"));
		    	repository.save(listitem);
		    	Listitem listitem2 = (Listitem) repository.findByToDoListitem("Bc");
		    	assertThat(listitem2.getToDoListitem().isEmpty()).isNotEqualTo(true);
		    }
		    
		    @Test
		    public void deleteListitem() {
		    	Listitem listitem = new Listitem(13, "B", new Status(1,"In-progress"));
		    	repository.save(listitem);
		    	repository.delete(listitem);
		    	assertThat(repository.findById((long) 13)).isEmpty();
		    }
}