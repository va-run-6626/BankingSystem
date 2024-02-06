package Services.LoginServices;

import Services.AccountServices.AccountService;
import Services.UserServices.CustomerServices.CustomerService;

import java.util.Scanner;

public class CustomerLoginService {
    private Scanner scanner;
    private AccountService accountService;
    private CustomerService customerService;
    public CustomerLoginService(Scanner scanner){
        this.scanner = scanner;
        initializeServices();
    }
    private void initializeServices(){
        accountService = new AccountService();
        customerService = new CustomerService(scanner);
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
            this.customerService.menu(email);
        }else{
            System.out.println("Username or Password is incorrect !!");
        }
    }
}
