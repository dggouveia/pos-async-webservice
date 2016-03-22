package br.edu.ifpb.pos.webservice.async.client;

import br.edu.ifpb.pos.webservice.async.server.productor.Productor;
import br.edu.ifpb.pos.webservice.async.server.productor.ProductorSingleton;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Loader {

    public static void main(String[] args) throws InterruptedException {
        Productor service = ProductorSingleton.getInstance();
        String id = service.registry();
        service.request(id, "Qualquer");
        while (true){
            Thread.sleep(100);
            String response = service.recover(id);
            if (response != null && !response.isEmpty()){
                System.out.println(response);
                break;
            }
            System.out.println("Sem resposta");
        }
    }
}
