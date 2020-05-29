package br.com.saude.communautorizador.autorize;


import br.com.saude.apiautorizador.entity.Transacao;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Danilo Segura
 */

public interface IAutorize extends Remote{
    public void preparaAutorizacao(Transacao transacao) throws RemoteException;
}
