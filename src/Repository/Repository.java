package Repository;

import Database.Database;
import Entities.Customer;
import Entities.Employee;
import Repository.LoginRepository.LoginRepository;
import Repository.LoginRepository.ILoginRepository;
import Repository.UserMenuServices.StatusRepository;
import Repository.UserRegisterRepository.UserRegisterRepository;
import Repository.UserRegisterRepository.IUserRegisterRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class Repository {
    private Connection bankingConnection;
    private Connection statementConnection;
    private IUserRegisterRepository userRegisterRepository;
    private ILoginRepository loginRepository;
    private StatusRepository statusService;
    public Repository() {
        this.bankingConnection = Database.getInstance().getBankingConnection();
        this.statementConnection = Database.getInstance().getStatementConnection();
        initalizeRepository();
    }
    private void initalizeRepository(){
        this.userRegisterRepository = new UserRegisterRepository(bankingConnection);
        this.loginRepository = new LoginRepository(bankingConnection);
        this.statusService = new StatusRepository(bankingConnection);
    }
    public void registerCustomer(Customer customer) throws SQLException {
        userRegisterRepository.registerUser(customer);
    }
    public long generateAccountNumber()throws SQLException{
        return userRegisterRepository.generateAccountNumber();
    }
    public void registerEmployee(Employee employee) throws SQLException{
        userRegisterRepository.registerEmployee(employee);
    }
    public Object[] getPassForCheck(String email)throws SQLException{
        return loginRepository.retrivePass(email);
    }
    public Object[] getCustomerStatus(String email)throws SQLException{
        return this.statusService.getStatus(email);
    }
}
