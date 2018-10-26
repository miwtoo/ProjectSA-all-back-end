package com.cpe.sa.main.repository;

import com.cpe.sa.main.entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}