package br.edu.ifpb.pos.webservice.async.client;

import br.edu.ifpb.pos.webservice.async.notifier.PushingChannelSingleton;
import br.edu.ifpb.pos.webservice.async.server.channels.RequestChannelSingleton;
import br.edu.ifpb.pos.webservice.async.server.channels.ResponseChannelSingleton;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Loader {

    public static void main(String[] args) throws InterruptedException, RemoteException, IOException {
        System.out.println("Requisitando:");
        RequestChannelSingleton.getInstance().request("xablau", "xablau");
        System.out.println("Escutando resposta:");
        PushingChannelSingleton.getInstance().subscribe("xablau");
        System.out.println("Requisitando resposta:");
        System.out.println(ResponseChannelSingleton.getInstance().getResponse("xablau"));
    }
}
