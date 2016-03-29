package br.edu.ifpb.pos.webservice.async.notifier.Notifier;

import javax.jws.Oneway;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 */
@WebService(name = "NotifyChannel"
        , targetNamespace = "http://notifier.async.webservice.pos.ifpb.edu.br/")
public interface Notifier {
    
    @Oneway
    public void notify(String idUser);
}
