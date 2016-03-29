package br.edu.ifpb.pos.webservice.async.server.channels;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class ResponseChannelSingleton {

    private static ResponseChannel instance = null;

    private ResponseChannelSingleton() {
    }

    public static ResponseChannel getInstance() {
        if (instance == null) {
            try {
                instance = retrieveInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * Metodo responsavel por recuperar a instancia do Web Service basico.
     */
    private static ResponseChannel retrieveInstance() throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:8080/responsechannel");
        QName qname = new QName("http://channels.server.async.webservice.pos.ifpb.edu.br/", "ResponseChannel");
        Service service = Service.create(url, qname);
        return service.getPort(ResponseChannel.class);
    }
    
}
