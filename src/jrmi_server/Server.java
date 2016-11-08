/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrmi_server;

import jrmi.MyRemoteImp;
import jrmi.MyRemote;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author diogo
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.err.println("\nRemote Server");
        Registry registry;
        try {
            MyRemoteImp mrsrv = new MyRemoteImp("noname");
            MyRemote stub
                    = (MyRemote) UnicastRemoteObject.exportObject(mrsrv, 0);
            // Locate Registry & Bind object's stub in the registry
            registry = LocateRegistry.getRegistry();
            // parametro opcional: int porto
            registry.bind("MyRemoteSrv", stub);
            System.err.println("Object bound name \"MyRemoteSrv\"");
        } catch (Exception e) {
            System.err.println("---> " + e.toString());
            e.printStackTrace();
            return;
        }
        System.out.println("\n -- Working --: sair to stop\n");
        while (true) {
            Scanner sc = new Scanner(System.in);
            if (sc.nextLine().compareToIgnoreCase("sair") == 0) {
                break;
            }
        }
        try {
            registry.unbind("MyRemoteSrv");
        } catch (RemoteException | NotBoundException e) {
            System.err.println("---> " + e.toString());
        }
        System.out.println("\nObject \"unbounded\"");
        System.exit(1); // p/ encerra a worker thread
    }


}
