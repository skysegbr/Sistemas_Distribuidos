package br.com.clientrmi;

import java.rmi.Naming;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.chatutil.IChat;
import br.com.chatutil.Message;


public class App {

    private static String returnMessage(List<Message> list){
        String valor = "";
        for(Message message : list){
            valor += message.getUser() + ": " + message.getMessage() + "\n";
        }
        return valor;
    }
    public static void main( String[] args ) {

        String nome = "";
        String msgp = "";

        nome = JOptionPane.showInputDialog("Bem vindo ao Chat, Qual é seu nome?");

        try {
            while (!"0".equals(msgp)) {
                msgp = JOptionPane.showInputDialog("Chat - " + nome + " Entre com a mensagem. (0 para sair)");
                IChat chat = (IChat) Naming.lookup("rmi://localhost:8282/chat");
                Message msg = new Message(nome, msgp);
                chat.sendMessage(msg);
                //System.out.println(msgp);
                System.out.println(returnMessage(chat.retriveMessage()));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }




    }
}
