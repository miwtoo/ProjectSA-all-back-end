package com.cpe.sa.main.repository;

import com.cpe.sa.main.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);

	User findByPassWord(String password);

}