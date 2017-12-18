package prs.web;

import java.util.List;

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
import prs.util.PRSMaintenanceReturn;


@Controller
@RequestMapping(path="/User")
public class UserController extends BaseController{

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/Get") 
	public @ResponseBody List<User> getUser (@RequestParam int id) {
		User u = userRepository.findOne(id);
		return getReturnArray(u);
		//
		// http://localhost:8080/User/Get?id=3
		//
	}
	
	@GetMapping(path="/Validate") // used in a post
	public @ResponseBody List<User> validate (@RequestParam String userName,
			@RequestParam String password) {
		// @RequestParam means it is a parameter from the GET or POST request;
		User u = userRepository.findByUserNameAndPassword(userName, password);
		return getReturnArray(u);
		//
		// http://localhost:8080/User/Validate?userName=ems&password=ems123
		// this worked as a url and using a GET in postman
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
	
	@PostMapping(path="/Add") // Map ONLY GET Requests
	public @ResponseBody PRSMaintenanceReturn addNewUser (@RequestBody User user) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		// Commenting out DateCreated as DB is going to handle
		// This is a good example of how to manage a date on the back end
		// though.
		//Timestamp ts = new Timestamp(System.currentTimeMillis());
		//user.setDateCreated(ts);
		try {
			userRepository.save(user);
			System.out.println("User has been saved " + user);
		} catch (Exception e) {
			user = null;
			System.out.println("User saved:  "+user);
		}
		return PRSMaintenanceReturn.getMaintReturn(user);
	}  
}
