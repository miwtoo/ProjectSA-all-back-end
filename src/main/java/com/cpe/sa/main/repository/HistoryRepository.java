package com.cpe.sa.main.repository;

import com.cpe.sa.main.entity.History;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HistoryRepository extends JpaRepository<History, Long> {}