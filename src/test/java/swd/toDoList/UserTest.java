package swd.toDoList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import swd.toDoList.bean.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {
	 
	
	  @Test
	  public void testGetUsername() {
		  BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
		  User user = new User("admin2", bKrypta.encode("admin123"), "b@yahoo.fi", "ADMIN");
		  assertThat(user.getUsername()).isEqualTo("admin2");
	  }
	  @Test
	  public void testSetUsername() {
		  BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
		  User user = new User("admin2", bKrypta.encode("admin123"), "b@yahoo.fi", "ADMIN");
		  user.setUsername("admin3");
		  assertThat(user.getUsername()).isEqualTo("admin3");
	  }
	  @Test
	  public void testGetEmail() {
		  BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
		  User user = new User("admin2", bKrypta.encode("admin123"), "b@yahoo.fi", "ADMIN");
		  assertThat(user.getEmail()).isEqualTo("b@yahoo.fi");
	  }
	  @Test
	  public void testSetEmail() {
		  BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
		  User user = new User("admin2", bKrypta.encode("admin123"), "b@yahoo.fi", "ADMIN");
		  user.setEmail("c@yahoo.fi");
		  assertThat(user.getEmail()).isEqualTo("c@yahoo.fi");
	  }
	  @Test
	  public void testGetRole() {
		  BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
		  User user = new User("admin2", bKrypta.encode("admin123"), "b@yahoo.fi", "ADMIN");
		  assertThat(user.getRole()).isEqualTo("ADMIN");
	  }
	  @Test
	  public void testSetRole() {
		  BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
		  User user = new User("admin2", bKrypta.encode("admin123"), "b@yahoo.fi", "ADMIN");
		  user.setRole("USER");
		  assertThat(user.getRole()).isEqualTo("USER");
	  }
}