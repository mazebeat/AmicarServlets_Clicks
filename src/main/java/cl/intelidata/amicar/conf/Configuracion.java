package cl.intelidata.amicar.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Maze
 */
public class Configuracion {

	private Properties datos;
	private String nameFileConf;
	private static Configuracion conf = null;

	public static Logger logger = LoggerFactory.getLogger(Configuracion.class);

	/**
	 * 
	 * @return
	 */
	public static Configuracion getInstance() {
		if (conf == null) {
			try {
				String archConf = "/apps/Amicar/config/cotizanteAmicar.properties";

				if (!System.getProperty("file.separator").equals("/")) {
					archConf = System.getProperty("disco", "c:") + archConf;
				}

				conf = new Configuracion(archConf);

				logger.info("Leyendo archivo de configuracion: " + archConf);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
				return null;
			}
		}
		return conf;
	}

	private Configuracion(String nameFileConf) throws IOException {
		this.nameFileConf = nameFileConf;
		datos = new Properties();
		datos.load(new FileInputStream(nameFileConf));
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String getInitParameter(String name) {

		if (!datos.containsKey(name.toLowerCase())) {
			logger.error(
					"GRAVE Error en configuracion llave {} no definida en archivo {}",
					name, nameFileConf);
			return null;
		}
		String valor = datos.getProperty(name.toLowerCase());
		logger.debug("{}={}", name, valor);
		return valor;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void setInitParameter(String key, String value) {
		datos.put(key.toLowerCase(), value);

	}

	public static void configLog4() {
		Properties props = new Properties();
		try {			
			InputStream configStream = Configuracion.class.getResourceAsStream("/log4j.properties");
			props.load(configStream);
			configStream.close();
			props.setProperty("log4j.appender.LOG_FILE.file", Configuracion.getInstance().getInitParameter(
					"logs.path") + props.getProperty("log4j.appender.LOG_FILE.file"));
			LogManager.resetConfiguration();
			PropertyConfigurator.configure(props);
			logger.info("Logger config OK");

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

}