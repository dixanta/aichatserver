/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.aiserver.command;

import com.leapfrog.aiserver.util.Client;
import com.leapfrog.aiserver.util.ClientHandler;
import java.io.IOException;

/**
 *
 * @author USER
 */
public abstract class ChatCommand {
    protected ClientHandler handler;
    protected Client client;
    
    public void setHandler(ClientHandler handler){
        this.handler=handler;
    }
    
    public void setClient(Client client){
        this.client=client;
    }
    
    
    public abstract void execute(String[] tokens)throws IOException;
}
