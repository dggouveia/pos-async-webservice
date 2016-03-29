package br.edu.ifpb.pos.webservice.async.client;

import br.edu.ifpb.pos.webservice.async.notifier.PushingChannelSingleton;
import br.edu.ifpb.pos.webservice.async.server.channels.RequestChannelSingleton;
import br.edu.ifpb.pos.webservice.async.server.channels.ResponseChannelSingleton;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Loader {

    public static void main(String[] args) throws InterruptedException, RemoteException, IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe a mensagem que deseja processar:");
        String msg = in.nextLine();
        System.out.println("Informe sua senha:");
        String senha = in.nextLine();
        System.out.println("Requisitando o processamento da mensagem:");
        RequestChannelSingleton.getInstance().request(senha, msg);
        System.out.println("Esperando resposta:");
        PushingChannelSingleton.getInstance().subscribe(senha);
        System.out.println("Requisitando resposta:");
        System.out.println(ResponseChannelSingleton.getInstance().getResponse(senha));
    }
}
