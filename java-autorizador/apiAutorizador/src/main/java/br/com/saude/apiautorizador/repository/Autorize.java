package br.com.saude.apiautorizador.repository;

import br.com.saude.apiautorizador.entity.Transacao;
import br.com.saude.communautorizador.autorize.IAutorize;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Danilo Segura
 */

public class Autorize extends UnicastRemoteObject implements IAutorize{
    public Autorize() throws RemoteException {
        super();
    }
    
    @Override
    public void preparaAutorizacao(Transacao transacao) throws RemoteException {
        System.out.println(transacao.getProduto());
        System.out.println("Teste");
    }
 }
