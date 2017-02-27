/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class MessageListener extends Thread {

    ServerSocket serverSocket;
    int port;

    //constructors
    public MessageListener() {
        try {
            serverSocket = new ServerSocket();
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //constructors
    public MessageListener(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket();
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        
        try {
            //initilize the Socket variable
            //socket is a connection to the port
            Socket clientSocket;
            
            //while loop that keeps on the accepting connection 
            //when it gets the connection it put it in the clientSocket variable
            //if the connection is null or close, we will leave the while-loop
            while((clientSocket = serverSocket.accept()) != null){
                
            }
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
