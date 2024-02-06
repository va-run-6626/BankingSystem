package Entities;

import Services.AccountServices.AccountService;

public class Account {
    private String name;
    private long accountNumber;
    private String email;
    private double balance;
    private String pin;

    public String getName() {
        return name;
    }

    private void setName(String name) throws NullPointerException{
        if(name.isBlank()){
            throw new NullPointerException("Name Cannot be blank!");
        }
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber() {
        this.accountNumber = generateAccountNumber();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws NullPointerException{
        if(email.isBlank()){
            throw new NullPointerException("Email cannot be blank!");
        }
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) throws ArithmeticException{
        if(balance < 0){
            throw new ArithmeticException("Balance cannot be negative!");
        }
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    private void setPin(String pin) {
        if(pin.isBlank()){
            throw new NullPointerException("Pin cannot be blank!");
        }else if(pin.length() == 4){
            this.pin = pin;
            return;
        }else{
            throw new ArithmeticException("Length needs to be 4");
        }
    }

    public Account(String name, String email, double balance, String pin){
        try {
            setName(name);
            setAccountNumber();
            setEmail(email);
            setBalance(balance);
            setPin(pin);
        }catch (ArithmeticException | NullPointerException e){
            e.printStackTrace();
        }
    }
    private long generateAccountNumber(){
        AccountService accountService = new AccountService();
        return accountService.generateAccountNumber();
    }
}
