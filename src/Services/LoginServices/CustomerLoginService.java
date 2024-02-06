package Services.LoginServices;

import Entities.Customer;
import Services.AccountServices.AccountService;
import Services.UserServices.CustomerServices.CustomerService;

import java.util.Scanner;

public class CustomerLoginService {
    private Scanner scanner;
    private AccountService accountService;
    private CustomerService customerService;
    private Customer customer;
    public CustomerLoginService(Scanner scanner){
        this.scanner = scanner;
        initializeServices();
    }
    private void initializeServices(){
        accountService = new AccountService();
        customerService = new CustomerService(scanner,customer);
    }
    public void login(){
        System.out.println("Please Enter the Credentials -->");
        System.out.print("Email :");
        this.scanner.nextLine();
        String email = this.scanner.nextLine();
        System.out.print("Password :");
        String password = this.scanner.nextLine();
        boolean check = this.accountService.login(email,password,false);
        if(check){
            customer = this.accountService.getCustomer(email);
            this.customerService.menu(customer);
        }else{
            System.out.println("Username or Password is incorrect !!");
        }
    }
}
