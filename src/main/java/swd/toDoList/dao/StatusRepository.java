package swd.toDoList.dao;

import java.util.List;
import swd.toDoList.bean.Status;
import org.springframework.data.repository.CrudRepository;



public interface StatusRepository extends CrudRepository<Status, Long> {
	List<Status> findAll();
	Status findByStatusId(long statusId);
	List<Status> findByStatusName(String statusName);
}