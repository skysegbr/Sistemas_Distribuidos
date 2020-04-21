package br.com.serverrmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import br.com.serverrmi.util.Chat;

public class ChatServer {

    public ChatServer() {
        try {
            LocateRegistry.createRegistry(8282);
            Naming.rebind("rmi://localhost:8282/chat", new Chat());
            System.out.println("Rodando");

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }

}