/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.aiserver.command;

import com.leapfrog.aiserver.util.Client;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author USER
 */
public class ListCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws IOException {
        
            StringBuffer buffer=new StringBuffer();
            buffer.append("Printing FriendList\r\n==================\r\n");
            for(Client c:handler.getClients()){
                if(!c.hasBlocked(client)){
                buffer.append(c.getName()).append("\r\n");
                }
            }
            PrintStream ps=new PrintStream(client.getSocket().getOutputStream());
            ps.println(buffer.toString());
        
    }
    
}
