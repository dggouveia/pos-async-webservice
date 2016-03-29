package br.edu.ifpb.pos.webservice.async.notifier;

import javax.jws.Oneway;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "br.edu.ifpb.pos.webservice.async.notifier.NotifyChannel", serviceName = "NotifyChannel")
public class NotifyChannel{   

    private NotifyListener listener;
    
    public NotifyChannel(NotifyListener listener){
        this.listener = listener;
    }
    
    @Oneway
    public void notify(String idUser) {
        listener.notify(idUser);
    }   

//    public static void enableSubscribe() throws IOException {
//        ServerSocket server = new ServerSocket(9000);
//        while (true) {
//            Socket client = server.accept();
//            String idUser = new BufferedReader(new InputStreamReader(client.getInputStream())).readLine();
//            toNofify.put(idUser, new PrintWriter(client.getOutputStream(), true));
//        }
//    }

}
