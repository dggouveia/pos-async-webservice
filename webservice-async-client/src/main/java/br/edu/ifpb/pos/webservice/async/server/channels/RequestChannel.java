package br.edu.ifpb.pos.webservice.async.server.channels;

import javax.jws.Oneway;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 */
@WebService(name = "RequestChannel"
        , targetNamespace = "http://channels.server.async.webservice.pos.ifpb.edu.br/")
public interface RequestChannel {
    
    @Oneway
    public void request (String id, String menssage);
    
}
