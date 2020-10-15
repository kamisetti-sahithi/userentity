package com.dxctraining.userentity.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dxctraining.userentity.dao.*;
import com.dxctraining.userentity.entities.*;
import com.dxctraining.userentity.exceptions.*;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
	 @Autowired
	    private IUserDao dao;

	@Override
	public User create(User user) {
		validate(user);
		return dao.save(user);
	}
	private void validate(User user) {
		if(user==null) {
			throw new InvalidArgumentException("user is not null");
		}
		
	}

	@Override
	public User findUserById(String id) {
		Optional<User>optional= dao.findById(id);
	      boolean exist=optional.isPresent();
	      if(!exist){
	          throw new UserNotFoundException("user not found for id="+id);
	      }
	      User user=optional.get();
	       return user;
	    }
		
	

	@Override
	public User modifyUser(User user) {
		validate(user);
		User temp=findUserById(user.getId());
		temp.setName(user.getName());
		temp.setDescription(user.getDescription());
		temp.setStartDate(user.getStartDate());
		temp.setEndDate(user.getEndDate());
		temp.setStatus(user.getStatus());
		dao.save(temp);
		System.out.println("update successfull");
		return temp;
	}

	@Override
	public void delete(String id) {
		User user=findUserById(id);
		dao.delete(user);
	}
	 

}
