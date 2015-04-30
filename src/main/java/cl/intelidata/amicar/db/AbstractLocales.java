package cl.intelidata.amicar.db;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractLocales entity provides the base persistence definition of the
 * Locales entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractLocales implements java.io.Serializable {

	// Fields

	private Integer	        idLocal;
	private String	        nombreLocal;
	private Set<Vendedores>	vendedoreses	= new HashSet<Vendedores>(0);
	private Set<Ejecutivos>	ejecutivoses	= new HashSet<Ejecutivos>(0);

	// Constructors

	/** default constructor */
	public AbstractLocales() {
	}

	/** full constructor */
	public AbstractLocales(String nombreLocal, Set<Vendedores> vendedoreses, Set<Ejecutivos> ejecutivoses) {
		this.nombreLocal = nombreLocal;
		this.vendedoreses = vendedoreses;
		this.ejecutivoses = ejecutivoses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idLocal", unique = true, nullable = false)
	public Integer getIdLocal() {
		return this.idLocal;
	}

	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}

	@Column(name = "nombreLocal")
	public String getNombreLocal() {
		return this.nombreLocal;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "locales")
	public Set<Vendedores> getVendedoreses() {
		return this.vendedoreses;
	}

	public void setVendedoreses(Set<Vendedores> vendedoreses) {
		this.vendedoreses = vendedoreses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "locales")
	public Set<Ejecutivos> getEjecutivoses() {
		return this.ejecutivoses;
	}

	public void setEjecutivoses(Set<Ejecutivos> ejecutivoses) {
		this.ejecutivoses = ejecutivoses;
	}

}
