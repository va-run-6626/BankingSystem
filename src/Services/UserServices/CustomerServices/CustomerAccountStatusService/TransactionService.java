package Services.UserServices.CustomerServices.CustomerAccountStatusService;

import Entities.Customer;
import Repository.Repository;

import java.sql.SQLException;
import java.util.Scanner;

public class TransactionService {
    private Repository repository;
    private Scanner scanner;
    public TransactionService(Scanner scanner){
        this.repository = new Repository();
        this.scanner = scanner;
    }
    public void credit(Customer customer){
        System.out.print("Enter the amount to be credited :");
        double amount = scanner.nextDouble();
        System.out.print("Enter pin :");
        String pin = scanner.nextLine();
        if(amount < 0){
            System.out.println("Invalid amount --> should be greater than 0");
        }else{
            if(pin.equals(customer.getAccount().getPin())){
                System.out.println("Invalid Pin!!");
            }else{
                try {
                    boolean credited = this.repository.credit(amount,customer);
                    if(credited){
                        System.out.println("Amount credited Successfully!!");
                    }else{
                        System.out.println("Deposit Failed!!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void transactionMenu(Customer customer) {
        while(true) {
            System.out.println("Choose from the Following Options : ");
            System.out.println("1. Credit");
            System.out.println("2. Debit");
            System.out.println("3. Transfer");
            System.out.print("Choice :");
            int choice = this.scanner.nextInt();
            switch (choice) {
                case 1: {

                    break;
                }
                case 2:{

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
