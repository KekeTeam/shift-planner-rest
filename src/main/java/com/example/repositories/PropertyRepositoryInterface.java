package com.example.repositories;

import com.example.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PropertyRepositoryInterface extends JpaRepository<Property, Long> {



}
