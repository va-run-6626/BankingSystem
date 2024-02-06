package Repository.LoginRepository;

import Entities.Customer;

import java.sql.SQLException;

public interface ILoginRepository {
    public Object[] retrivePass(String email)throws SQLException;

    Customer getCustomer(String email)throws SQLException;
}
