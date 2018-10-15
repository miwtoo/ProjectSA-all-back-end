package com.cpe.sa.main.repository;

import com.cpe.sa.main.entity.SexEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SexRepository extends JpaRepository<SexEntity,Long> {
    SexEntity findBySex(String sex);

}
