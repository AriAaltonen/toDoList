package swd.toDoList;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import swd.toDoList.bean.Listitem;
import swd.toDoList.bean.User;
import swd.toDoList.dao.ListitemRepository;
import swd.toDoList.dao.UserRepository;

@SpringBootApplication
public class ToDoListApplication {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(ToDoListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner listitemDemo(ListitemRepository repository, UserRepository userRepo) {
		return (args) -> {

			BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
			User user1 = new User("user", bKrypta.encode("password"), "b@google.ru",
					"USER");
			User user2 = new User("admin", bKrypta.encode("admin123"), "a@yahoo.fi",
					"ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);

			repository.save(
					new Listitem(1, "ABCD-1234-BCDA"));

			log.info("Fetch listitems");
			for (Listitem listitem : repository.findAll()) {
				log.info((listitem.toString()));
			}
		};
	}
}
