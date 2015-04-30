package cl.intelidata.amicar.db;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ejecutivos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ejecutivos", catalog = "amicarcotizante2")
public class Ejecutivos extends AbstractEjecutivos implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Ejecutivos() {
	}

	/** minimal constructor */
	public Ejecutivos(Locales locales) {
		super(locales);
	}

	/** full constructor */
	public Ejecutivos(Locales locales, String rutEjecutivo, String nombreEjecutivo, String correoEjecutivo, Timestamp fechaIngreso, String fechaModificacion, Set<Proceso> procesos) {
		super(locales, rutEjecutivo, nombreEjecutivo, correoEjecutivo, fechaIngreso, fechaModificacion, procesos);
	}

}
