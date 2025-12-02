package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

@WebService( serviceName = "BankAccount")
public class BankAccountService {

    @WebMethod ( operationName = "converToDHS")
    public double converteToDh(@WebParam( name =  "amount" ) double amount) {
        return amount * 11;
    }

    @WebMethod ( operationName = "account")
    public Account getAccount(@WebParam( name = "code") int code ){
        return new Account(212423, code, new Date() );
    }

    @WebMethod ( operationName = "AllAccount")
    public List<Account> getAccounts(){
        return List.of(
                new Account(212423, 101, new Date() ),
                new Account(2423, 404, new Date() ),
                new Account(10000, 500, new Date() )

        );
    }
}
