package cl.intelidata.amicar.db;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractProceso entity provides the base persistence definition of the
 * Proceso entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractProceso implements java.io.Serializable {

	// Fields

	private Integer	   idProceso;
	private Ejecutivos	ejecutivos;
	private Clientes	clientes;
	private Vendedores	vendedores;
	private Timestamp	fechaEnvio;
	private Timestamp	fechaAperturaMail;
	private Timestamp	fechaClickLink;

	// Constructors

	/** default constructor */
	public AbstractProceso() {
	}

	/** minimal constructor */
	public AbstractProceso(Ejecutivos ejecutivos, Clientes clientes, Vendedores vendedores) {
		this.ejecutivos = ejecutivos;
		this.clientes = clientes;
		this.vendedores = vendedores;
	}

	/** full constructor */
	public AbstractProceso(Ejecutivos ejecutivos, Clientes clientes, Vendedores vendedores, Timestamp fechaEnvio, Timestamp fechaAperturaMail, Timestamp fechaClickLink) {
		this.ejecutivos = ejecutivos;
		this.clientes = clientes;
		this.vendedores = vendedores;
		this.fechaEnvio = fechaEnvio;
		this.fechaAperturaMail = fechaAperturaMail;
		this.fechaClickLink = fechaClickLink;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idProceso", unique = true, nullable = false)
	public Integer getIdProceso() {
		return this.idProceso;
	}

	public void setIdProceso(Integer idProceso) {
		this.idProceso = idProceso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ejecutivos_idEjecutivo", nullable = false)
	public Ejecutivos getEjecutivos() {
		return this.ejecutivos;
	}

	public void setEjecutivos(Ejecutivos ejecutivos) {
		this.ejecutivos = ejecutivos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_idCliente", nullable = false)
	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendedores_idVendedor", nullable = false)
	public Vendedores getVendedores() {
		return this.vendedores;
	}

	public void setVendedores(Vendedores vendedores) {
		this.vendedores = vendedores;
	}

	@Column(name = "fechaEnvio", length = 19)
	public Timestamp getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Timestamp fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	@Column(name = "fechaAperturaMail", length = 19)
	public Timestamp getFechaAperturaMail() {
		return this.fechaAperturaMail;
	}

	public void setFechaAperturaMail(Timestamp fechaAperturaMail) {
		this.fechaAperturaMail = fechaAperturaMail;
	}

	@Column(name = "fechaClickLink", length = 19)
	public Timestamp getFechaClickLink() {
		return this.fechaClickLink;
	}

	public void setFechaClickLink(Timestamp fechaClickLink) {
		this.fechaClickLink = fechaClickLink;
	}

}
