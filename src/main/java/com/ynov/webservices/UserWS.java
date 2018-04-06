package com.ynov.webservices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.model.User;
import com.ynov.repository.UserRepository;

//API DOCUMENTATION HERE : https://carpool-ynov.herokuapp.com/swagger-ui.html

@RestController
@RequestMapping("/carpool")
public class UserWS {
	
	@Autowired
	private UserRepository userRepository;

	//GET ALL USERS
    @CrossOrigin(origins = "*")
	@RequestMapping(value="/users", method=RequestMethod.GET)
    public  List<User> getUsers() {
		
        return userRepository.findAll();
    }
    
    //GET USER BY ID
    @CrossOrigin(origins = "*")
   	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public User getUserById(@PathVariable("id") String id) {

    		Optional<User> user = userRepository.findById(id);
    	
		return user.get();
	}
    
    //LOGIN USER
    @CrossOrigin(origins = "*")
   	@RequestMapping(value="/users/{email}/{password}", method=RequestMethod.GET)
    public User login(@PathVariable("email") String email, @PathVariable("password") String password) {
    	
    		Optional<User> user = userRepository.findByEmail(email);
    		
    		if(user.isPresent()) {
    			if(password.equals(user.get().getPassword())) {
    				return user.get();
    			} else {
    				throw new java.lang.Error("password not match with email");
    			}
    		} else {
    			throw new java.lang.Error("email not exist");
    		}

    }
	
	//CREATED USED
    @CrossOrigin(origins = "*")
	@RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) throws Exception {
		
    		boolean emailAvailable = userRepository.findByEmail(user.getEmail()).isPresent();
    		
		if(!emailAvailable) {
			userRepository.save(user);
		} else {
			throw new java.lang.Error("email already exist");
		}
		
		return user;
    }
	
	//UPDATED USER
    @CrossOrigin(origins = "*")
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) throws Exception {
		
    		boolean userExist = userRepository.findByEmail(user.getEmail()).isPresent();
		
		if(userExist) {
			//update
			userRepository.save(user);
		} else {
			throw new java.lang.Error("User not exist");
		}
		
		return user;
    }
	
	//DELETED USER
    @CrossOrigin(origins = "*")
	@RequestMapping(value = "/users", method = RequestMethod.DELETE)
	public User deleteUser(@RequestBody User user) throws Exception {
		
    		boolean userExist = userRepository.findByEmail(user.getEmail()).isPresent();
		
		if(userExist) {
			userRepository.delete(user);	
		} else {
			throw new java.lang.Error("Delete user failed");
		}
		
		return user;
	}
}
