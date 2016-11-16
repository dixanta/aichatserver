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
public class ClientHandler {
    List<Client> clients=new ArrayList<>();
    
    public void addClient(Client client){
        clients.add(client);
    }
    
    public boolean removeClient(String name){
        Client client=getByName(name);
        if(client!=null){
            clients.remove(client);
            return true;
        }
        return false;
    }
    
    public List<Client> getClients(){
        return clients;
    }
    
    public Client getByName(String name){
        for(Client c: clients){
            if(c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }
        return null;
    }
    
    public Client getBySocket(Socket socket){
        for(Client c: clients){
            if(c.getSocket().equals(socket)){
                return c;
            }
        }
        return null;
    }
}
