package swd.toDoList;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import swd.toDoList.bean.Status;
import swd.toDoList.bean.Listitem;
import swd.toDoList.bean.User;
import swd.toDoList.dao.ListitemRepository;
import swd.toDoList.dao.UserRepository;
import swd.toDoList.dao.StatusRepository;

@SpringBootApplication
public class ToDoListApplication {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(ToDoListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner listitemDemo(ListitemRepository repository, UserRepository userRepo, StatusRepository statusRepo) {
		return (args) -> {
			log.info("Add statuses");
			statusRepo.save(new Status((long) 0, "To-do"));
			statusRepo.save(new Status((long) 1, "In-progress"));
			statusRepo.save(new Status((long) 2, "Done"));
			

			BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
			User user1 = new User("admin", bKrypta.encode("admin123"), "a@yahoo.fi",
				"ADMIN");
			userRepo.save(user1);

			repository.save(
					new Listitem(0, "Return the database", statusRepo.findByName("To-do").get(0)));
					new Listitem(1, "Add data to tables in the database", statusRepo.findByName("In-progress").get(1));
					new Listitem(2, "Create a database", statusRepo.findByName("Done").get(2));

			log.info("Fetch listitems");
			for (Listitem listitem : repository.findAll()) {
				log.info((listitem.toString()));
			}
		};
	}
}
