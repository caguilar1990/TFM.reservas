package entities;



import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import identifiers.ReservasId;


@Entity
@Table(name = "reservas", catalog = "gestorrecursos")
public class Reservas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReservasId id;
	private Aula aula;
	private Horario horario;
	private Personal personal;
	private Date fechaOperacion;
	private String descripcion;
	private boolean estado;

	public Reservas() {
	}

	public Reservas(ReservasId id, Aula aula, Personal personal,Horario horario) {
		this.id = id;
		this.aula = aula;
		this.personal = personal;
		this.horario = horario;
	}

	public Reservas(ReservasId id, Aula aula, Personal personal, Date fechaReserva) {
		this.id = id;
		this.aula = aula;
		this.personal = personal;
		this.fechaOperacion = fechaReserva;
	}

	
	
	public Reservas(ReservasId id, Aula aula, Horario horario, Personal personal, Date fechaReserva,
			String descripcion) {
		this.id = id;
		this.aula = aula;
		this.horario = horario;
		this.personal = personal;
		this.fechaOperacion = fechaReserva;
		this.descripcion = descripcion;
	}
	
	

	public Reservas(ReservasId id, Aula aula, Horario horario, Personal personal, Date fechaReserva, String descripcion,
			boolean estado) {
		super();
		this.id = id;
		this.aula = aula;
		this.horario = horario;
		this.personal = personal;
		this.fechaOperacion = fechaReserva;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idPersonal", column = @Column(name = "id_personal", nullable = false)),
			@AttributeOverride(name = "idAula", column = @Column(name = "id_aula", nullable = false)),
			@AttributeOverride(name = "fechaReserva", column = @Column(name = "fecha_reserva", nullable = false, length = 10)),
			@AttributeOverride(name = "idHorario", column = @Column(name = "id_horario", nullable = false)) })

	public ReservasId getId() {
		return this.id;
	}

	public void setId(ReservasId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_aula", nullable = false, insertable = false, updatable = false)
	public Aula getAula() {
		return this.aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_horario", nullable = false, insertable = false, updatable = false)
	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_personal", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	public Personal getPersonal() {
		return this.personal;
	}
	

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	
	@Column(name = "fecha_operacion")
	public Date getFechaOperacion() {
		return this.fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	
	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name = "estado")
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	


}
