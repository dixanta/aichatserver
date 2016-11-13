/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.aiserver.command;

import com.leapfrog.aiserver.common.util.HttpClient;
import com.leapfrog.aiserver.util.Client;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author USER
 */
public class WebCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws IOException {
        
            PrintStream ps=new PrintStream(client.getSocket().getOutputStream());
            ps.println("Browsing " + tokens[1] + " in the web please wait...\r\n");
            HttpClient http=new HttpClient();
            String data=http.get(tokens[1]);
            ps.println(data);
        
    }
    
}
