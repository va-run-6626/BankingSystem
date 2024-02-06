package Services.LoginServices;

import Services.AccountServices.AccountService;
import Services.UserServices.EmployeeServices.EmployeeService;

import java.util.Scanner;

public class EmployeeLoginService {
    private Scanner scanner;
    private AccountService accountService;
    private EmployeeService employeeService;

    public EmployeeLoginService(Scanner scanner){
        this.scanner = scanner;
        initalizeServices();
    }
    private void initalizeServices(){
        accountService = new AccountService();
        employeeService = new EmployeeService(scanner);
    }
    public void login(){
        System.out.println("Please Enter the Credentials -->");
        System.out.print("Email :");
        this.scanner.nextLine();
        String email = this.scanner.nextLine();
        System.out.print("Password :");
        String password = this.scanner.nextLine();
        boolean check = this.accountService.login(email,password,true);
        if(check){
            this.employeeService.menu();
        }else{
            System.out.println("Username or Password is incorrect !!");
        }
    }
}
