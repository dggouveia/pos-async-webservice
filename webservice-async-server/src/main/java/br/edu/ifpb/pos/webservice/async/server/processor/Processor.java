package br.edu.ifpb.pos.webservice.async.server.processor;

import br.edu.ifpb.pos.webservice.async.server.repository.Repository;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Processor {

    private Map<String, String> toProcess;
    private Queue<String> queue;
    private Repository repository;
    private Thread thread;
    private static Processor instance;

    private Processor() {
        this.toProcess = new HashMap<>();
        this.repository = Repository.getInstance();
        this.queue = new LinkedList<>();
    }

    public static Processor getInstance() {
        if (instance == null) {
            instance = new Processor();
        }
        return instance;
    }

    public void requestProcess(String id, String message) {
//        Thread.sleep(10000);
        toProcess.put(id, message);
        queue.add(id);
        if (thread == null) {
            thread = new ProcessThread();
            thread.start();
        }
    }

    private class ProcessThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    // caso a fila esteja vazia, esperar
                    while (queue.size() == 0) {
                        this.sleep(1000);
                    }
                    String id = queue.poll();
                    String message = toProcess.get(id);
                    message = "Message processed: " + message;
                    long time = Math.round(Math.random() * 10000);
                    System.out.println(time);
                    this.sleep(time);
                    toProcess.remove(id);
                    repository.addResponse(id, message);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
