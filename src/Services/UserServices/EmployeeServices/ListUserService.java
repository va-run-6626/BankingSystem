package Services.UserServices.EmployeeServices;

import Repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ListUserService {
    private Repository repository;
    public ListUserService listUserService;
    public ListUserService(){
        this.repository = new Repository();
    }
    public void ListUsers(){
        try {
            List<Object[]> answer = this.repository.listUser();
            if(answer == null){
                System.out.println("Listing Failed!!");
                return;
            }
            System.out.println("List Of Users :");
            System.out.println("===================================================================");
            System.out.println("+-----------------+----------------------+--------------------------------+------------+");
            System.out.println("|   Account Number|        Name          |            Email               |  Balance   |");
            System.out.println("+-----------------+----------------------+--------------------------------+------------+");
            for(Object[] object : answer){
                long accountNo = (long) object[0];
                String name = (String) object[1];
                String email = (String) object[2];
                double balance = (double) object[3];

                System.out.printf("| %-15s | %-20s | %-30s | %10.2f |\n", accountNo, name, email, balance);
                System.out.println("+-----------------+----------------------+--------------------------------+------------+");
            }
            System.out.println("+-----------------+----------------------+--------------------------------+------------+");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
