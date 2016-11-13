/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.aiserver.util;

import com.leapfrog.aiserver.command.ChatCommand;
import com.leapfrog.aiserver.command.ChatCommandFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author USER
 */
public class ClientListener extends Thread {

    private Socket socket;
    private Client client;
    private ClientHandler handler;
    private BufferedReader reader;
    private PrintStream output;

    public ClientListener(Socket socket, ClientHandler handler) throws IOException {
        this.socket = socket;
        this.handler = handler;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                output.println("Welcome to the Server");
                login();
                //authentication code goes
                String line = "";
                output.println(">");
                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.split(";;");
                    output.println("you said >" + line);
                    ChatCommand cmd = ChatCommandFactory.get(tokens[0]);
                    if (cmd != null) {
                        cmd.setClient(client);
                        cmd.setHandler(handler);
                        cmd.execute(tokens);
                    } else {
                        broadcastMessage(client, client.getName() + "  says> " + line);
                    }
                }

            }
        } catch (IOException ioe) {

        }
    }

    private void broadcastMessage(Client client, String msg) throws IOException {
        for (Client c : handler.getClients()) {
            if (!c.equals(client)) {
                PrintStream ps = new PrintStream(c.getSocket().getOutputStream());
                ps.println(msg);
            }
        }
    }

    private void login() throws IOException {
        while (true) {
            output.println("Enter your Name");
            String name = reader.readLine();
            if (handler.getByName(name) == null) {
                client = new Client(name, socket);
                handler.addClient(client);
                break;
            }else{
                output.println(name + " is already exists please choose another name");
            }
        }
    }

}
