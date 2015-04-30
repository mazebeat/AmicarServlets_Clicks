package cl.intelidata.amicar.db;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Vendedores entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "vendedores", catalog = "amicarcotizante2")
public class Vendedores extends AbstractVendedores implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Vendedores() {
	}

	/** minimal constructor */
	public Vendedores(Locales locales) {
		super(locales);
	}

	/** full constructor */
	public Vendedores(Locales locales, String rutVendedor, String nombreVendedor, Set<Proceso> procesos) {
		super(locales, rutVendedor, nombreVendedor, procesos);
	}

}
