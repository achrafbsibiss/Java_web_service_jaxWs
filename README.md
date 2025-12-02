# Bank Account SOAP Web Service

A simple Java-based SOAP web service for bank account operations, built with Jakarta XML Web Services (JAX-WS) and JAXB.

## 📋 Overview

This project demonstrates a RESTful-style SOAP web service that provides banking operations including currency conversion and account management. The service is designed to be consumed using SOAP clients like SoapUI.

## 🚀 Features

- **Currency Conversion**: Convert amounts to Moroccan Dirham (DHS)
- **Account Retrieval**: Get individual account details by code
- **List All Accounts**: Retrieve all available accounts
- JAXB XML serialization with custom type definitions
- Simple deployment with built-in HTTP server

## 📁 Project Structure

```
src/
├── ws/
│   ├── BankAccountService.java    # Main SOAP service
│   └── Account.java                # Account model with JAXB annotations
└── WebService.java                 # Service publisher/entry point
```

## 🛠️ Technologies

- **Java** (JDK 11+)
- **Jakarta XML Web Services (JAX-WS)** - SOAP implementation
- **Jakarta XML Binding (JAXB)** - XML serialization
- **Built-in HTTP Server** - Lightweight deployment

## 📦 Dependencies

Add these dependencies to your `pom.xml`:

```xml
<dependencies>
    <!-- Jakarta XML Web Services API -->
    <dependency>
        <groupId>jakarta.xml.ws</groupId>
        <artifactId>jakarta.xml.ws-api</artifactId>
        <version>4.0.0</version>
    </dependency>
    
    <!-- Jakarta XML Binding API -->
    <dependency>
        <groupId>jakarta.xml.bind</groupId>
        <artifactId>jakarta.xml.bind-api</artifactId>
        <version>4.0.0</version>
    </dependency>
    
    <!-- JAX-WS Runtime -->
    <dependency>
        <groupId>com.sun.xml.ws</groupId>
        <artifactId>jaxws-rt</artifactId>
        <version>4.0.0</version>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

## 🏃 Running the Service

1. **Compile the project**:
   ```bash
   javac -cp ".:lib/*" ws/*.java WebService.java
   ```

2. **Run the service**:
   ```bash
   java -cp ".:lib/*" WebService
   ```

3. **Verify the service is running**:
   ```
   Bank Account Service is published http://0.0.0.0:8080/
   ```

4. **Access the WSDL**:
   Open your browser and navigate to:
   ```
   http://localhost:8080/?wsdl
   ```

## 🧪 Testing with SoapUI

### 1. Create a New SOAP Project

1. Open SoapUI
2. Click **File** → **New SOAP Project**
3. Enter the WSDL URL: `http://localhost:8080/?wsdl`
4. Click **OK**

### 2. Test Operations

#### **Convert to DHS**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws/">
   <soapenv:Header/>
   <soapenv:Body>
      <ws:converToDHS>
         <amount>100</amount>
      </ws:converToDHS>
   </soapenv:Body>
</soapenv:Envelope>
```

**Expected Response**:
```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:converToDHSResponse xmlns:ns2="http://ws/">
         <return>1100.0</return>
      </ns2:converToDHSResponse>
   </S:Body>
</S:Envelope>
```

#### **Get Account by Code**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws/">
   <soapenv:Header/>
   <soapenv:Body>
      <ws:account>
         <code>101</code>
      </ws:account>
   </soapenv:Body>
</soapenv:Envelope>
```

#### **Get All Accounts**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws/">
   <soapenv:Header/>
   <soapenv:Body>
      <ws:AllAccount/>
   </soapenv:Body>
</soapenv:Envelope>
```

## 📊 API Operations

| Operation | Parameter | Returns | Description |
|-----------|-----------|---------|-------------|
| `converToDHS` | `amount` (double) | double | Converts amount to DHS (×11) |
| `account` | `code` (int) | Account | Returns account by code |
| `AllAccount` | - | List<Account> | Returns all accounts |

## 📝 Account Model

```java
public class Account {
    private double sould;      // Account balance
    private int code;          // Account code
    private Date createAt;     // Creation date
    
    // Methods
    void retreive(double amount)  // Withdraw
    void addSold(double amount)   // Deposit
}
```

## 🔧 Configuration

- **Host**: `0.0.0.0` (all interfaces)
- **Port**: `8080`
- **Service Name**: `BankAccount`
- **Exchange Rate**: 1 USD = 11 DHS

To change the port or host, modify this line in `WebService.java`:
```java
String host = "http://0.0.0.0:8080/";
```

## 📸 Screenshots

### Service Running
![Screenshot 2025-12-02 at 20.48.34.png](../../../../../var/folders/57/h7z_gbn13058hxx51k0_j8ym0000gn/T/TemporaryItems/NSIRD_screencaptureui_AkbkGf/Screenshot%202025-12-02%20at%2020.48.34.png)

### SoapUI Testing
![SoapUI Testing](screenshots/soapui-testing.png)

### WSDL View
![WSDL View](screenshots/wsdl-view.png)

## ⚠️ Important Notes

- The `Account` class requires a **no-arg constructor** for JAXB serialization
- `@XmlRootElement` and `@XmlType` annotations prevent naming conflicts
- The service uses hardcoded sample data (not connected to a real database)
- Port 8080 must be available on your system

## 🐛 Troubleshooting

**Service won't start**:
- Check if port 8080 is already in use
- Verify all Jakarta dependencies are in classpath

**WSDL not accessible**:
- Ensure service is running (`Bank Account Service is published` message)
- Try `http://127.0.0.1:8080/?wsdl` instead of `localhost`

**SoapUI connection errors**:
- Check firewall settings
- Verify the service is bound to the correct network interface

## 📚 Further Development

Potential enhancements:
- Add database integration (JPA/Hibernate)
- Implement authentication and authorization
- Add exception handling and custom fault messages
- Create unit tests with JAX-WS test utilities
- Add logging (SLF4J/Logback)

