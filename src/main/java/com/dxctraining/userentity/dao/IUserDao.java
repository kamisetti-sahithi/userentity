package com.dxctraining.userentity.dao;

import com.dxctraining.userentity.entities.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IUserDao extends MongoRepository<User, String> {

}
