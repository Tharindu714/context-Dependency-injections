package com.deltacodex.ee.CDI;

//import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

//@ApplicationScoped
//public class Service {
//  public void sayHello() {
//      System.out.println("Hello World"+ this); //Hello Worldcom.deltacodex.ee.CDI.Service@5a2025df]]
//  }
//}  //--> Same Objects shows everytime

@RequestScoped
public class Service {
    public void sayHello() {
        System.out.println("Service is working on process with "+ this); //Hello Worldcom.deltacodex.ee.CDI.Service@6c1960fa]] || Hello Worldcom.deltacodex.ee.CDI.Service@723fa27a]]
    }
} //--> Different Objects shows everytime