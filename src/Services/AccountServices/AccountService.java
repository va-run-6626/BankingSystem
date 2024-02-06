package Services.AccountServices;

import Entities.Customer;
import Entities.Employee;

public class AccountService {
    private RegisterUserAccountService registerUserAccount;
    private LoginUserAccountService loginUserAccountService;
    public AccountService(){
        initalizeAccountServices();
    }
    private void initalizeAccountServices(){
        this.registerUserAccount = new RegisterUserAccountService();
        this.loginUserAccountService = new LoginUserAccountService();
    }
    public void registerCustomer(Customer customer){
        this.registerUserAccount.registerCustomer(customer);
    }
    public long generateAccountNumber(){
        return this.registerUserAccount.generateAccountNumber();
    }
    public void registerEmployee(Employee employee){
        this.registerUserAccount.registerEmployee(employee);
    }
    public boolean login(String email, String password, boolean isEmployee){
        return this.loginUserAccountService.login(email,password,isEmployee);
    }
}
