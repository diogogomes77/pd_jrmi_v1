/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author diogo
 */
public interface MyRemote extends Remote{
    String getMessage() throws RemoteException;
    void setMessage(String s) throws RemoteException;
}
