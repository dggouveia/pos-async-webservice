package br.edu.ifpb.pos.webservice.async.notifier;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "br.edu.ifpb.pos.webservice.async.notifier.PushingChannel"
        , serviceName = "PushingChannel")
public class PushingChannel implements NotifyListener{

    private static Set<String> toNotify = new HashSet<>();
    
    public boolean subscribe (String id) {
        while (!toNotify.contains(id)){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PushingChannel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        toNotify.remove(id);
        return true;
    }

    @Override
    public void notify(String id) {
        toNotify.add(id);
    }
    
}
