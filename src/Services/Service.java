package Services;

import Services.LoginServices.CustomerLoginService;
import Services.LoginServices.EmployeeLoginService;
import Services.RegisterationServices.CustomerRegistrationService;
import Services.RegisterationServices.EmployeeRegistrationService;

import java.util.Scanner;

public class Service {
    private final Scanner scanner;
    private CustomerRegistrationService customerRegistrationService;
    private EmployeeRegistrationService employeeRegistrationService;
    private CustomerLoginService customerLoginService;
    private EmployeeLoginService employeeLoginService;
    public Service(Scanner scanner){
        this.scanner = scanner;
        initalizeService();
    }
    private void initalizeService(){
        customerRegistrationService = new CustomerRegistrationService(scanner);
        employeeRegistrationService = new EmployeeRegistrationService(scanner);
        customerLoginService = new CustomerLoginService(scanner);
        employeeLoginService = new EmployeeLoginService(scanner);
    }
    public void login(){
        System.out.println("Choose type of Login :");
        System.out.println("1. Customer");
        System.out.println("2. Employee");
        System.out.print("Choice :");
        int choice = this.scanner.nextInt();

        switch (choice){
            case 1:{
                this.customerLoginService.login();
                break;
            }
            case 2:{
                this.employeeLoginService.login();
                break;
            }
        }
    }
    public void register(){
        System.out.println("Choose type of Registration :");
        System.out.println("1. Customer");
        System.out.println("2. Employee");
        System.out.print("Choice :");
        int choice = this.scanner.nextInt();

        switch (choice){
            case 1:{
                customerRegistrationService.register();
                break;
            }
            case 2:{
                employeeRegistrationService.register();
                break;
            }
        }
    }
}
