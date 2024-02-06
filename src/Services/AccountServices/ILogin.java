package Services.AccountServices;

import Entities.Customer;

import java.sql.SQLException;

public interface ILogin {
    public boolean login(String email, String password,boolean isEmployee);

    Customer getCustomer(String email);
}
