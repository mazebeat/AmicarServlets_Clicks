package cl.intelidata.amicar.util;

import static cl.intelidata.amicar.conf.Configuracion.logger;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.intelidata.amicar.conf.Configuracion;
import cl.intelidata.amicar.db.Proceso;

public class Tools {

    public static final Logger LOGGER = Logger.getLogger(Tools.class.getName());

    public static Timestamp nowDate() {
        logger.info("GET DATE");
        Date fecha = new Date();
        Timestamp time = new Timestamp(fecha.getTime());

        return time;
    }

    /**
     *
     * @param urlBase
     * @param params
     * @return
     */
    public static String fullURL(String urlBase, HashMap<String, String> params) {
        logger.info("CREATE URL TO ", urlBase);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String param = entry.getKey() + "=" + entry.getValue() + "&amp;";
            urlBase = urlBase.concat(param);
        }

        if (urlBase.endsWith("&amp;")) {
            urlBase = urlBase.substring(0, urlBase.length() - 1);
        }

        return urlBase;
    }

    /**
     *
     * @param request
     * @param response
     * @param opt
     */
    public static void redirect(HttpServletRequest request, HttpServletResponse response, char opt) {
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
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY); // SC_MOVED_TEMPORARILY | SC_MOVED_PERMANENTLY
        response.setHeader("Location", site);
    }

    /**
     *
     * @param proceso
     */
    public static void mailEjecutivo(Proceso proceso) {
        try {
            Archivo archivo = new Archivo(Configuracion.getInstance().getInitParameter("salidamailejecutivo"), Configuracion.getInstance().getInitParameter("salidamailejecutivo"));
            List<String> mail = new ArrayList<String>();
            List<String> list = new ArrayList<String>();

            list.add(Texto.LLAVE_INICIO);
            list.add(proceso.getEjecutivos().getCorreoEjecutivo());
            list.add(proceso.getClientes().getRutCliente());
            list.add(proceso.getEjecutivos().getLocales().getNombreLocal());
            list.add(proceso.getClientes().getEmailCliente());
            list.add(proceso.getVendedores().getNombreVendedor());
            list.add(proceso.getFechaClickLink().toString());
            list.add(proceso.getClientes().getNombreCliente());
            list.add(proceso.getClientes().getMarcaVehiculo());
            list.add(proceso.getClientes().getModeloVehiculo());
            list.add(proceso.getClientes().getValorVehiculo());

            String line = formatLine(list);
            mail.add(line);
            
            archivo.guardarLista(mail, "Ejecutivos", "txt");

            logger.info("Mail id: " + proceso.getIdProceso() + " cliente id: " + proceso.getClientes().getRutCliente() + " ejecutivo id: " + proceso.getEjecutivos().getIdEjecutivo() + "  vendedor id: " + proceso.getVendedores().getIdVendedor() + " fecha envio: " + proceso.getFechaEnvio() + " fecha click: " + proceso.getFechaClickLink());
        } catch (Exception e) {
            logger.error("Error al generar la data para email.", e.getMessage());
        }
    }

    private static String formatLine(List<String> list) {
        String line = "";

        for (String l : list) {
            line = line.concat(l).concat("|");
        }

        return line;
    }
}
