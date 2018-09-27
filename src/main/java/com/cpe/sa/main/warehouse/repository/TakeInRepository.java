package com.cpe.sa.main.warehouse.repository;
import com.cpe.sa.main.warehouse.entity.TakeIn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
    public
    interface TakeInRepository extends JpaRepository<TakeIn, Long> {
}