package cl.intelidata.amicar.db;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clientealgoritmo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clientealgoritmo", catalog = "amicarcotizante2")
public class Clientealgoritmo extends AbstractClientealgoritmo implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Clientealgoritmo() {
	}

	/** minimal constructor */
	public Clientealgoritmo(Integer idClienteAlgoritmo) {
		super(idClienteAlgoritmo);
	}

	/** full constructor */
	public Clientealgoritmo(Integer idClienteAlgoritmo, Integer idCliente, Integer idBody) {
		super(idClienteAlgoritmo, idCliente, idBody);
	}

}
