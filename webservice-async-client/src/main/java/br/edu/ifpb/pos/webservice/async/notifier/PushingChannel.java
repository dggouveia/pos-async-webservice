package br.edu.ifpb.pos.webservice.async.notifier;

import java.net.Socket;
import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 */
@WebService(name = "PushingChannel"
        , targetNamespace = "http://notifier.async.webservice.pos.ifpb.edu.br/")
public interface PushingChannel {
    
    public boolean subscribe (String id) throws RemoteException;
}
