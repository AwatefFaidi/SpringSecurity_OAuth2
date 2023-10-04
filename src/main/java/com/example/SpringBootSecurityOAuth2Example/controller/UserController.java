package com.example.SpringBootSecurityOAuth2Example.controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestHeader;
	import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootSecurityOAuth2Example.Entity.UserManagment;
import com.example.SpringBootSecurityOAuth2Example.Service.UserService;



	@RestController
	public class UserController {
		@Autowired
		private UserService userService;

		@GetMapping("/user")
		public Object getAllUser(@RequestHeader HttpHeaders requestHeader) {
			List<UserManagment> UserManagments = userService.getAllActiveUserInfo();
			
			if (UserManagments == null || UserManagments.isEmpty()) {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			return UserManagments;
		}

		@PostMapping("/user")
		public UserManagment addUser(@RequestBody UserManagment userRecord) {
			return userService.addUser(userRecord);
		}
		
		

		@PutMapping("/user/{id}")
		public UserManagment updateUser(@RequestBody UserManagment userRecord, @PathVariable Integer id) {
			return userService.updateUser(id,userRecord);
		}
		
		@PutMapping("/user/changePassword/{id}")
		public UserManagment updateUserPassword(@RequestBody UserManagment userRecord, @PathVariable Integer id) {
			return userService.updatePassword(id,userRecord);
		}
		
		@PutMapping("/user/changeRole/{id}")
		public UserManagment updateUserRole(@RequestBody UserManagment userRecord, @PathVariable Integer id) {
			return userService.updateRole(id,userRecord);
		}

		@DeleteMapping("/user/{id}")
		public void deleteUser(@PathVariable Integer id) {
			userService.deleteUser(id);
		}

		@GetMapping("/user/{id}")
		public ResponseEntity<UserManagment> getUserById(@PathVariable Integer id) {
			UserManagment UserManagment = userService.getUserInfoById(id);
			if (UserManagment == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(UserManagment, HttpStatus.OK);
		}
	}