package br.edu.ifpb.pos.webservice.async.notifier;

import java.io.IOException;
import javax.xml.ws.Endpoint;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Loader {

    public static void main(String[] args) throws IOException {
        PushingChannel pushingChannel = new PushingChannel();
        Endpoint.publish("http://localhost:9001/notifier", new NotifyChannel(pushingChannel));
        Endpoint.publish("http://localhost:9001/subscriber", pushingChannel);
    }
    
}
