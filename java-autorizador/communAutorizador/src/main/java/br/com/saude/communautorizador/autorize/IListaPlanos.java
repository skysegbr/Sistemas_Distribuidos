
package br.com.saude.communautorizador.autorize;

import br.com.saude.apiautorizador.entity.PlanoSaude;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Danilo Segura
 */
public interface IListaPlanos extends Remote {
    public List<PlanoSaude> listarPlanos(String nome) throws RemoteException;
}
