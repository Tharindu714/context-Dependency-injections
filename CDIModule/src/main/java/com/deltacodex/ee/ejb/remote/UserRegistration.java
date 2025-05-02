package com.deltacodex.ee.ejb.remote;

import jakarta.ejb.Remote;
import java.rmi.RemoteException;

@Remote
public interface UserRegistration {
    void Register(String firstName, String lastName, String email, String password)throws RemoteException;
}
