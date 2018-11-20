package swd.toDoList.dao;

import org.springframework.data.repository.CrudRepository;

import swd.toDoList.bean.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
