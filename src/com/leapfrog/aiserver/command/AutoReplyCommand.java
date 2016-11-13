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
public class AutoReplyCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws IOException {
        if (tokens.length > 1) {
            client.setAutoReply(true,tokens[1]);
            PrintStream ps = new PrintStream(client.getSocket().getOutputStream());
            ps.println("Auto Reply set up successful");
        } else {
            //else code goes here
        }
    }
}
