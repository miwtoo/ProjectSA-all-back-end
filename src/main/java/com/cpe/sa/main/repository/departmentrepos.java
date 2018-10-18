package com.cpe.sa.main.repository;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.cpe.sa.main.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public
interface departmentrepos extends JpaRepository< Department, Long> {

}