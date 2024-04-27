package com.library.microservices.app.users.repository;


import org.springframework.data.repository.CrudRepository;

import com.library.microservices.app.commonusuarios.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
