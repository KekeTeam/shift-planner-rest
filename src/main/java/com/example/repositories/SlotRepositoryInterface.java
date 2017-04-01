package com.example.repositories;

import com.example.entities.Slot;
import com.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SlotRepositoryInterface extends JpaRepository<Slot, Long> {



}
