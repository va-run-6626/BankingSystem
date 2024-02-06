package Services.UserServices.CustomerServices;

import Services.UserServices.CustomerServices.CustomerAccountStatusService.StatusService;

import java.util.Scanner;

public class CustomerService {
    private Scanner scanner;
    private StatusService statusService;
    public CustomerService(Scanner scanner){
        this.scanner = scanner;
        initalizeServices();
    }
    private void initalizeServices(){
        this.statusService = new StatusService();
    }
    public void menu(String email){
        while(true) {
            System.out.println("Choose from the Following Options : ");
            System.out.println("1. Account status");
            System.out.println("2. Transaction");
            System.out.println("3. statement");
            System.out.print("Choice :");
            int choice = this.scanner.nextInt();
            switch (choice) {
                case 1: {
                    this.statusService.getStatus(email);
                    break;
                }
                case 2:{

                }
            }
        }
    }
}
