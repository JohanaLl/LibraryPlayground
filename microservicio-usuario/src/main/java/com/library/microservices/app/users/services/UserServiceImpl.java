package com.library.microservices.app.users.services;

import org.springframework.stereotype.Service;

import com.library.microservices.app.commons.services.CommonServiceImpl;
import com.library.microservices.app.commonusuarios.entity.User;
import com.library.microservices.app.users.repository.UserRepository;

@Service
public class UserServiceImpl extends CommonServiceImpl<User, UserRepository> implements UserService {

	
}
