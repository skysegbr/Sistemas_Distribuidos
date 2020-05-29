
package br.com.saude.apiautorizador.controler;


import br.com.saude.apiautorizador.repository.Autorize;
import br.com.saude.apiautorizador.repository.ListaProdutos;
import br.com.saude.apiautorizador.repository.ListarPlanos;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Danilo Segura
 */
public class ApiAutorizacao {
    public ApiAutorizacao() throws MalformedURLException{

        try {
            LocateRegistry.createRegistry(8282);
            
            Naming.rebind("rmi://localhost:8282/autorize", new Autorize());
            Naming.rebind("rmi://localhost:8282/listaProdutos", new ListaProdutos());
            Naming.rebind("rmi://localhost:8282/listaPlanos", new ListarPlanos());
            System.out.println("Rodando");

        } catch (final RemoteException e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) throws MalformedURLException {
        new ApiAutorizacao();
    }
    
}
