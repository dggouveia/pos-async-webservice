package br.edu.ifpb.pos.webservice.async.server.channels;

import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(name = "ResponseChannel"
        , targetNamespace = "http://channels.server.async.webservice.pos.ifpb.edu.br/")
public interface ResponseChannel {

    public String getResponse (String id);
    
}
