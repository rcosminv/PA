package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.SecureRandom;


class ClientThread extends Thread {
        private Socket socket = null ;
        private ServerSocket serverul=null;
        public ClientThread (Socket socket, ServerSocket serverul) { this.socket = socket ;this.serverul=serverul; }
        public void run () {
            try {
                // Get the request from the input stream: client → server
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                // Send the response to the oputput stream: server → client

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                while(true) {
                    String request = in.readLine();
                    if(request.equals("stop"))
                    {
                        out.println("Server Stoped");
                        out.flush();
                        serverul.close();
                        break;
                    }
                    if(request.equals("exit"))
                    {
                        out.println("Server Exit");
                        out.flush();
                        socket.close();
                        break;
                    }
                    String raspuns = "Hello " + request + "!";
                    out.println(raspuns);
                    out.flush();
                }
            } catch (IOException e) {
                System.err.println("Communication error... " + e);
            } finally {
                try {
                    socket.close(); // or use try-with-resources
                } catch (IOException e) { System.err.println (e); }
            }
        }
    }


