package com.cpe.sa.main.repository;

import com.cpe.sa.main.entity.PrefixEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface  PrefixRepository extends JpaRepository<PrefixEntity,Long> {
    PrefixEntity findByPrefix(String prefix);
}
