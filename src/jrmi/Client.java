package jrmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author diogo
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String host = (args.length < 1) ? null : args[0];
      try {
         Registry registry = LocateRegistry.getRegistry(host);
         MyRemote mrstub = (MyRemote) registry.lookup("MyRemoteSrv");
         String s = mrstub.getMessage();
         System.out.println("\nMsg currently in the object: " + s);
         System.out.print("Write new msg -> ");
         s = sc.nextLine();
         mrstub.setMessage(s);
         System.out.println("Msg currently in the object: " + s);


        } catch (Exception e) {
            System.err.println("Client exception:\n" + e.toString());
            e.printStackTrace();
        }
    }
}