package cl.intelidata.amicar.db;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractEjecutivos entity provides the base persistence definition of the
 * Ejecutivos entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractEjecutivos implements java.io.Serializable {

	// Fields

	private Integer	     idEjecutivo;
	private Locales	     locales;
	private String	     rutEjecutivo;
	private String	     nombreEjecutivo;
	private String	     correoEjecutivo;
	private Timestamp	 fechaIngreso;
	private String	     fechaModificacion;
	private Set<Proceso>	procesos	= new HashSet<Proceso>(0);

	// Constructors

	/** default constructor */
	public AbstractEjecutivos() {
	}

	/** minimal constructor */
	public AbstractEjecutivos(Locales locales) {
		this.locales = locales;
	}

	/** full constructor */
	public AbstractEjecutivos(Locales locales, String rutEjecutivo, String nombreEjecutivo, String correoEjecutivo, Timestamp fechaIngreso, String fechaModificacion, Set<Proceso> procesos) {
		this.locales = locales;
		this.rutEjecutivo = rutEjecutivo;
		this.nombreEjecutivo = nombreEjecutivo;
		this.correoEjecutivo = correoEjecutivo;
		this.fechaIngreso = fechaIngreso;
		this.fechaModificacion = fechaModificacion;
		this.procesos = procesos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idEjecutivo", unique = true, nullable = false)
	public Integer getIdEjecutivo() {
		return this.idEjecutivo;
	}

	public void setIdEjecutivo(Integer idEjecutivo) {
		this.idEjecutivo = idEjecutivo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locales_idLocal1", nullable = false)
	public Locales getLocales() {
		return this.locales;
	}

	public void setLocales(Locales locales) {
		this.locales = locales;
	}

	@Column(name = "rutEjecutivo", length = 12)
	public String getRutEjecutivo() {
		return this.rutEjecutivo;
	}

	public void setRutEjecutivo(String rutEjecutivo) {
		this.rutEjecutivo = rutEjecutivo;
	}

	@Column(name = "nombreEjecutivo", length = 100)
	public String getNombreEjecutivo() {
		return this.nombreEjecutivo;
	}

	public void setNombreEjecutivo(String nombreEjecutivo) {
		this.nombreEjecutivo = nombreEjecutivo;
	}

	@Column(name = "correoEjecutivo", length = 45)
	public String getCorreoEjecutivo() {
		return this.correoEjecutivo;
	}

	public void setCorreoEjecutivo(String correoEjecutivo) {
		this.correoEjecutivo = correoEjecutivo;
	}

	@Column(name = "fechaIngreso", length = 19)
	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Column(name = "fechaModificacion", length = 45)
	public String getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ejecutivos")
	public Set<Proceso> getProcesos() {
		return this.procesos;
	}

	public void setProcesos(Set<Proceso> procesos) {
		this.procesos = procesos;
	}

}
