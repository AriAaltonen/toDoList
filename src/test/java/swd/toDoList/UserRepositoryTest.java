package swd.toDoList;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import swd.toDoList.bean.User;
import swd.toDoList.dao.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	  @Test
	    public void findByUsernameShouldReturnUser() {
		
			
		 BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
		 User user = new User("admin2", bKrypta.encode("admin123"), "b@yahoo.fi",
					"ADMIN");
		  	repository.save(user);
	        User users = repository.findByUsername("admin2");
	        assertThat(users.getUsername()).isEqualTo("admin2");
	    }
	    
	    @Test
	    public void createUser() {
	    	BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
	    	User user = new User("admin3", bKrypta.encode("admin123"), "c@yahoo.fi",
					"ADMIN");
	    	repository.save(user);
	    	assertThat(user.getId()).isNotNull();
	    }    
	    
	    @Test
	    public void editUser() {
	    	User user = repository.findByUsername("admin3");
	    	BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
	    	user = new User("admin4", bKrypta.encode("admin123"), "d@yahoo.fi",
					"ADMIN");
	    	repository.save(user);
	    	assertThat(repository.findByUsername("admin4")).isNotNull();
	    }
	    
	    @Test
	    public void deleteUser() {
	    	BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
	    	User user = new User("admin5", bKrypta.encode("admin123"), "e@yahoo.fi",
					"ADMIN");
	    	repository.save(user);
	    	repository.delete(user);
	    	assertThat(repository.findByUsername("admin5")).isNull();
	    }
}
