package br.edu.ifpb.pos.webservice.async.server;

import br.edu.ifpb.pos.webservice.async.server.channels.RequestChannel;
import br.edu.ifpb.pos.webservice.async.server.channels.ResponseChannel;
import javax.xml.ws.Endpoint;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Loader {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/responsechannel", new ResponseChannel());
        Endpoint.publish("http://localhost:8080/requestchannel", new RequestChannel());
    }
}
