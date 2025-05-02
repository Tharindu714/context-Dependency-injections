package com.deltacodex.ee.ejb;

import com.deltacodex.ee.CDI.NotificationService;
import com.deltacodex.ee.annotation.Console;
import com.deltacodex.ee.annotation.Email;
import com.deltacodex.ee.ejb.remote.UserRegistration;
//import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
//import java.rmi.RemoteException;

@Stateless
public class UserRegistrationSessionBean implements UserRegistration {
    @Inject
    @Email
    private NotificationService notificationService;

    @Inject
    @Console
    //If this annotation put it shows every logger,
    // But If You didn't put, Logger with @Console is not showing
    private Event<String> LogEvent;

    @Override
    public void Register(String firstName, String lastName, String email, String password) {
        notificationService.sendNotification("New Email Sent! " + firstName + " " + lastName + " " + email);


        LogEvent.fire("New Email Sent! " + email);
    }
}
