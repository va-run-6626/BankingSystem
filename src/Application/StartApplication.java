package Application;

import Database.Database;
import Repository.Repository;
import Services.Service;

import java.util.Scanner;

public class StartApplication {
    private final Database database;
    private Scanner scanner;
    private Service service;
    public StartApplication(){
        database = Database.getInstance();
        this.scanner = new Scanner(System.in);
        this.service = new Service(scanner);
    }
    public void start(){
        System.out.println("Choose one of the following options :");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Choice : ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                service.login();
                break;
            }
            case 2:{
                service.register();
                break;
            }
        }
    }
}
