package com.grudiy.chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {

    public static void main(String[] args) {
        Socket clientSocket = null;
        System.out.println("Client started...");

        try {
            clientSocket = new Socket("localhost", 9090);
            System.out.println("Connected to server.");
            System.out.println("Enter your message (type Q to quit):");

//            InputStream is = System.in; //read input from console // long form
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(System.in));
            String str = input.readLine();

            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true); //write to socket
            while (str != null) {
                if (str.equalsIgnoreCase("q")) {
                    System.out.println("Quit.");
                    break;
                }
                output.println(str);
                str = input.readLine();
            }

            input.close();
            output.close();
            clientSocket.close();
        }
        catch (Exception e) {
            System.out.println("Closed connection to Server");
        }

    }
}
