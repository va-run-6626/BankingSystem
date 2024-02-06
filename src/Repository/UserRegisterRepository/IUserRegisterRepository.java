package Repository.UserRegisterRepository;

import Entities.Customer;
import Entities.Employee;
import Entities.User;

import java.sql.SQLException;

public interface IUserRegisterRepository {
    public void registerUser(Customer customer)throws SQLException;
    public long generateAccountNumber() throws SQLException;

    public void registerEmployee(Employee employee) throws SQLException;
}
