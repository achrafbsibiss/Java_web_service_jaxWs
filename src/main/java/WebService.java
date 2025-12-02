import jakarta.xml.ws.Endpoint;
import ws.BankAccountService;

public class WebService {
    public static void main( String[] args ){
        String host = "http://0.0.0.0:8080/";

        Endpoint.publish( host, new BankAccountService());

        System.out.println("Bank Account Service is published " + host);
    }
}
