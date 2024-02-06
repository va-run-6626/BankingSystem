package Services.RegisterationServices;

import Entities.Employee;
import Services.AccountServices.AccountService;

import java.util.Scanner;

public class EmployeeRegistrationService {
    private Scanner scanner;
    private AccountService accountService;
    public EmployeeRegistrationService(Scanner scanner){
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
        Employee employee = new Employee(name,email,password);
        this.accountService.registerEmployee(employee);

    }
}
