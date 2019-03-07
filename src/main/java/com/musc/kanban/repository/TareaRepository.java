package com.musc.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musc.kanban.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Integer>{

}
