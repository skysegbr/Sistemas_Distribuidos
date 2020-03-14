package br.com.commun;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServiceRemoteImpl extends UnicastRemoteObject implements IServiceRemote {

    private static List<Person> lstPerson = new ArrayList<Person>();

    protected ServiceRemoteImpl() throws RemoteException {
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void insert(final Person p) throws RemoteException {
        lstPerson.add(p);
    }

    public List<Person> listPerson() throws RemoteException {
        return lstPerson;
    }

}