package com.cpe.sa.main.repository;

import com.cpe.sa.main.entity.ProfilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProfilesRepository extends JpaRepository<ProfilesEntity,Long> {
    ProfilesEntity  findByTelephonenumber(String telephonenumber);

}
