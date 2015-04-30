package cl.intelidata.amicar.db;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clientes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clientes", catalog = "amicarcotizante2")
public class Clientes extends AbstractClientes implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Clientes() {
	}

	/** minimal constructor */
	public Clientes(Boolean desinscrito) {
		super(desinscrito);
	}

	/** full constructor */
	public Clientes(String rutCliente, String emailCliente, String nombreLocal, String nombreVendedor, String rutVendedor, String rutEjecutivoAdjudica, String nombreEjecutivoAdjudica,
	                String nombreCliente, String fonoCelular, String fonoComercial, String fonoParticular, String marcaVehiculo, String modeloVehiculo, String valorVehiculo, Integer idGrupo,
	                Integer idBody, Timestamp fecha, String nombreJrn, Boolean desinscrito, Set<Proceso> procesos) {
		super(
		      rutCliente, emailCliente, nombreLocal, nombreVendedor, rutVendedor, rutEjecutivoAdjudica, nombreEjecutivoAdjudica, nombreCliente, fonoCelular, fonoComercial, fonoParticular,
		      marcaVehiculo, modeloVehiculo, valorVehiculo, idGrupo, idBody, fecha, nombreJrn, desinscrito, procesos);
	}

}
