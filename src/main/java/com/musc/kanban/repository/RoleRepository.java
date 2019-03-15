package com.musc.kanban.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musc.kanban.model.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Integer> {
	Optional<Rol> findByName(String name);
}
