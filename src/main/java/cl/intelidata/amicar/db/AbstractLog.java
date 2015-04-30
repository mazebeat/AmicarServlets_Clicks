package cl.intelidata.amicar.db;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractLog entity provides the base persistence definition of the Log
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractLog implements java.io.Serializable {

	// Fields

	private Integer	  idlog;
	private Integer	  idVendedor;
	private Integer	  idCliente;
	private Integer	  idEjecutivo;
	private Timestamp	fechaLog;

	// Constructors

	/** default constructor */
	public AbstractLog() {
	}

	/** minimal constructor */
	public AbstractLog(Integer idlog) {
		this.idlog = idlog;
	}

	/** full constructor */
	public AbstractLog(Integer idlog, Integer idVendedor, Integer idCliente, Integer idEjecutivo, Timestamp fechaLog) {
		this.idlog = idlog;
		this.idVendedor = idVendedor;
		this.idCliente = idCliente;
		this.idEjecutivo = idEjecutivo;
		this.fechaLog = fechaLog;
	}

	// Property accessors
	@Id
	@Column(name = "idlog", unique = true, nullable = false)
	public Integer getIdlog() {
		return this.idlog;
	}

	public void setIdlog(Integer idlog) {
		this.idlog = idlog;
	}

	@Column(name = "idVendedor")
	public Integer getIdVendedor() {
		return this.idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	@Column(name = "idCliente")
	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	@Column(name = "idEjecutivo")
	public Integer getIdEjecutivo() {
		return this.idEjecutivo;
	}

	public void setIdEjecutivo(Integer idEjecutivo) {
		this.idEjecutivo = idEjecutivo;
	}

	@Column(name = "fechaLog", length = 19)
	public Timestamp getFechaLog() {
		return this.fechaLog;
	}

	public void setFechaLog(Timestamp fechaLog) {
		this.fechaLog = fechaLog;
	}

}
