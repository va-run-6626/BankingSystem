package Services.UserServices.EmployeeServices;

import Services.UserServices.CustomerServices.CustomerAccountStatusService.StatusService;

import java.util.Scanner;

public class EmployeeService {
    private Scanner scanner;
    private ListUserService listUserService;
    private StatusService statusService;
    public EmployeeService(Scanner scanner){
        this.scanner = scanner;
        initailaizeEmployeeService();;
    }
    private void initailaizeEmployeeService(){
        this.listUserService = new ListUserService();
        this.statusService = new StatusService();
    }
    public void menu(){
       while (true){
           System.out.println("Choose from the Following Options : ");
           System.out.println("1. List Users ");
           System.out.println("2. User Status");
           System.out.println("3. User Statement");
           System.out.print("Choice :");
           int choice = this.scanner.nextInt();
           switch (choice) {
               case 1: {
                   this.listUserService.ListUsers();
                   break;
               }
               case 2:{
                    System.out.println("Give email of user : ");
                    String email = this.scanner.nextLine();
                    this.statusService.getStatus(email);
                    break;
               }
               case 3:{

               }
           }
           System.out.println("Do you want to continue in menu ? (Y/N)");
           String conChoice = this.scanner.nextLine();
           if(conChoice.equals("N") || conChoice.equals("n")){
               break;
           }
       }
    }
}
