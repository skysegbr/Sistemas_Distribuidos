package br.com.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import br.com.commun.ServiceRemoteImpl;

/**
 * Rmi Server
 *
 */
public class Service {

    public Service() throws RemoteException {
        try {

            LocateRegistry.createRegistry(8282);
            System.out.println("Inicio");
            Naming.rebind("rmi://localhost:8282/pessoa", new RemotServiceImpl());
            System.out.println("Fim");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws RemoteException {

        System.out.println("new Services");
        new Service();
    }
}
