package Entities;

public class Customer extends User{
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(String name, String email, double balance,String pin) {
        this.account = new Account(name,email,balance,pin);
    }

    public Customer(String name, String email, String password,double balance,String pin) throws NullPointerException {
        super(name, email, password, false);
        setAccount(name,email,balance,pin);
    }
}
