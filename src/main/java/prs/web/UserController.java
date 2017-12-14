package prs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import prs.domain.User;
import prs.domain.UserRepository;

@Controller
@RequestMapping(path="/User")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/Get") 
	public @ResponseBody User getUser (@RequestParam int id) {
		User u = userRepository.findOne(id);
		return u;
		
		//
		// http://localhost:8080/User/Get?id=3
		//
	}
	
	@GetMapping(path="/Delete") 
	public @ResponseBody String getDelete (@RequestParam int id) {
		
		String msg = "";
		try {
			userRepository.delete(id);
			msg = "  id " + id + " was deleted";
		} catch (EmptyResultDataAccessException exc) {
			msg = "  id " + id + " was NOT deleted";			
		}
		return msg;
		
		//
		// http://localhost:8080/User/Delete?id=78
		//
	}
	
	@PostMapping(path="/Add") // Map ONLY POST Requests
    public @ResponseBody User addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
		// 
		// http://localhost:8080/User/Add  - used in Postman
		//
        userRepository.save(user);
        System.out.println("User saved:  "+user);
        return user;
	}
       
}
