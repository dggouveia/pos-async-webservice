package br.edu.ifpb.pos.webservice.async.server.channels;

import br.edu.ifpb.pos.webservice.async.server.processor.Processor;
import javax.jws.Oneway;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "br.edu.ifpb.pos.webservice.async.server.channels.RequestChannel", serviceName = "RequestChannel")
public class RequestChannel {

    private Processor processor = Processor.getInstance();
    
    @Oneway
    public void request (String id, String menssage){
        processor.requestProcess(id, menssage);
    }
    
}
