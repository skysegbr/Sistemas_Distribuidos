package br.com.clientrmi;

import java.rmi.Naming;

import javax.swing.JOptionPane;


public class App {
    public static void main( String[] args ) {

        String nome = "";
        String msgp = "";

        nome = JOptionPane.showInputDialog("Bem vindo ao Chat, Qual é seu nome?");

        try {
            while (msgp != "0") {
                msgp = JOptionPane.showInputDialog("Chat - " + nome + " Entre com a mensagem. (0 para sair)");
                IChat chat = (IChat) Naming.lookup("rmi://localhost:8282/chat");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }




    }
}
