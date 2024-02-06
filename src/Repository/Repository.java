package Repository;

import Database.Database;
import Entities.Customer;
import Entities.Employee;
import Repository.EmployeeMenuServicesRepository.IListUserRepository;
import Repository.EmployeeMenuServicesRepository.ListUserRepository;
import Repository.LoginRepository.LoginRepository;
import Repository.LoginRepository.ILoginRepository;
import Repository.UserMenuServices.IStatusRepository;
import Repository.UserMenuServices.ITransactionRepository;
import Repository.UserMenuServices.StatusRepository;
import Repository.UserMenuServices.TransactionRepository;
import Repository.UserRegisterRepository.UserRegisterRepository;
import Repository.UserRegisterRepository.IUserRegisterRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Repository {
    private Connection bankingConnection;
    private Connection statementConnection;
    private IUserRegisterRepository userRegisterRepository;
    private ILoginRepository loginRepository;
    private IStatusRepository statusService;
    private IListUserRepository listUserRepository;
    private ITransactionRepository transactionRepository;
    public Repository() {
        this.bankingConnection = Database.getInstance().getBankingConnection();
        this.statementConnection = Database.getInstance().getStatementConnection();
        initalizeRepository();
    }
    private void initalizeRepository(){
        this.userRegisterRepository = new UserRegisterRepository(bankingConnection,statementConnection);
        this.loginRepository = new LoginRepository(bankingConnection);
        this.statusService = new StatusRepository(bankingConnection);
        this.listUserRepository = new ListUserRepository(bankingConnection);
        this.transactionRepository = new TransactionRepository(bankingConnection,statementConnection);
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

    public List<Object[]> listUser() throws SQLException{
        return this.listUserRepository.listUser();
    }

    public Customer getCustomer(String email) throws SQLException{
        return this.loginRepository.getCustomer(email);
    }

    public boolean credit(double amount, Customer customer) throws SQLException {
        return this.transactionRepository.credit(amount,customer);
    }
}
