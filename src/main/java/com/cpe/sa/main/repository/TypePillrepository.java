package com.cpe.sa.main.repository;
import java.util.Optional;

import com.cpe.sa.main.entity.TypePill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@EnableJpaRepositories
@CrossOrigin(origins = "http://localhost:4200")
public
interface TypePillrepository extends JpaRepository<TypePill, Long> {

	TypePill findBytypepill(String string);}