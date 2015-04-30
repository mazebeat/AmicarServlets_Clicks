package cl.intelidata.amicar.db;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractClientealgoritmo entity provides the base persistence definition of
 * the Clientealgoritmo entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractClientealgoritmo implements java.io.Serializable {

	// Fields

	private Integer	idClienteAlgoritmo;
	private Integer	idCliente;
	private Integer	idBody;

	// Constructors

	/** default constructor */
	public AbstractClientealgoritmo() {
	}

	/** minimal constructor */
	public AbstractClientealgoritmo(Integer idClienteAlgoritmo) {
		this.idClienteAlgoritmo = idClienteAlgoritmo;
	}

	/** full constructor */
	public AbstractClientealgoritmo(Integer idClienteAlgoritmo, Integer idCliente, Integer idBody) {
		this.idClienteAlgoritmo = idClienteAlgoritmo;
		this.idCliente = idCliente;
		this.idBody = idBody;
	}

	// Property accessors
	@Id
	@Column(name = "idClienteAlgoritmo", unique = true, nullable = false)
	public Integer getIdClienteAlgoritmo() {
		return this.idClienteAlgoritmo;
	}

	public void setIdClienteAlgoritmo(Integer idClienteAlgoritmo) {
		this.idClienteAlgoritmo = idClienteAlgoritmo;
	}

	@Column(name = "idCliente")
	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	@Column(name = "idBody")
	public Integer getIdBody() {
		return this.idBody;
	}

	public void setIdBody(Integer idBody) {
		this.idBody = idBody;
	}

}
