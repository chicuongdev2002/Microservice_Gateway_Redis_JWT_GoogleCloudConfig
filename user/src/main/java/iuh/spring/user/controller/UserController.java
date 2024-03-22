package iuh.spring.user.controller;

import iuh.spring.user.entity.User;
import iuh.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

//	@GetMapping("/user")
//	public String getHello() {
//		return "User nha";
//	}

	@GetMapping()
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// Thêm user
	@PostMapping("")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	// Tìm user bởi ID
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}
}
