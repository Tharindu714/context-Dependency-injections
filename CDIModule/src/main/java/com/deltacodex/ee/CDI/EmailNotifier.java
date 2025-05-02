package com.deltacodex.ee.CDI;

import com.deltacodex.ee.annotation.Email;
import com.deltacodex.ee.annotation.SMS;
import jakarta.enterprise.context.ApplicationScoped;
@Email
@ApplicationScoped
public class EmailNotifier implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email Notifier Sending Email... " + message);

    }
}
