package zNOTINUSE;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ClientChat;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Menja
// */
//public class Client {
//
//    //GUI
//    private GuiClient guiClient;
//
//    //Server
//    private String server;
//    private String host;
//    private int port;
//
//
//    public static void main(String[] args) {
//        try {
//            //Input (to read from the socket) and Output (to write from the socket)
//            Socket socket = new Socket();
//            socket.connect(new InetSocketAddress("127.0.0.1", 8081));
//
//            
//            //DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//            //DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//
//            //send messages to the server (flush slås automatisk til med true)
//            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
//
//            //recieve messages from the server
//            Scanner scanner = new Scanner(socket.getInputStream());
//
//            //messages
//            String messageInput = "";
//            String messageOutput = "";
//
//            printWriter.println("LOGIN#Menja");
//            printWriter.println("MSG#Menja#Hej");
//
//            while (!messageInput.equals("end")) {
//                messageOutput = scanner.nextLine();
//                printWriter.println(messageOutput);
//
//                messageInput = dataInputStream.readUTF();
//                System.out.println(messageInput);
//            }
//
//        } catch (IOException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     *
//     */
//    public void login() {
//
//    }
//
//    /**
//     *
//     */
//    public void sendMessage() {
//
//    }
//
//    /**
//     *
//     */
//    public void recieveMessage() {
//
//    }
//
//
//}
//
////    /**
////     * Consol constructor called by consol mode In this mode the GUI is set to
////     * null
////     *
////     * @param server
////     * @param host
////     * @param port
////     */
////    public Client(String server, String host, int port) {
////        this(server, host, port, null);
////    }
////
////    /**
////     * GUI constructor called by GUI mode
////     *
////     * @param server: the address of the server
////     * @param host
////     * @param port: the port number on the server
////     * @param guiClient:
////     */
////    public Client(String server, String host, int port, GuiClient guiClient) {
////
////        this.server = server;
////        this.host = host;
////        this.port = port;
////        this.guiClient = guiClient;
////    }
//
////    //Start and connect to the server
////    public boolean start() {
////
////        //connect to server
////        try {
////            socket = new Socket(server, port);
////        } catch (IOException ex) {
////            //if the connection fail
////            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
////            System.out.println("Connection failed");
////            return false;
////        }
////        //If the connection succeeded
////        String serverConnected = "Connection succeeded " + "\n" + socket.getInetAddress() + ": " + socket.getPort();
////        System.out.println(serverConnected);
////
////        try {
////            //creates the data streams for both Input-Objects
////            messageInput = new DataInputStream(socket.getInputStream());
////            messageOutput = new DataOutputStream(socket.getOutputStream());
////        } catch (IOException ex) {
////            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
////            //Creating new input or output streams failed
////            System.out.println("Creating new input or output streams failed " + ex);
////            return false;
////        }
////
////        return true;
////    }
////class ListenFromServer extends Thread {
////
////    @Override
////    public void run() {
////        try {
////            String message = (String) messageInput.readObject();
////
////            //If it is the console mode this is running
////            if (guiClient == null) {
////                System.out.println(message);
////            } //If it is the GUI mode
////            //OBS!!!!!! Append findes ikke i denne sammenhæng
////            else {
////                guiClient.add(message, guiClient);
////            }
////        } catch (IOException | ClassNotFoundException ex) {
////            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
////        }
////    }
////}
