package com.deltacodex.ee.CDI;

import com.deltacodex.ee.annotation.SMS;
import jakarta.enterprise.context.ApplicationScoped;
@SMS
@ApplicationScoped
public class SMSNotifier implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Notifier Sending SMS... " + message);
    }
}
