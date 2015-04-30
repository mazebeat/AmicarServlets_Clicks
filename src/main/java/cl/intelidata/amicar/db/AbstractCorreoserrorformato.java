package cl.intelidata.amicar.db;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractCorreoserrorformato entity provides the base persistence definition
 * of the Correoserrorformato entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractCorreoserrorformato implements java.io.Serializable {

	// Fields

	private Integer	  idCliente;
	private String	  rutCliente;
	private String	  emailCliente;
	private String	  nombreLocal;
	private String	  nombreVendedor;
	private String	  rutVendedor;
	private String	  rutEjecutivoAdjudica;
	private String	  nombreEjecutivoAdjudica;
	private String	  nombreCliente;
	private String	  fonoCelular;
	private String	  fonoComercial;
	private String	  fonoParticular;
	private String	  marcaVehiculo;
	private String	  modeloVehiculo;
	private String	  valorVehiculo;
	private Integer	  idGrupo;
	private Integer	  idBody;
	private Timestamp	fecha;
	private String	  nombreJrn;
	private String	  estado;

	// Constructors

	/** default constructor */
	public AbstractCorreoserrorformato() {
	}

	/** full constructor */
	public AbstractCorreoserrorformato(String rutCliente, String emailCliente, String nombreLocal, String nombreVendedor, String rutVendedor, String rutEjecutivoAdjudica,
	                String nombreEjecutivoAdjudica, String nombreCliente, String fonoCelular, String fonoComercial, String fonoParticular, String marcaVehiculo, String modeloVehiculo,
	                String valorVehiculo, Integer idGrupo, Integer idBody, Timestamp fecha, String nombreJrn, String estado) {
		this.rutCliente = rutCliente;
		this.emailCliente = emailCliente;
		this.nombreLocal = nombreLocal;
		this.nombreVendedor = nombreVendedor;
		this.rutVendedor = rutVendedor;
		this.rutEjecutivoAdjudica = rutEjecutivoAdjudica;
		this.nombreEjecutivoAdjudica = nombreEjecutivoAdjudica;
		this.nombreCliente = nombreCliente;
		this.fonoCelular = fonoCelular;
		this.fonoComercial = fonoComercial;
		this.fonoParticular = fonoParticular;
		this.marcaVehiculo = marcaVehiculo;
		this.modeloVehiculo = modeloVehiculo;
		this.valorVehiculo = valorVehiculo;
		this.idGrupo = idGrupo;
		this.idBody = idBody;
		this.fecha = fecha;
		this.nombreJrn = nombreJrn;
		this.estado = estado;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCliente", unique = true, nullable = false)
	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	@Column(name = "rutCliente", length = 12)
	public String getRutCliente() {
		return this.rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	@Column(name = "emailCliente", length = 100)
	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Column(name = "nombreLocal", length = 100)
	public String getNombreLocal() {
		return this.nombreLocal;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

	@Column(name = "nombreVendedor", length = 100)
	public String getNombreVendedor() {
		return this.nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	@Column(name = "rutVendedor", length = 12)
	public String getRutVendedor() {
		return this.rutVendedor;
	}

	public void setRutVendedor(String rutVendedor) {
		this.rutVendedor = rutVendedor;
	}

	@Column(name = "rutEjecutivoAdjudica", length = 12)
	public String getRutEjecutivoAdjudica() {
		return this.rutEjecutivoAdjudica;
	}

	public void setRutEjecutivoAdjudica(String rutEjecutivoAdjudica) {
		this.rutEjecutivoAdjudica = rutEjecutivoAdjudica;
	}

	@Column(name = "nombreEjecutivoAdjudica", length = 100)
	public String getNombreEjecutivoAdjudica() {
		return this.nombreEjecutivoAdjudica;
	}

	public void setNombreEjecutivoAdjudica(String nombreEjecutivoAdjudica) {
		this.nombreEjecutivoAdjudica = nombreEjecutivoAdjudica;
	}

	@Column(name = "nombreCliente", length = 100)
	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	@Column(name = "fonoCelular", length = 15)
	public String getFonoCelular() {
		return this.fonoCelular;
	}

	public void setFonoCelular(String fonoCelular) {
		this.fonoCelular = fonoCelular;
	}

	@Column(name = "fonoComercial", length = 15)
	public String getFonoComercial() {
		return this.fonoComercial;
	}

	public void setFonoComercial(String fonoComercial) {
		this.fonoComercial = fonoComercial;
	}

	@Column(name = "fonoParticular", length = 15)
	public String getFonoParticular() {
		return this.fonoParticular;
	}

	public void setFonoParticular(String fonoParticular) {
		this.fonoParticular = fonoParticular;
	}

	@Column(name = "marcaVehiculo", length = 100)
	public String getMarcaVehiculo() {
		return this.marcaVehiculo;
	}

	public void setMarcaVehiculo(String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	@Column(name = "modeloVehiculo", length = 100)
	public String getModeloVehiculo() {
		return this.modeloVehiculo;
	}

	public void setModeloVehiculo(String modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	@Column(name = "valorVehiculo", length = 45)
	public String getValorVehiculo() {
		return this.valorVehiculo;
	}

	public void setValorVehiculo(String valorVehiculo) {
		this.valorVehiculo = valorVehiculo;
	}

	@Column(name = "idGrupo")
	public Integer getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	@Column(name = "idBody")
	public Integer getIdBody() {
		return this.idBody;
	}

	public void setIdBody(Integer idBody) {
		this.idBody = idBody;
	}

	@Column(name = "fecha", length = 19)
	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	@Column(name = "nombreJrn", length = 100)
	public String getNombreJrn() {
		return this.nombreJrn;
	}

	public void setNombreJrn(String nombreJrn) {
		this.nombreJrn = nombreJrn;
	}

	@Column(name = "estado", length = 100)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
