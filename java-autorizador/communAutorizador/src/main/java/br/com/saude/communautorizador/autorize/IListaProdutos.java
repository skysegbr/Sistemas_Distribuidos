
package br.com.saude.communautorizador.autorize;


import br.com.saude.apiautorizador.entity.Produto;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Danilo Segura
 */

public interface IListaProdutos extends Remote {
    public Produto listarProduto(String ean) throws RemoteException;
    public List<Produto> listarProdutos(String nome) throws RemoteException;
}
