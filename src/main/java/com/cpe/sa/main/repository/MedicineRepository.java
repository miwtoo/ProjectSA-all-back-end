package com.cpe.sa.main.repository;

import com.cpe.sa.main.entity.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MedicineRepository extends JpaRepository<Medicine, Long> {

}