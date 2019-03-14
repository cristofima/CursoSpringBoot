package com.musc.kanban.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musc.kanban.exception.ResourceCantBeModificateException;
import com.musc.kanban.exception.ResourceNotFoundException;
import com.musc.kanban.model.Tarea;
import com.musc.kanban.repository.TareaRepository;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

	@Autowired
	private TareaRepository tareaRepository;

	@GetMapping
	public Page<Tarea> getList(Pageable pageable) {
		return this.tareaRepository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Tarea getById(@PathVariable int id) {
		return this.tareaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarea con ID " + id + " no fue encontrada"));
	}

	@PostMapping
	public Tarea create(@Valid @RequestBody Tarea tarea) {
		return this.tareaRepository.save(tarea);
	}

	@PutMapping("/{id}")
	public Tarea update(@PathVariable int id, @Valid @RequestBody Tarea tarea) {
		return this.tareaRepository.findById(id).map(t -> {
			if (t.getCompletada()) {
				throw new ResourceCantBeModificateException(
						"Tarea con ID " + id + " ya se encuentra completada, y no puede ser modificada");
			}

			t.setCompletada(tarea.getCompletada());
			t.setDescripcion(tarea.getDescripcion());
			t.setNombre(tarea.getNombre());
			t.setPrioridad(tarea.getPrioridad());
			return this.tareaRepository.save(t);
		}).orElseThrow(() -> new ResourceNotFoundException("Tarea con ID " + id + " no fue encontrada"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		return this.tareaRepository.findById(id).map(t -> {
			this.tareaRepository.delete(t);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Tarea con ID " + id + " no fue encontrada"));
	}
}
