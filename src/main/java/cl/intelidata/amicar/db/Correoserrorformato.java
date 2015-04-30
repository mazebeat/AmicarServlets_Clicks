package cl.intelidata.amicar.db;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Correoserrorformato entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "correoserrorformato", catalog = "amicarcotizante2")
public class Correoserrorformato extends AbstractCorreoserrorformato implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Correoserrorformato() {
	}

	/** full constructor */
	public Correoserrorformato(String rutCliente, String emailCliente, String nombreLocal, String nombreVendedor, String rutVendedor, String rutEjecutivoAdjudica, String nombreEjecutivoAdjudica,
	                String nombreCliente, String fonoCelular, String fonoComercial, String fonoParticular, String marcaVehiculo, String modeloVehiculo, String valorVehiculo, Integer idGrupo,
	                Integer idBody, Timestamp fecha, String nombreJrn, String estado) {
		super(
		      rutCliente, emailCliente, nombreLocal, nombreVendedor, rutVendedor, rutEjecutivoAdjudica, nombreEjecutivoAdjudica, nombreCliente, fonoCelular, fonoComercial, fonoParticular,
		      marcaVehiculo, modeloVehiculo, valorVehiculo, idGrupo, idBody, fecha, nombreJrn, estado);
	}

}
