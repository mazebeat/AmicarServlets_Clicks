package cl.intelidata.amicar.db;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clientesdiario entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clientesdiario", catalog = "amicarcotizante2")
public class Clientesdiario extends AbstractClientesdiario implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Clientesdiario() {
	}

	/** full constructor */
	public Clientesdiario(String rutCliente, String emailCliente, String nombreLocal, String nombreVendedor, String rutVendedor, String rutEjecutivoAdjudica, String nombreEjecutivoAdjudica,
	                String nombreCliente, String fonoCelular, String fonoComercial, String fonoParticular, String marcaVehiculo, String modeloVehiculo, String valorVehiculo, Integer idGrupo,
	                Integer idBody, Timestamp fecha, String nombreJrn) {
		super(
		      rutCliente, emailCliente, nombreLocal, nombreVendedor, rutVendedor, rutEjecutivoAdjudica, nombreEjecutivoAdjudica, nombreCliente, fonoCelular, fonoComercial, fonoParticular,
		      marcaVehiculo, modeloVehiculo, valorVehiculo, idGrupo, idBody, fecha, nombreJrn);
	}

}
