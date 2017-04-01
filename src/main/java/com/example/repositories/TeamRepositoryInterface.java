package com.example.repositories;

import com.example.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TeamRepositoryInterface extends JpaRepository<Team, Long> {



}
