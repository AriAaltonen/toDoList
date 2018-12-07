package swd.toDoList.dao;

import swd.toDoList.bean.Listitem;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ListitemRepository extends CrudRepository<Listitem, Long>{
	List<Listitem> findAll();
	Listitem findByToDoListitem(String toDoListitem);
}