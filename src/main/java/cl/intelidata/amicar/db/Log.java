package cl.intelidata.amicar.db;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log", catalog = "amicarcotizante2")
public class Log extends AbstractLog implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** minimal constructor */
	public Log(Integer idlog) {
		super(idlog);
	}

	/** full constructor */
	public Log(Integer idlog, Integer idVendedor, Integer idCliente, Integer idEjecutivo, Timestamp fechaLog) {
		super(idlog, idVendedor, idCliente, idEjecutivo, fechaLog);
	}

}
