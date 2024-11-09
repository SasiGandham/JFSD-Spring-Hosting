package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController 
@CrossOrigin
public class Service {
	
	@Autowired
	DAO dao;
	
	@GetMapping("/")
	public String fun1() {
		return "Welcome Home Page";
	}
	
	@GetMapping("/welcome/{name}")
	public String fun1(@PathVariable("name") String name) {
		return "Welcome "+name;
	}
	
	@PostMapping("/user")
	public String insertUser(@RequestBody User user) {
		dao.insert(user);
		return "Springboot Response" + user;
	}
	
	@GetMapping("/all")
	public List<User> fun6() {
		return dao.retrieveAll();
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam("email") String email) {
		return dao.deleteUser(email);
	}
	
	
     //	@GetMapping(" 	/user")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getDetails(@RequestParam("email") String email) {
		return dao.findUser(email).toString();
		
	}
	
	
	@GetMapping("/page")
	public String fun5() {
		return dao.findPage().toString();
	}
	
}
