package com.dxctraining.userentity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxctraining.userentity.dto.*;
import com.dxctraining.userentity.entities.*;
import com.dxctraining.userentity.service.*;
@RestController
@RequestMapping("/users")
public class UserContoller {
	@Autowired
	private IUserService service;
	
	 @PostMapping("/add")
	 @ResponseStatus(HttpStatus.CREATED)
	 public UserDto create(@RequestBody CreateUserRequest request) {
		 User user=new User();
		 user.setName(request.getName());
		 user.setDescription(request.getDescription());
		 user.setStartDate(request.getStartDate());
		 user.setEndDate(request.getEndDate());
		 user.setStatus(request.getStatus());
		 user=service.create(user);
		 UserDto response=toDto(user);
		 return response;
		 
		 
	 }
	 @GetMapping("/get/{id}")
		public UserDto viewUser(@PathVariable("id") String id) {
			User user = service.findUserById(id);
			UserDto response = toDto(user);
			return response;
		}
	 @PutMapping("/update")
		public User modify(@RequestBody User userToUpdate) {
			User user = service.modifyUser(userToUpdate);
			return user;
		}
	 @DeleteMapping("/delete/{name}")
		public void delete(@PathVariable("name") String name) {
			service.delete(name);
		}

	 public UserDto toDto(User user) {
		 UserDto dto=new UserDto();
		 dto.setName(user.getName());
		 dto.setDescription(user.getDescription());
		 dto.setStartDate(user.getStartDate());
		 dto.setEndDate(user.getEndDate());
		 dto.setStatus(user.getStatus());
		 
		 return dto;
	 }
	

}
