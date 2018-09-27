package com.cpe.sa.main.warehouse.repository;

import com.cpe.sa.main.warehouse.entity.TypeList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TypeListRepository extends JpaRepository<TypeList, Long> {
    
}