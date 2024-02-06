package Services.UserServices.CustomerServices;

import Entities.Customer;
import Services.UserServices.CustomerServices.CustomerAccountStatusService.StatusService;
import Services.UserServices.CustomerServices.CustomerAccountStatusService.TransactionService;

import java.util.Scanner;

public class CustomerService {
    private Scanner scanner;
    private Customer customer;
    private StatusService statusService;
    private TransactionService transactionService;
    public CustomerService(Scanner scanner,Customer customer){
        this.scanner = scanner;
        this.customer = customer;
        initalizeServices();
    }
    private void initalizeServices(){
        this.statusService = new StatusService();
        this.transactionService = new TransactionService(scanner);
    }
    public void menu(Customer customer){
        while(true) {
            System.out.println("Choose from the Following Options : ");
            System.out.println("1. Account status");
            System.out.println("2. Transaction");
            System.out.println("3. statement");
            System.out.print("Choice :");
            int choice = this.scanner.nextInt();
            switch (choice) {
                case 1: {
                    this.statusService.getStatus(customer.getEmail());
                    break;
                }
                case 2:{
                    this.transactionService.transactionMenu(customer);
                    break;
                }
                default:{
                    System.out.println("Invalid Option .....");
                }
            }
            System.out.println("Do you want to continue in Menu ? (Y/N)");
            String choiceCon = this.scanner.nextLine();
            if(choiceCon.equals("N") || choiceCon.equals("n")){
                break;
            }
        }
    }
}
