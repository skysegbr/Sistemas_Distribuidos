package br.com.commun;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServiceRemote extends Remote {
    void insert(Person p) throws RemoteException;

    List<Person> listPerson() throws RemoteException;

}