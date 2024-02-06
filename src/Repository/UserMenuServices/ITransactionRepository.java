package Repository.UserMenuServices;

import Entities.Customer;

import java.sql.SQLException;

public interface ITransactionRepository {
    public boolean credit(double amount, Customer customer) throws SQLException;
    public boolean debit(double amount,Customer customer) throws SQLException;
    public boolean transfer(double amount, Customer customer) throws SQLException;
}
