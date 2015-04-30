package cl.intelidata.amicar.db;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Locales entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "locales", catalog = "amicarcotizante2")
public class Locales extends AbstractLocales implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Locales() {
	}

	/** full constructor */
	public Locales(String nombreLocal, Set<Vendedores> vendedoreses, Set<Ejecutivos> ejecutivoses) {
		super(nombreLocal, vendedoreses, ejecutivoses);
	}

}
