package com.deltacodex.ee.CDI;

import com.deltacodex.ee.annotation.Console;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class Logger {
    public void log(@Observes String message) {
        System.out.println("Logged :"+message);
    }

    public void logText(@Observes @Console String message) {
        System.out.println("Text Logged :"+message);
    }
}
