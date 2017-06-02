package user.web;

import java.util.List;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;

import user.domain.User;
import user.service.UserService;

@RestController
@RequestMapping("/users")
public class RestUserController {
	
	UserService userService;
	
	@Autowired
	public RestUserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> retrieveAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public User retrieveUser(@PathVariable Long id){
		return userService.findById(id);
		
	}
	
	@PostMapping
	public HttpEntity<Void> createUser(@RequestBody User user) {
		User savedUser = userService.save(user);
		
		UriComponents uriComponents = fromMethodCall(
				on(getClass()).retrieveUser(savedUser.getId())).build();
		
		return ResponseEntity.created(uriComponents.encode().toUri()).build();
	}
	
	@PutMapping
	@ResponseStatus(NO_CONTENT)
	public void updateUser(@RequestBody User user, @PathVariable Long id) {
		userService.save(user);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteById(id);
	}
}
