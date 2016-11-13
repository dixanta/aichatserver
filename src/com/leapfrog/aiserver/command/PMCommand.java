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
public class PMCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws IOException {
        if (tokens.length > 2) {
            Client friend = handler.getByName(tokens[1]);
            if (friend != null) {
                if (!friend.hasBlocked(client)) {
                    PrintStream ps = new PrintStream(friend.getSocket().getOutputStream());
                    ps.println(tokens[2]);
                    ps.flush();
                    if(friend.hasAutoReply()){
                        PrintStream psme=new PrintStream(client.getSocket().getOutputStream());
                        psme.println(friend.getReplyMessage());
                        psme.flush();
                    }
                }
            } else {
                //else code goes here
            }
        }
    }

}
