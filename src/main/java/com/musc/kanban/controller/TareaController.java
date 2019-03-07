package com.musc.kanban.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musc.kanban.model.Tarea;
import com.musc.kanban.repository.TareaRepository;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

	@Autowired
	private TareaRepository tareaRepository;

	@GetMapping
	public List<Tarea> getList() {
		return this.tareaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Tarea> getById(@PathVariable int id) {
		return this.tareaRepository.findById(id);
	}

	@PostMapping
	public Tarea create(@Valid @RequestBody Tarea tarea) {
		return this.tareaRepository.save(tarea);
	}

	@PutMapping("/{id}")
	public Optional<Object> update(@PathVariable int id, @Valid @RequestBody Tarea tarea) {
		return this.tareaRepository.findById(id).map(t -> {
			t.setCompletada(tarea.getCompletada());
			t.setDescripcion(tarea.getDescripcion());
			t.setNombre(tarea.getNombre());
			t.setPrioridad(tarea.getPrioridad());
			return this.tareaRepository.save(t);
		});
	}

	@DeleteMapping("/{id}")
	public Optional<Object> delete(@PathVariable int id) {
		return this.tareaRepository.findById(id).map(t -> {
			this.tareaRepository.delete(t);
			return ResponseEntity.ok().build();
		});
	}
}
