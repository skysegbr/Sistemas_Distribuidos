package br.com.chatutil;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChat extends Remote {
    void sendMessage(Message msg) throws RemoteException;
    List<Message> retriveMessage() throws RemoteException;
}