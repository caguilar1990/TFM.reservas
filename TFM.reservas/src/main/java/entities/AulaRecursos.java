package entities;

// default package
// Generated 29-may-2017 19:54:34 by Hibernate Tools 5.2.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import identifiers.AulaRecursosId;

/**
 * AulaRecursos generated by hbm2java
 */
@Entity
@Table(name = "aula_recursos", catalog = "gestorrecursos")
public class AulaRecursos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AulaRecursosId id;
	private Aula aula;
	private Recursos recursos;
	private int cantidad;

	public AulaRecursos() {
	}

	public AulaRecursos(AulaRecursosId id, Aula aula, Recursos recursos, int cantidad) {
		this.id = id;
		this.aula = aula;
		this.recursos = recursos;
		this.cantidad = cantidad;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idAula", column = @Column(name = "id_aula", nullable = false)),
			@AttributeOverride(name = "idRecurso", column = @Column(name = "id_recurso", nullable = false)) })
	public AulaRecursosId getId() {
		return this.id;
	}

	public void setId(AulaRecursosId id) {
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
	@JoinColumn(name = "id_recurso", nullable = false, insertable = false, updatable = false)
	public Recursos getRecursos() {
		return this.recursos;
	}

	public void setRecursos(Recursos recursos) {
		this.recursos = recursos;
	}

	@Column(name = "cantidad", nullable = false)
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "AulaRecursos [id=" + id + ", aula=" + aula.toString() + ", recursos=" + recursos.toString() + ", cantidad=" + cantidad + "]";
	}


}
