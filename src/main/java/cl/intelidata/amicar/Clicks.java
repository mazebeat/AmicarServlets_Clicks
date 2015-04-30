package cl.intelidata.amicar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.intelidata.amicar.conf.Configuracion;
import cl.intelidata.amicar.db.Proceso;
import cl.intelidata.amicar.util.DB;
import cl.intelidata.amicar.util.Texto;
import cl.intelidata.amicar.util.Tools;
import cl.intelidata.amicar.util.Validator;

public class Clicks extends HttpServlet {

	public static Logger	  logger	            = LoggerFactory.getLogger(Clicks.class);
	private static final long	serialVersionUID	= 1L;

	/**
	 * Constructor of the object.
	 */
	public Clicks() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.processRequest(request, response);
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		// out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		// out.println("<HTML>");
		// out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		// out.println("  <BODY>");
		// out.print("    This is ");
		// out.print(this.getClass());
		// out.println(", using the GET method");
		// out.println("  </BODY>");
		// out.println("</HTML>");
		// out.flush();
		// out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuracion.configLog4();

		Proceso proceso = null;
		Validator val = new Validator();
		DB db = new DB();
		char opt = 'A';

		logger.info("INIT PROCESS");
		try {
			String cotiz = request.getParameter(Texto.COTIZACION);
			String cli = request.getParameter(Texto.CLIENTE);

			logger.info("VALIDATE INPUTS");
			if (val.validateInputs(cli, cotiz)) {
				cotiz = val.desencryptInput(cotiz);
				logger.info("GET PROCESO");
				proceso = db.getProceso(Integer.parseInt(cotiz));

				if (proceso != null) {					
					if (proceso.getFechaClickLink() == null) {
						db.actualizarProceso(proceso, 'c');

						logger.info("GENERATE MAIL FILE TO EJECUTIVO");
						Tools.mailEjecutivo(proceso);
						logger.info("REGISTER PROCESS: " + request.getParameter(Texto.CLIENTE) + " | " + request.getParameter(Texto.COTIZACION));
					} else {
						logger.info("COTIZACION YA REALIZADA", proceso.getIdProceso());
					}
					opt = 'L';
				} else {
					logger.info("ERROR BD: NOT FOUND PROCESO", proceso);
				}
			} else {
				logger.error("ERROR: URL PARAMS NOT VALID");
			}
		} catch (Exception ex) {
			logger.error("ERROR PROCESS FAILED", ex);
		} finally {
			logger.info("FINISH PROCESS");

			logger.info("REDIRECTO TO ANOTHER PAGE");
			String site = Texto.AMICAR_URL;

			if (opt == 'L') {
				try {
					logger.info("Obteniendo URL Landing desde archivo properties");
					site = Configuracion.getInstance().getInitParameter("dominioLanding");

					if (!site.trim().endsWith("?")) {
						site = site.trim().concat("?");
					}

					if (request.getQueryString() != null) {
						logger.info("Redireccionando hacia Landing");
						site = site.concat(request.getQueryString());
					} else {
						logger.warn("Parametros nulos cambiando URL hacia Amicar");
					}
				} catch (Exception ex) {
					logger.error("Error: " + ex.getMessage() + " {}", ex);
				}
			}

			logger.info("Redireccionando a {}", site);
			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY); // SC_MOVED_TEMPORARILY
			                                                              // |
			                                                              // SC_MOVED_PERMANENTLY
			response.setHeader("Location", site);
		}
	}

}
