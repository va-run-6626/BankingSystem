package Services.UserServices.CustomerServices.CustomerAccountStatusService;

import Repository.Repository;

import java.sql.SQLException;
import java.sql.SQLOutput;

public class StatusService {
    private Repository repository;
    public StatusService(){
        this.repository = new Repository();
    }
    public void getStatus(String email){
        try {
            Object[] status = this.repository.getCustomerStatus(email);
            if(status == null){
                System.out.println("No Status Found");
            }else{
                long accountNo = (long) status[0];
                String name = (String) status[1];
                String mail = (String) status[2];
                double balance = (double) status[3];

                printStatus(accountNo,name,mail,balance);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void printStatus(long accountNo, String name, String mail, double balance) {
        System.out.println("========================================");
        System.out.println("Name : " + name);
        System.out.println("Account Number :" + accountNo);
        System.out.println("Mail ID : " + mail);
        System.out.println("Balance : " + balance);
        System.out.println("========================================");
    }

}
