package Services.UserServices.EmployeeServices;

import java.util.Scanner;

public class EmployeeService {
    private Scanner scanner;
    public EmployeeService(Scanner scanner){
        this.scanner = scanner;
    }
    public void menu(){
        System.out.println("In Employee Menu");
    }
}
