package com.cpe.sa.main.warehouse.repository;

import java.util.Optional;

import com.cpe.sa.main.warehouse.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
    public
    interface ItemRepository extends JpaRepository<Item, Long> {

	Optional<Item> findByItemName(String itemName);
}