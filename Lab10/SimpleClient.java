package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {
            public static void main (String[] args) throws IOException {
                String serverAddress = "127.0.0.1"; // The server's IP address
                int PORT = 8100; // The server's port
                try (
                        Socket socket = new Socket(serverAddress, PORT);
                        PrintWriter out =
                                new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader (
                                new InputStreamReader(socket.getInputStream())) ) {
                    // Send a request to the server
                    while(true) {
                        Scanner mesaj =new Scanner(System.in);
                    String request = mesaj.nextLine();

                    // Wait the response from the server ("Hello World!")
                        if(request.equals("stop"))
                        {   out.println(request);
                            String response = in.readLine();
                            System.out.println(response);
                            socket.close();
                            break;
                        }
                        if(request.equals("exit"))
                        {   out.println(request);
                            String response = in.readLine();
                            System.out.println(response);
                            socket.close();
                            break;
                        }out.println(request);
                        String response = in.readLine();
                        System.out.println(response);



                    }
                } catch (UnknownHostException e) {
                    System.err.println("No server listening... " + e);
                }
            }
        }
