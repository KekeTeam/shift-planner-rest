package com.example.repositories;

import com.example.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaskRepositoryInterface extends JpaRepository<Task, Long> {



}
