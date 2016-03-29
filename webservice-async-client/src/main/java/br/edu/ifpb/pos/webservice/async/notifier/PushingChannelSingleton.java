package br.edu.ifpb.pos.webservice.async.notifier;

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
public class PushingChannelSingleton {
    
private static PushingChannel subscriber = null;

    private PushingChannelSingleton() {
    }

    public static PushingChannel getInstance() {
        if (subscriber == null) {
            try {
                subscriber = retrieveSubscriber();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return subscriber;
    }

    /**
     * Metodo responsavel por recuperar a instancia do Web Service basico.
     */
    private static PushingChannel retrieveSubscriber() throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:9001/subscriber");
        QName qname = new QName("http://notifier.async.webservice.pos.ifpb.edu.br/", "PushingChannel");
        Service service = Service.create(url, qname);
        return service.getPort(PushingChannel.class);
    }

    
}
