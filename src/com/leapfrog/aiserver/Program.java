/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.aiserver;

import com.leapfrog.aiserver.util.ClientHandler;
import com.leapfrog.aiserver.util.ClientListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author USER
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        int port=9000;
        try{
            ServerSocket server=new ServerSocket(port);
            System.out.println("Server is running at " + port);
            ClientHandler handler=new ClientHandler();
            while(true){
                Socket socket=server.accept();
                System.out.println("Got Connection from " + socket.getInetAddress().getHostAddress());
                ClientListener listener=new ClientListener(socket,handler);
                listener.start();
            }
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    
}
