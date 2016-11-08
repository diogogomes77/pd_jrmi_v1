package jrmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import jrmi.MyRemote;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author diogo
 */
public class MyRemoteImp implements MyRemote{

    private String msg;

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public void setMessage(String s) {
        msg = s;
    }

    public MyRemoteImp(String s) {
        msg = s;
    } //

    public MyRemoteImp() {
        msg = "default";
    }
}