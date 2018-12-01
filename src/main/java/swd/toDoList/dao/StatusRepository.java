package swd.toDoList.dao;

import java.util.List;
import swd.toDoList.bean.Status;
import org.springframework.data.repository.CrudRepository;



public interface StatusRepository extends CrudRepository<Status, Long> {
	List<Status> findAll();
	List<Status> findByName(String statusName);
}