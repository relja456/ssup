/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.ServerKontroler;

/**
 *
 * @author relja
 */
public class ServerskaNit extends Thread {

    ServerSocket serverSocket;
    boolean aktivan = true;

    public ServerskaNit() {
        try {
            serverSocket = new ServerSocket(9090);
        } catch (IOException ex) {
            Logger.getLogger(ServerskaNit.class.getName()).log(Level.SEVERE, null, ex);
        }

        start();
    }

    @Override
    public void run() {
        while (aktivan && !serverSocket.isClosed()) {
            try {
                Socket socket = serverSocket.accept();
                new KlijentskaNit(socket);
            } catch (IOException ex) {
                Logger.getLogger(ServerskaNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void stopServer() {
        aktivan = false;
        ServerKontroler.getInstance().izlogujSve();
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerskaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
