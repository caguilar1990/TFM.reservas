package entities;

// default package
// Generated 29-may-2017 19:54:34 by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Permisos generated by hbm2java
 */
@Entity
@Table(name = "permisos", catalog = "gestorrecursos")
public class Permisos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String descripcion;
	private String permisos;
	private Set<Personal> personals = new HashSet<Personal>(0);

	public Permisos() {
	}

	public Permisos(Integer id, String descripcion, String permisos) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.permisos = permisos;
	}

	public Permisos(String descripcion, String permisos) {
		this.descripcion = descripcion;
		this.permisos = permisos;
	}

	public Permisos(String descripcion, String permisos, Set<Personal> personals) {
		this.descripcion = descripcion;
		this.permisos = permisos;
		this.personals = personals;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "permisos", nullable = false)
	public String getPermisos() {
		return this.permisos;
	}

	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "permisos")
	@JsonIgnore
	public Set<Personal> getPersonals() {
		return this.personals;
	}

	public void setPersonals(Set<Personal> personals) {
		this.personals = personals;
	}

}