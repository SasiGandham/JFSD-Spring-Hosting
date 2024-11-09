package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserInterface extends JpaRepository<User, String> //here String is datatype of primary key
{
	public User findByEmail(String email); // this will be auto defined 
										   // we should make sure that findByEmail is given correctly

}
