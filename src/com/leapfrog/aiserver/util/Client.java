/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.aiserver.util;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Client {
    private String name;
    private Socket socket;
    
    private boolean autoReply;
    private String replyMessage;
    

    private List<Client> blockList=new ArrayList<>();
    
    public Client() {
    }

    public Client(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public void block(Client client){
        blockList.add(client);
    }
    public void unblock(Client client){
        if(hasBlocked(client)){
            blockList.remove(client);
        }
    }
    public boolean hasBlocked(Client client){
        for(Client c: blockList){
            if(c.equals(client)){
                return true;
            }
        }
        return false;
    }
    
    public void setAutoReply(boolean activate,String reply){
        autoReply=activate;
        replyMessage=reply;
    }
    
    public boolean hasAutoReply(){
        return autoReply;
    }
    
    public String getReplyMessage(){
        return replyMessage;
    }
}
