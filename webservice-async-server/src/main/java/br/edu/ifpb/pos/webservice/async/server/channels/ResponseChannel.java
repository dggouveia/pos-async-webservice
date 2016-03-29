package br.edu.ifpb.pos.webservice.async.server.channels;

import br.edu.ifpb.pos.webservice.async.server.repository.Repository;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "br.edu.ifpb.pos.webservice.async.server.channels.ResponseChannel", serviceName = "ResponseChannel")
public class ResponseChannel {

    private Repository repository = Repository.getInstance();
    
    public String getResponse (String id){        
        return repository.getResponse(id);
    }
    
}
