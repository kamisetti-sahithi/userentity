package com.dxctraining.userentity.service;
import com.dxctraining.userentity.entities.*;

public interface IUserService {
	User create(User user);
	User findUserById(String id);
	User modifyUser(User user);
	void delete(String name);

}
