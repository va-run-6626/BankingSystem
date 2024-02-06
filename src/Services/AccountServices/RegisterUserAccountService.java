package Services.AccountServices;
import Entities.Customer;
import Entities.Employee;
import Repository.Repository;

import java.sql.SQLException;

public class RegisterUserAccountService {
    private Repository repository;
    public RegisterUserAccountService(){
        this.repository = new Repository();
    }
    public void registerCustomer(Customer customer){
        try {
            repository.registerCustomer(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public long generateAccountNumber(){
        try {
            return repository.generateAccountNumber();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void registerEmployee(Employee employee){
        try {
            repository.registerEmployee(employee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
