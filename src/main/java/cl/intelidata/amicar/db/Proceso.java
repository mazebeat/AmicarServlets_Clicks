package cl.intelidata.amicar.db;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Proceso entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "proceso", catalog = "amicarcotizante2")
public class Proceso extends AbstractProceso implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Proceso() {
	}

	/** minimal constructor */
	public Proceso(Ejecutivos ejecutivos, Clientes clientes, Vendedores vendedores) {
		super(ejecutivos, clientes, vendedores);
	}

	/** full constructor */
	public Proceso(Ejecutivos ejecutivos, Clientes clientes, Vendedores vendedores, Timestamp fechaEnvio, Timestamp fechaAperturaMail, Timestamp fechaClickLink) {
		super(ejecutivos, clientes, vendedores, fechaEnvio, fechaAperturaMail, fechaClickLink);
	}

}
