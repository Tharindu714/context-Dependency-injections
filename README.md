# ☕ Context & Dependency Injection with Java EE (Jakarta EE)

This project demonstrates the power of **Jakarta Contexts and Dependency Injection (CDI)** by implementing a modular and extensible notification system using qualifiers, scopes, and event-based logging.

---

## 📚 Project Overview

The goal of this project is to show how Java EE (Jakarta EE) technologies can be used to create loosely-coupled, pluggable components. Using CDI, it supports injecting different implementations of services like email and SMS notifications based on custom annotations (`@Email`, `@SMS`, `@Console`), and observes events to provide centralized logging.

---

## 🧠 Key Concepts Demonstrated

| Concept                    | Description |
|---------------------------|-------------|
| **CDI (Jakarta EE)**      | Enables dependency injection and event-based communication between loosely coupled components. |
| **Custom Qualifiers**     | `@Email`, `@SMS`, `@Console` used to differentiate between multiple implementations of an interface. |
| **Dependency Injection**  | Beans like `EmailNotifier` and `SMSNotifier` are injected wherever required. |
| **ApplicationScoped Beans** | Managed bean lifecycle across the application. |
| **Event Observers**       | Centralized logging by observing fired events. |

---

## 🧱 Project Structure

```

Context & Dependency Injection/
├── CDIModule/
│   ├── src/
│   │   ├── main/java/com/deltacodex/ee/
│   │   │   ├── annotation/              # Contains custom qualifier annotations
│   │   │   │   ├── Console.java
│   │   │   │   ├── Email.java
│   │   │   │   └── SMS.java
│   │   │   ├── CDI/                     # CDI beans and services
│   │   │   │   ├── EmailNotifier.java
│   │   │   │   ├── SMSNotifier.java
│   │   │   │   ├── NotificationService.java
│   │   │   │   ├── Service.java
│   │   │   │   └── Logger.java
│   │   │   └── ejb/                     # EJB session beans (e.g., UserRegistration)
│   │   │       └── UserRegistrationSessionBean.java
│   └── pom.xml                          # Maven configuration for building the module

````

---

## 🔍 Key Files Explained

### 1. `@Email`, `@SMS`, `@Console`
- These are **custom CDI qualifiers** to distinguish between different injectable implementations.
- Example use: `@Inject @Email NotificationService service;`

### 2. `EmailNotifier.java`
```java
@Email
@ApplicationScoped
public class EmailNotifier implements NotificationService {
    public void sendNotification(String message) {
        System.out.println("Email Notifier Sending Email... " + message);
    }
}
````

* Injected where `@Email` is specified.
* Prints a mock email-sending log to the console.

### 3. `Logger.java`

```java
@ApplicationScoped
public class Logger {
    public void log(@Observes String message) {
        System.out.println("Logged :" + message);
    }

    public void logText(@Observes @Console String message) {
        System.out.println("Text Logged :" + message);
    }
}
```

* This bean listens for fired string events and logs them.
* Demonstrates **event-based communication** in CDI.

---

## 🏗️ How to Build and Run

### ✅ Prerequisites

* Java 11+
* Maven
* GlassFish 5 or 6 (for Jakarta EE support)

### 🔧 Build

```bash
cd "Context & Dependency Injection/CDIModule"
mvn clean install
```

### 🚀 Deploy

1. Deploy the `.war` or `.ear` (depending on your configuration) to a Jakarta EE compatible server like **GlassFish**.
2. Use the Admin Console or `asadmin` CLI tool for deployment.

---

## 🤖 How It Works (Example Flow)

1. You inject `NotificationService` with a qualifier like `@Email` or `@SMS`.
2. When `sendNotification("Hello!")` is called:

   * `EmailNotifier` prints: `"Email Notifier Sending Email... Hello!"`
3. If a `String` event is fired:

   * `Logger` automatically logs: `"Logged :Hello!"`
   * If qualified with `@Console`, `logText()` is used.

---

## 💡 Use Case Ideas

* User registration systems sending confirmation via Email/SMS
* Plugin-based notification architecture
* Event-driven auditing/logging system

---

## 📜 License

This project is intended for educational and demonstration purposes only. No commercial license included.

---

## 👨‍💻 Author

**DeltaCodex** – Java EE Demonstration Repository
Feel free to fork, star ⭐, or contribute!
