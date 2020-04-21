package br.com.serverrmi.util;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Chat extends UnicastRemoteObject implements IChat {

    public Chat() throws RemoteException {
        super();
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void sendMessage(Message msg) throws RemoteException {
        Message.setListMessage(msg);

    }

    @Override
    public List<Message> retriveMessage() throws RemoteException {
        return Message.getListMessage();
    }

}