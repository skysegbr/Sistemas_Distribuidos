package br.com.chatutil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message implements Serializable{

    private static final long serialVersionUID = 1L;
    private String user;
    private String message;

    private static List<Message> listMessage = new ArrayList<Message>();

    public static List<Message> getListMessage(){
        return listMessage;
    }
    
    public static void setListMessage(Message msg){
        listMessage.add(msg);
    }

    // public Message(String user, String message){
    // this.user = user;
    // this.message = message;
    // }

}