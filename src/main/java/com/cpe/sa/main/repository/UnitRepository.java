package com.cpe.sa.main.repository;

import com.cpe.sa.main.entity.Unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UnitRepository extends JpaRepository<Unit, Long> {}