package com.cpe.sa.main.repository;

import com.cpe.sa.main.entity.MedicineData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
    public
    interface MedicineDataRepository extends JpaRepository<MedicineData, Long> {

}