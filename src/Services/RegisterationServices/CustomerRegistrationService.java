package Services.RegisterationServices;

import Entities.Customer;
import Services.AccountServices.AccountService;

import java.util.Scanner;

public class CustomerRegistrationService {
    private Scanner scanner;
    private AccountService accountService;
    public CustomerRegistrationService(Scanner scanner){
        this.scanner = scanner;
        initializeServices();
    }
    private void initializeServices(){
        accountService = new AccountService();
    }
    public void register(){
        System.out.println("Please Enter the Credentials -->");
        System.out.print("Name :");
        this.scanner.nextLine();
        String name = this.scanner.nextLine();
        System.out.print("Email :");
        String email = this.scanner.nextLine();
        System.out.print("Password :");
        String password = this.scanner.nextLine();
        System.out.print("Balance :");
        double balance = this.scanner.nextDouble();
        System.out.print("Set Pin :");
        this.scanner.nextLine();
        String pin = this.scanner.nextLine();
        Customer customer = new Customer(name,email,password,balance,pin);
        this.accountService.registerCustomer(customer);

    }
}
