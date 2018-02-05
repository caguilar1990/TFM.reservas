package entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "aula", catalog = "gestorrecursos")
public class Aula implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Personal personal;
	private int referencia;
	private double superficie;
	private Boolean accesibilidad;
	private Set<Reservas> reservases = new HashSet<Reservas>(0);
	private Set<AulaRecursos> aulaRecursoses = new HashSet<AulaRecursos>(0);

	public Aula() {
	}

	public Aula(int referencia, double superficie, Boolean accesibilidad , Personal personal ) {
		this.referencia = referencia;
		this.superficie = superficie;
		this.accesibilidad=accesibilidad;
		this.personal= personal;
		
	}
	
	public Aula(int referencia, double superficie, Boolean accesibilidad ) {
		this.referencia = referencia;
		this.superficie = superficie;
		this.accesibilidad=accesibilidad;
		
	}


	public Aula(Personal personal, int referencia, double superficie, Boolean accesibilidad, Set<Reservas> reservases,
			Set<AulaRecursos> aulaRecursoses) {
		this.personal = personal;
		this.referencia = referencia;
		this.superficie = superficie;
		this.accesibilidad = accesibilidad;
		this.reservases = reservases;
		this.aulaRecursoses = aulaRecursoses;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "responsable")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	@Column(name = "referencia", nullable = false)
	public int getReferencia() {
		return this.referencia;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	@Column(name = "superficie", nullable = false, precision = 22, scale = 0)
	public double getSuperficie() {
		return this.superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	@Column(name = "accesibilidad")
	public Boolean getAccesibilidad() {
		return this.accesibilidad;
	}

	public void setAccesibilidad(Boolean accesibilidad) {
		this.accesibilidad = accesibilidad;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "aula")
	@JsonIgnore
	public Set<Reservas> getReservases() {
		return this.reservases;
	}

	public void setReservases(Set<Reservas> reservases) {
		this.reservases = reservases;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "aula")
	@JsonIgnore
	public Set<AulaRecursos> getAulaRecursoses() {
		return this.aulaRecursoses;
	}

	public void setAulaRecursoses(Set<AulaRecursos> aulaRecursoses) {
		this.aulaRecursoses = aulaRecursoses;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accesibilidad == null) ? 0 : accesibilidad.hashCode());
		result = prime * result + ((aulaRecursoses == null) ? 0 : aulaRecursoses.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((personal == null) ? 0 : personal.hashCode());
		result = prime * result + referencia;
		result = prime * result + ((reservases == null) ? 0 : reservases.hashCode());
		long temp;
		temp = Double.doubleToLongBits(superficie);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Aula))
			return false;
		Aula other = (Aula) obj;
		if (accesibilidad == null) {
			if (other.accesibilidad != null)
				return false;
		} else if (!accesibilidad.equals(other.accesibilidad))
			return false;
		if (aulaRecursoses == null) {
			if (other.aulaRecursoses != null)
				return false;
		} else if (!aulaRecursoses.equals(other.aulaRecursoses))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (personal == null) {
			if (other.personal != null)
				return false;
		} else if (!personal.equals(other.personal))
			return false;
		if (referencia != other.referencia)
			return false;
		if (reservases == null) {
			if (other.reservases != null)
				return false;
		} else if (!reservases.equals(other.reservases))
			return false;
		if (Double.doubleToLongBits(superficie) != Double.doubleToLongBits(other.superficie))
			return false;
		return true;
	}
	
	

}
