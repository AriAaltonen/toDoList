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
	public CommandLineRunner listitemDemo(ListitemRepository listitemRepo, UserRepository userRepo, StatusRepository statusRepo) {
		return (args) -> {
			log.info("Add statuses");
			statusRepo.save(new Status((long) 0, "To-do"));
			statusRepo.save(new Status((long) 1, "In-progress"));
			statusRepo.save(new Status((long) 2, "Done"));
			

			BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
			User user1 = new User("admin", bKrypta.encode("admin123"), "a@yahoo.fi",
				"ADMIN");
			userRepo.save(user1);

			listitemRepo.save(new Listitem(0, "Return the database", statusRepo.findByStatusName("To-do").get(0)));
			listitemRepo.save(new Listitem(1, "Add data to tables in the database", statusRepo.findByStatusName("In-progress").get(0)));
			listitemRepo.save(new Listitem(2, "Create a database", statusRepo.findByStatusName("Done").get(0)));

			log.info("Fetch listitems");
			for (Listitem listitem : listitemRepo.findAll()) {
				log.info((listitem.toString()));
			}
		};
	}
}
