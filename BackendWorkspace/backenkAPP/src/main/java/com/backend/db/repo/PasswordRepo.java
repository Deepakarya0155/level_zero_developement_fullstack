package com.backend.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.backend.db.entities.PasswordEntity;

@CrossOrigin
@Repository
@RepositoryRestResource(path="password")
public interface PasswordRepo extends JpaRepository<PasswordEntity, Long>{

	
}
