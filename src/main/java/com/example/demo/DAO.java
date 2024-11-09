package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
@Component
public class DAO {
	@Autowired
	UserInterface repo; //JPA handle the class of the UserInterface child
	// the methods in the CHildcalss will also be autoDefined(taken care by JPA)
	
	public void insert(User u1) {
		repo.save(u1);
	}
	
	public User findUser(String email) {
		return repo.findByEmail(email);		
	}
	
	public List<User> retrieveAll(){
		return repo.findAll();
	}
	
	public String deleteUser(String email) {
		repo.delete(repo.findByEmail(email));
		return "Deleted"+email;
	}
	
	public List<User> findPage() {
		Sort sort = Sort.by(Sort.Direction.DESC, "name");
		Pageable pageable = PageRequest.of(0,  1, sort);
		return repo.findAll(pageable).toList();
	}
}
