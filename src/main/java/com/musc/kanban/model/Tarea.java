// Generated with g9.

package com.musc.kanban.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.musc.kanban.model.enumerations.Prioridad;

@Entity(name = "tareas")
public class Tarea implements Serializable {

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;

	@NotBlank
	@Size(min = 3, max = 30)
	@Column(nullable = false, length = 30)
	private String nombre;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 1)
	private Prioridad prioridad;

	@NotBlank
	@Size(min = 3)
	@Column(nullable = false)
	private String descripcion;

	@Column(nullable = false, length = 1)
	private boolean completada;

	/** Default constructor. */
	public Tarea() {
		super();
	}

	/**
	 * Access method for id.
	 *
	 * @return the current value of id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 *
	 * @param aId the new value for id
	 */
	public void setId(int aId) {
		id = aId;
	}

	/**
	 * Access method for nombre.
	 *
	 * @return the current value of nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter method for nombre.
	 *
	 * @param aNombre the new value for nombre
	 */
	public void setNombre(String aNombre) {
		nombre = aNombre;
	}

	/**
	 * Access method for prioridad.
	 *
	 * @return the current value of prioridad
	 */
	public Prioridad getPrioridad() {
		return prioridad;
	}

	/**
	 * Setter method for prioridad.
	 *
	 * @param aPrioridad the new value for prioridad
	 */
	public void setPrioridad(Prioridad aPrioridad) {
		prioridad = aPrioridad;
	}

	/**
	 * Access method for descripcion.
	 *
	 * @return the current value of descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setter method for descripcion.
	 *
	 * @param aDescripcion the new value for descripcion
	 */
	public void setDescripcion(String aDescripcion) {
		descripcion = aDescripcion;
	}

	/**
	 * Access method for completada.
	 *
	 * @return true if and only if completada is currently true
	 */
	public boolean getCompletada() {
		return completada;
	}

	/**
	 * Setter method for completada.
	 *
	 * @param aCompletada the new value for completada
	 */
	public void setCompletada(boolean aCompletada) {
		completada = aCompletada;
	}

	/**
	 * Compares the key for this instance with another Tarea.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Tarea and the key objects
	 *         are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tarea)) {
			return false;
		}
		Tarea that = (Tarea) other;
		if (this.getId() != that.getId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another Tarea.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Tarea))
			return false;
		return this.equalKeys(other) && ((Tarea) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		i = getId();
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[Tarea |");
		sb.append(" id=").append(getId());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("id", Integer.valueOf(getId()));
		return ret;
	}

}
