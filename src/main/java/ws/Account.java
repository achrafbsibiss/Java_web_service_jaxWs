package ws;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement(name = "Account")
@XmlType(name = "AccountType")   // <-- avoid DEFAULT name "account"
public class Account {

    private double sould;
    private int code;
    private Date createAt ;

    public Account() {}   // REQUIRED by JAXB

    public Account(double sould, int code, Date createAt){
        this.sould = sould;
        this.code = code;
        this.createAt = createAt;
    }

    public double getSould() {
        return sould;
    }

    public void setSould(double sould) {
        this.sould = sould;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void retreive(double retreive ){
        setSould( getSould() -  retreive );
    }

    public void addSold(double add){
        setSould(getSould() + add);
    }
}
