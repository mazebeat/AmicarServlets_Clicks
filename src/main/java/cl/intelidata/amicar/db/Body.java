package cl.intelidata.amicar.db;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Body entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "body", catalog = "amicarcotizante2")
public class Body extends AbstractBody implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Body() {
	}

	/** minimal constructor */
	public Body(Integer idBody) {
		super(idBody);
	}

	/** full constructor */
	public Body(Integer idBody, String bodyNombre) {
		super(idBody, bodyNombre);
	}

}
